/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.Frames;

import cinema.Frames.ShowMovies;
import cinema.Objects.Movie;
import cinema.Objects.Seat;
import cinema.Objects.Theatre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ShowSeats extends javax.swing.JFrame {

	private int xMouse;
	private int yMouse;
	private int movieID;
	private int customerID;
	private Movie movie;
	private Connection connection;
	private Theatre theatre;
	private JLabel[] seats;
	private ArrayList<Integer> selectedSeats;
	private ArrayList<Integer> takenSeats;
	private ImageIcon imageIcon;
	private ImageIcon selectedSeatIcon;
	private ImageIcon vacantSeatIcon;
	private ImageIcon takenSeatIcon;
	private String message;
	private PreparedStatement preparedStatement;
	
	public ShowSeats(Connection connection, ImageIcon imageIcon, int movieID, int customerID, Movie movie) {
		initComponents();
		
		this.connection = connection;
		this.imageIcon = imageIcon;
		this.movieID = movieID;
		this.customerID = customerID;
		this.takenSeats = new ArrayList<Integer>();
		this.movie = movie;
		theatre = new Theatre(60);
		vacantSeatIcon = new ImageIcon(getClass().getResource("/cinema/vacant-seat.png"));
		selectedSeatIcon = new ImageIcon(getClass().getResource("/cinema/selected-seat.png"));
		takenSeatIcon = new ImageIcon(getClass().getResource("/cinema/taken-seat.png"));
		theMovieLabel.setText(movie.getTitle()+" ["+movie.getDate()+" - "+movie.getTime()+"]");
		posterLabel.setIcon(imageIcon);
		setSeatsArray();
		getTakenSeats();
		setTakenSeats();
	}
	
	public void setSeatsArray() {
		seats = new JLabel[60];
		seats[0] = seat0;
		//<editor-fold defaultstate="collapsed" desc="and other 59s">
		seats[1] = seat1; seats[2] = seat2; seats[3] = seat3; seats[4] = seat4; seats[5] = seat5;
		seats[6] = seat6; seats[7] = seat7; seats[8] = seat8; seats[9] = seat9; seats[10] = seat10;
		seats[11] = seat11; seats[12] = seat12; seats[13] = seat13; seats[14] = seat14; seats[15] = seat15;
		seats[16] = seat16; seats[17] = seat17; seats[18] = seat18; seats[19] = seat19; seats[20] = seat20;
		seats[21] = seat21; seats[22] = seat22; seats[23] = seat23; seats[24] = seat24; seats[25] = seat25;
		seats[26] = seat26; seats[27] = seat27; seats[28] = seat28; seats[29] = seat29; seats[30] = seat30;
		seats[31] = seat31; seats[32] = seat32; seats[33] = seat33; seats[34] = seat34; seats[35] = seat35;
		seats[36] = seat36; seats[37] = seat37; seats[38] = seat38; seats[39] = seat39; seats[40] = seat40;
		seats[41] = seat41; seats[42] = seat42; seats[43] = seat43; seats[44] = seat44; seats[45] = seat45;
		seats[46] = seat46; seats[47] = seat47; seats[48] = seat48; seats[49] = seat49; seats[50] = seat50;
		seats[51] = seat51; seats[52] = seat52; seats[53] = seat53; seats[54] = seat54; seats[55] = seat55;
		seats[56] = seat56; seats[57] = seat57; seats[58] = seat58; seats[59] = seat59;
		//</editor-fold>
	}
	
	public void getTakenSeats() {
		String query = "select * from sold_tickets where movieID  = ?";
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, movieID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(!takenSeats.isEmpty()) {
				takenSeats.clear(); // clears all movies from the arraylist to make a new start.
			}
			while(resultSet.next()) {
				takenSeats.add(resultSet.getInt("seatNumber")-1);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ShowSeats.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setTakenSeats() {
		for(int counter : takenSeats) {
			seats[counter].setIcon(takenSeatIcon);
			theatre.getSeat(counter).setStatusTaken();
		}
	}
	
	public void getSelectedSeats() {
		selectedSeats = new ArrayList<Integer>();
		for(Seat seat : theatre.getSeats()) {
			if(seat.isSelected()) {
				selectedSeats.add(seat.getNumber());
			}
		}
	}
	
	public void updateMessage() {
		getSelectedSeats();
		message = "Selected Seats : ";
		if(!selectedSeats.isEmpty()) {
			for(int counter : selectedSeats) {
				message = message + " S" + (counter+1);
			}
			selectedSeatsLabel.setText(message);
		}
		else {
			selectedSeatsLabel.setText("");
		}
	}
	
	public void changeImageIcon(int counter) {
		if(!theatre.getSeat(counter).isTaken()) {
				if(theatre.getSeat(counter).isVacant()) {
					seats[counter].setIcon(selectedSeatIcon);
					theatre.getSeat(counter).setStatusSeleted();
				}
				else if(theatre.getSeat(counter).isSelected()) {
					seats[counter].setIcon(vacantSeatIcon);
					theatre.getSeat(counter).setStatusVacant();
				}
		}
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        seatsPanel = new javax.swing.JPanel();
        seat0 = new javax.swing.JLabel();
        seat1 = new javax.swing.JLabel();
        seat2 = new javax.swing.JLabel();
        seat3 = new javax.swing.JLabel();
        seat4 = new javax.swing.JLabel();
        seat5 = new javax.swing.JLabel();
        seat6 = new javax.swing.JLabel();
        seat7 = new javax.swing.JLabel();
        seat8 = new javax.swing.JLabel();
        seat9 = new javax.swing.JLabel();
        seat10 = new javax.swing.JLabel();
        seat11 = new javax.swing.JLabel();
        seat12 = new javax.swing.JLabel();
        seat13 = new javax.swing.JLabel();
        seat14 = new javax.swing.JLabel();
        seat15 = new javax.swing.JLabel();
        seat16 = new javax.swing.JLabel();
        seat17 = new javax.swing.JLabel();
        seat18 = new javax.swing.JLabel();
        seat19 = new javax.swing.JLabel();
        seat20 = new javax.swing.JLabel();
        seat21 = new javax.swing.JLabel();
        seat22 = new javax.swing.JLabel();
        seat23 = new javax.swing.JLabel();
        seat24 = new javax.swing.JLabel();
        seat25 = new javax.swing.JLabel();
        seat26 = new javax.swing.JLabel();
        seat27 = new javax.swing.JLabel();
        seat28 = new javax.swing.JLabel();
        seat29 = new javax.swing.JLabel();
        seat30 = new javax.swing.JLabel();
        seat31 = new javax.swing.JLabel();
        seat32 = new javax.swing.JLabel();
        seat33 = new javax.swing.JLabel();
        seat34 = new javax.swing.JLabel();
        seat35 = new javax.swing.JLabel();
        seat36 = new javax.swing.JLabel();
        seat37 = new javax.swing.JLabel();
        seat38 = new javax.swing.JLabel();
        seat39 = new javax.swing.JLabel();
        seat40 = new javax.swing.JLabel();
        seat41 = new javax.swing.JLabel();
        seat42 = new javax.swing.JLabel();
        seat43 = new javax.swing.JLabel();
        seat44 = new javax.swing.JLabel();
        seat45 = new javax.swing.JLabel();
        seat46 = new javax.swing.JLabel();
        seat47 = new javax.swing.JLabel();
        seat48 = new javax.swing.JLabel();
        seat49 = new javax.swing.JLabel();
        seat50 = new javax.swing.JLabel();
        seat51 = new javax.swing.JLabel();
        seat52 = new javax.swing.JLabel();
        seat53 = new javax.swing.JLabel();
        seat54 = new javax.swing.JLabel();
        seat55 = new javax.swing.JLabel();
        seat56 = new javax.swing.JLabel();
        seat57 = new javax.swing.JLabel();
        seat58 = new javax.swing.JLabel();
        seat59 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        buyTicketButton = new javax.swing.JButton();
        selectedSeatsLabel = new javax.swing.JLabel();
        posterPanel = new javax.swing.JPanel();
        posterLabel = new javax.swing.JLabel();
        vacantImageLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vacantImageLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        vacantImageLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        theMovieLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cinema - Select A Seat");

        MainPanel.setBackground(new java.awt.Color(231, 232, 235));
        MainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MainPanelMouseDragged(evt);
            }
        });
        MainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MainPanelMousePressed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        seatsPanel.setBackground(new java.awt.Color(217, 193, 183));

        seat0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat0MouseClicked(evt);
            }
        });

        seat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat1MouseClicked(evt);
            }
        });

        seat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat2MouseClicked(evt);
            }
        });

        seat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat3MouseClicked(evt);
            }
        });

        seat4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat4MouseClicked(evt);
            }
        });

        seat5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat5MouseClicked(evt);
            }
        });

        seat6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat6MouseClicked(evt);
            }
        });

        seat7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat7MouseClicked(evt);
            }
        });

        seat8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat8MouseClicked(evt);
            }
        });

        seat9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat9MouseClicked(evt);
            }
        });

        seat10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat10MouseClicked(evt);
            }
        });

        seat11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat11MouseClicked(evt);
            }
        });

        seat12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat12MouseClicked(evt);
            }
        });

        seat13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat13MouseClicked(evt);
            }
        });

        seat14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat14MouseClicked(evt);
            }
        });

        seat15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat15MouseClicked(evt);
            }
        });

        seat16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat16MouseClicked(evt);
            }
        });

        seat17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat17MouseClicked(evt);
            }
        });

        seat18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat18MouseClicked(evt);
            }
        });

        seat19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat19MouseClicked(evt);
            }
        });

        seat20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat20MouseClicked(evt);
            }
        });

        seat21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat21MouseClicked(evt);
            }
        });

        seat22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat22MouseClicked(evt);
            }
        });

        seat23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat23MouseClicked(evt);
            }
        });

        seat24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat24MouseClicked(evt);
            }
        });

        seat25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat25MouseClicked(evt);
            }
        });

        seat26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat26MouseClicked(evt);
            }
        });

        seat27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat27MouseClicked(evt);
            }
        });

        seat28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat28MouseClicked(evt);
            }
        });

        seat29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat29MouseClicked(evt);
            }
        });

        seat30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat30MouseClicked(evt);
            }
        });

        seat31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat31MouseClicked(evt);
            }
        });

        seat32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat32MouseClicked(evt);
            }
        });

        seat33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat33MouseClicked(evt);
            }
        });

        seat34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat34MouseClicked(evt);
            }
        });

        seat35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat35MouseClicked(evt);
            }
        });

        seat36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat36MouseClicked(evt);
            }
        });

        seat37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat37MouseClicked(evt);
            }
        });

        seat38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat38MouseClicked(evt);
            }
        });

        seat39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat39MouseClicked(evt);
            }
        });

        seat40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat40MouseClicked(evt);
            }
        });

        seat41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat41MouseClicked(evt);
            }
        });

        seat42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat42MouseClicked(evt);
            }
        });

        seat43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat43MouseClicked(evt);
            }
        });

        seat44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat44MouseClicked(evt);
            }
        });

        seat45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat45MouseClicked(evt);
            }
        });

        seat46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat46MouseClicked(evt);
            }
        });

        seat47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat47MouseClicked(evt);
            }
        });

        seat48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat48MouseClicked(evt);
            }
        });

        seat49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat49MouseClicked(evt);
            }
        });

        seat50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat50MouseClicked(evt);
            }
        });

        seat51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat51MouseClicked(evt);
            }
        });

        seat52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat52MouseClicked(evt);
            }
        });

        seat53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat53MouseClicked(evt);
            }
        });

        seat54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat54MouseClicked(evt);
            }
        });

        seat55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat55MouseClicked(evt);
            }
        });

        seat56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat56MouseClicked(evt);
            }
        });

        seat57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat57MouseClicked(evt);
            }
        });

        seat58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat58MouseClicked(evt);
            }
        });

        seat59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat59MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/screen.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(122, 24, 26));
        jLabel2.setText("1");

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(122, 24, 26));
        jLabel6.setText("SCREEN");

        jLabel7.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(122, 24, 26));
        jLabel7.setText("12");

        jLabel8.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(122, 24, 26));
        jLabel8.setText("13");

        jLabel9.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(122, 24, 26));
        jLabel9.setText("24");

        jLabel10.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(122, 24, 26));
        jLabel10.setText("25");

        jLabel11.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(122, 24, 26));
        jLabel11.setText("36");

        jLabel12.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(122, 24, 26));
        jLabel12.setText("37");

        jLabel13.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(122, 24, 26));
        jLabel13.setText("48");

        jLabel14.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(122, 24, 26));
        jLabel14.setText("49");

        jLabel15.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(122, 24, 26));
        jLabel15.setText("60");

        javax.swing.GroupLayout seatsPanelLayout = new javax.swing.GroupLayout(seatsPanel);
        seatsPanel.setLayout(seatsPanelLayout);
        seatsPanelLayout.setHorizontalGroup(
            seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seatsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
            .addGroup(seatsPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seatsPanelLayout.createSequentialGroup()
                        .addComponent(seat24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(seatsPanelLayout.createSequentialGroup()
                        .addComponent(seat0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat9)
                        .addGap(12, 12, 12)
                        .addComponent(seat10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(seatsPanelLayout.createSequentialGroup()
                        .addComponent(seat12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(seatsPanelLayout.createSequentialGroup()
                        .addComponent(seat36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(seatsPanelLayout.createSequentialGroup()
                        .addComponent(seat48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seatsPanelLayout.createSequentialGroup()
                    .addContainerGap(260, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(236, 236, 236)))
        );
        seatsPanelLayout.setVerticalGroup(
            seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seatsPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seat5)
                    .addComponent(seat4)
                    .addComponent(seat3)
                    .addComponent(seat2)
                    .addComponent(seat1)
                    .addComponent(seat0)
                    .addComponent(seat6)
                    .addComponent(seat7)
                    .addComponent(seat8)
                    .addComponent(seat10)
                    .addComponent(seat11)
                    .addComponent(seat9)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seat12)
                    .addComponent(seat13)
                    .addComponent(seat14)
                    .addComponent(seat15)
                    .addComponent(seat16)
                    .addComponent(seat17)
                    .addComponent(seat18)
                    .addComponent(seat19)
                    .addComponent(seat20)
                    .addComponent(seat21)
                    .addComponent(seat22)
                    .addComponent(seat23)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seat24)
                    .addComponent(seat25)
                    .addComponent(seat26)
                    .addComponent(seat27)
                    .addComponent(seat28)
                    .addComponent(seat29)
                    .addComponent(seat30)
                    .addComponent(seat31)
                    .addComponent(seat32)
                    .addComponent(seat33)
                    .addComponent(seat34)
                    .addComponent(seat35)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seat36)
                    .addComponent(seat37)
                    .addComponent(seat38)
                    .addComponent(seat39)
                    .addComponent(seat40)
                    .addComponent(seat41)
                    .addComponent(seat42)
                    .addComponent(seat43)
                    .addComponent(seat44)
                    .addComponent(seat45)
                    .addComponent(seat46)
                    .addComponent(seat47)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seat48)
                    .addComponent(seat49)
                    .addComponent(seat50)
                    .addComponent(seat51)
                    .addComponent(seat52)
                    .addComponent(seat53)
                    .addComponent(seat54)
                    .addComponent(seat55)
                    .addComponent(seat56)
                    .addComponent(seat57)
                    .addComponent(seat58)
                    .addComponent(seat59)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(24, 24, 24))
            .addGroup(seatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seatsPanelLayout.createSequentialGroup()
                    .addContainerGap(308, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(58, 58, 58)))
        );

        buyTicketButton.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        buyTicketButton.setText("Buy Ticket");
        buyTicketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyTicketButtonActionPerformed(evt);
            }
        });

        selectedSeatsLabel.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        selectedSeatsLabel.setForeground(new java.awt.Color(122, 24, 26));

        posterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/logo.png"))); // NOI18N
        posterLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout posterPanelLayout = new javax.swing.GroupLayout(posterPanel);
        posterPanel.setLayout(posterPanelLayout);
        posterPanelLayout.setHorizontalGroup(
            posterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(posterPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(posterLabel)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        posterPanelLayout.setVerticalGroup(
            posterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(posterLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        vacantImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(122, 24, 26));
        jLabel3.setText("Vacant");

        vacantImageLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/selected-seat.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(122, 24, 26));
        jLabel4.setText("Selected");

        vacantImageLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/taken-seat.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(122, 24, 26));
        jLabel5.setText("Taken");

        theMovieLabel.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        theMovieLabel.setForeground(new java.awt.Color(122, 24, 26));
        theMovieLabel.setText("The Movie [TIME]");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addContainerGap(1005, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MainPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(selectedSeatsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buyTicketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(seatsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(vacantImageLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(vacantImageLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(vacantImageLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(theMovieLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(posterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButton)
                .addGap(48, 48, 48)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(vacantImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(vacantImageLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(vacantImageLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seatsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(posterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(theMovieLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectedSeatsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buyTicketButton, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MainPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainPanelMouseDragged
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();

		this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_MainPanelMouseDragged

    private void MainPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainPanelMousePressed
		this.xMouse = evt.getX();
		this.yMouse = evt.getY() + 30; // 30 is for the top panel of the system.
    }//GEN-LAST:event_MainPanelMousePressed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
		ShowMovies showMovies = new ShowMovies(connection, customerID);

		showMovies.setLocation(this.getLocation());
		this.dispose();
		showMovies.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

	
    private void seat0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat0MouseClicked
		changeImageIcon(0);
		updateMessage();
    }//GEN-LAST:event_seat0MouseClicked
	//<editor-fold defaultstate="collapsed" desc="and other 59s">
    private void seat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat1MouseClicked
		changeImageIcon(1);
		updateMessage();
    }//GEN-LAST:event_seat1MouseClicked

    private void seat2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat2MouseClicked
		changeImageIcon(2);
		updateMessage();
    }//GEN-LAST:event_seat2MouseClicked

    private void seat3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat3MouseClicked
		changeImageIcon(3);
		updateMessage();
    }//GEN-LAST:event_seat3MouseClicked

    private void seat4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat4MouseClicked
		changeImageIcon(4);
		updateMessage();
    }//GEN-LAST:event_seat4MouseClicked

    private void seat5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat5MouseClicked
		changeImageIcon(5);
		updateMessage();
    }//GEN-LAST:event_seat5MouseClicked

    private void seat6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat6MouseClicked
		changeImageIcon(6);
		updateMessage();
    }//GEN-LAST:event_seat6MouseClicked

    private void seat7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat7MouseClicked
		changeImageIcon(7);
		updateMessage();
    }//GEN-LAST:event_seat7MouseClicked

    private void seat8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat8MouseClicked
		changeImageIcon(8);
		updateMessage();
    }//GEN-LAST:event_seat8MouseClicked

    private void seat9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat9MouseClicked
		changeImageIcon(9);
		updateMessage();
    }//GEN-LAST:event_seat9MouseClicked

    private void seat10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat10MouseClicked
		changeImageIcon(10);
		updateMessage();
    }//GEN-LAST:event_seat10MouseClicked

    private void seat11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat11MouseClicked
		changeImageIcon(11);
		updateMessage();
    }//GEN-LAST:event_seat11MouseClicked

    private void seat12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat12MouseClicked
		changeImageIcon(12);
		updateMessage();
    }//GEN-LAST:event_seat12MouseClicked

    private void seat13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat13MouseClicked
		changeImageIcon(13);
		updateMessage();
    }//GEN-LAST:event_seat13MouseClicked

    private void seat14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat14MouseClicked
		changeImageIcon(14);
		updateMessage();
    }//GEN-LAST:event_seat14MouseClicked

    private void seat15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat15MouseClicked
		changeImageIcon(15);
		updateMessage();
    }//GEN-LAST:event_seat15MouseClicked

    private void seat16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat16MouseClicked
		changeImageIcon(16);
		updateMessage();
    }//GEN-LAST:event_seat16MouseClicked

    private void seat17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat17MouseClicked
		changeImageIcon(17);
		updateMessage();
    }//GEN-LAST:event_seat17MouseClicked

    private void seat18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat18MouseClicked
		changeImageIcon(18);
		updateMessage();
    }//GEN-LAST:event_seat18MouseClicked

    private void seat19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat19MouseClicked
		changeImageIcon(19);
		updateMessage();
    }//GEN-LAST:event_seat19MouseClicked

    private void seat20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat20MouseClicked
		changeImageIcon(20);
		updateMessage();
    }//GEN-LAST:event_seat20MouseClicked

    private void seat21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat21MouseClicked
		changeImageIcon(21);
		updateMessage();
    }//GEN-LAST:event_seat21MouseClicked

    private void seat22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat22MouseClicked
		changeImageIcon(22);
		updateMessage();
    }//GEN-LAST:event_seat22MouseClicked

    private void seat23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat23MouseClicked
		changeImageIcon(23);
		updateMessage();
    }//GEN-LAST:event_seat23MouseClicked

    private void seat24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat24MouseClicked
		changeImageIcon(24);
		updateMessage();
    }//GEN-LAST:event_seat24MouseClicked

    private void seat25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat25MouseClicked
		changeImageIcon(25);
		updateMessage();
    }//GEN-LAST:event_seat25MouseClicked

    private void seat26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat26MouseClicked
		changeImageIcon(26);
		updateMessage();
    }//GEN-LAST:event_seat26MouseClicked

    private void seat27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat27MouseClicked
		changeImageIcon(27);
		updateMessage();
    }//GEN-LAST:event_seat27MouseClicked

    private void seat28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat28MouseClicked
		changeImageIcon(28);
		updateMessage();
    }//GEN-LAST:event_seat28MouseClicked

    private void seat29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat29MouseClicked
		changeImageIcon(29);
		updateMessage();
    }//GEN-LAST:event_seat29MouseClicked
	
    private void seat30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat30MouseClicked
		changeImageIcon(30);
		updateMessage();
    }//GEN-LAST:event_seat30MouseClicked

    private void seat31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat31MouseClicked
		changeImageIcon(31);
		updateMessage();
    }//GEN-LAST:event_seat31MouseClicked

    private void seat32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat32MouseClicked
		changeImageIcon(32);
		updateMessage();
    }//GEN-LAST:event_seat32MouseClicked

    private void seat33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat33MouseClicked
		changeImageIcon(33);
		updateMessage();
    }//GEN-LAST:event_seat33MouseClicked

    private void seat34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat34MouseClicked
		changeImageIcon(34);
		updateMessage();
    }//GEN-LAST:event_seat34MouseClicked

    private void seat35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat35MouseClicked
		changeImageIcon(35);
		updateMessage();
    }//GEN-LAST:event_seat35MouseClicked

    private void seat36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat36MouseClicked
		changeImageIcon(36);
		updateMessage();
    }//GEN-LAST:event_seat36MouseClicked

    private void seat37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat37MouseClicked
		changeImageIcon(37);
		updateMessage();
    }//GEN-LAST:event_seat37MouseClicked

    private void seat38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat38MouseClicked
		changeImageIcon(38);
		updateMessage();
    }//GEN-LAST:event_seat38MouseClicked

    private void seat39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat39MouseClicked
		changeImageIcon(39);
		updateMessage();
    }//GEN-LAST:event_seat39MouseClicked

    private void seat40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat40MouseClicked
		changeImageIcon(40);
		updateMessage();
    }//GEN-LAST:event_seat40MouseClicked

    private void seat41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat41MouseClicked
		changeImageIcon(41);
		updateMessage();
    }//GEN-LAST:event_seat41MouseClicked

    private void seat42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat42MouseClicked
		changeImageIcon(42);
		updateMessage();
    }//GEN-LAST:event_seat42MouseClicked

    private void seat43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat43MouseClicked
		changeImageIcon(43);
		updateMessage();
    }//GEN-LAST:event_seat43MouseClicked

    private void seat44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat44MouseClicked
		changeImageIcon(44);
		updateMessage();
    }//GEN-LAST:event_seat44MouseClicked

    private void seat45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat45MouseClicked
		changeImageIcon(45);
		updateMessage();
    }//GEN-LAST:event_seat45MouseClicked

    private void seat46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat46MouseClicked
		changeImageIcon(46);
		updateMessage();
    }//GEN-LAST:event_seat46MouseClicked

    private void seat47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat47MouseClicked
		changeImageIcon(47);
		updateMessage();
    }//GEN-LAST:event_seat47MouseClicked

    private void seat48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat48MouseClicked
		changeImageIcon(48);
		updateMessage();
    }//GEN-LAST:event_seat48MouseClicked

    private void seat49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat49MouseClicked
		changeImageIcon(49);
		updateMessage();
    }//GEN-LAST:event_seat49MouseClicked

    private void seat50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat50MouseClicked
		changeImageIcon(50);
		updateMessage();
    }//GEN-LAST:event_seat50MouseClicked

    private void seat51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat51MouseClicked
		changeImageIcon(51);
		updateMessage();
    }//GEN-LAST:event_seat51MouseClicked

    private void seat52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat52MouseClicked
		changeImageIcon(52);
		updateMessage();
    }//GEN-LAST:event_seat52MouseClicked

    private void seat53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat53MouseClicked
		changeImageIcon(53);
		updateMessage();
    }//GEN-LAST:event_seat53MouseClicked

    private void seat54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat54MouseClicked
		changeImageIcon(54);
		updateMessage();
    }//GEN-LAST:event_seat54MouseClicked

    private void seat55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat55MouseClicked
		changeImageIcon(55);
		updateMessage();
    }//GEN-LAST:event_seat55MouseClicked

    private void seat56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat56MouseClicked
		changeImageIcon(56);
		updateMessage();
    }//GEN-LAST:event_seat56MouseClicked

    private void seat57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat57MouseClicked
		changeImageIcon(57);
		updateMessage();
    }//GEN-LAST:event_seat57MouseClicked

    private void seat58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat58MouseClicked
		changeImageIcon(58);
		updateMessage();
    }//GEN-LAST:event_seat58MouseClicked

    private void seat59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat59MouseClicked
		changeImageIcon(59);
		updateMessage();
    }//GEN-LAST:event_seat59MouseClicked
	//</editor-fold>
	
    private void buyTicketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyTicketButtonActionPerformed
		BuyTickets buyTickets = new BuyTickets(connection, imageIcon, selectedSeats, takenSeats, selectedSeatIcon, takenSeatIcon, message, movieID, customerID, movie);

		buyTickets.setLocation(this.getLocation());
		this.dispose();
		buyTickets.setVisible(true);
    }//GEN-LAST:event_buyTicketButtonActionPerformed

	public static void main(String args[]) {
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ShowSeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ShowSeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ShowSeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ShowSeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/*java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ShowTickets().setVisible(true);
			}
		//</editor-fold>

		/*java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ShowTickets().setVisible(true);
			}
		});*/
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton buyTicketButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel posterLabel;
    private javax.swing.JPanel posterPanel;
    private javax.swing.JLabel seat0;
    private javax.swing.JLabel seat1;
    private javax.swing.JLabel seat10;
    private javax.swing.JLabel seat11;
    private javax.swing.JLabel seat12;
    private javax.swing.JLabel seat13;
    private javax.swing.JLabel seat14;
    private javax.swing.JLabel seat15;
    private javax.swing.JLabel seat16;
    private javax.swing.JLabel seat17;
    private javax.swing.JLabel seat18;
    private javax.swing.JLabel seat19;
    private javax.swing.JLabel seat2;
    private javax.swing.JLabel seat20;
    private javax.swing.JLabel seat21;
    private javax.swing.JLabel seat22;
    private javax.swing.JLabel seat23;
    private javax.swing.JLabel seat24;
    private javax.swing.JLabel seat25;
    private javax.swing.JLabel seat26;
    private javax.swing.JLabel seat27;
    private javax.swing.JLabel seat28;
    private javax.swing.JLabel seat29;
    private javax.swing.JLabel seat3;
    private javax.swing.JLabel seat30;
    private javax.swing.JLabel seat31;
    private javax.swing.JLabel seat32;
    private javax.swing.JLabel seat33;
    private javax.swing.JLabel seat34;
    private javax.swing.JLabel seat35;
    private javax.swing.JLabel seat36;
    private javax.swing.JLabel seat37;
    private javax.swing.JLabel seat38;
    private javax.swing.JLabel seat39;
    private javax.swing.JLabel seat4;
    private javax.swing.JLabel seat40;
    private javax.swing.JLabel seat41;
    private javax.swing.JLabel seat42;
    private javax.swing.JLabel seat43;
    private javax.swing.JLabel seat44;
    private javax.swing.JLabel seat45;
    private javax.swing.JLabel seat46;
    private javax.swing.JLabel seat47;
    private javax.swing.JLabel seat48;
    private javax.swing.JLabel seat49;
    private javax.swing.JLabel seat5;
    private javax.swing.JLabel seat50;
    private javax.swing.JLabel seat51;
    private javax.swing.JLabel seat52;
    private javax.swing.JLabel seat53;
    private javax.swing.JLabel seat54;
    private javax.swing.JLabel seat55;
    private javax.swing.JLabel seat56;
    private javax.swing.JLabel seat57;
    private javax.swing.JLabel seat58;
    private javax.swing.JLabel seat59;
    private javax.swing.JLabel seat6;
    private javax.swing.JLabel seat7;
    private javax.swing.JLabel seat8;
    private javax.swing.JLabel seat9;
    private javax.swing.JPanel seatsPanel;
    private javax.swing.JLabel selectedSeatsLabel;
    private javax.swing.JLabel theMovieLabel;
    private javax.swing.JLabel vacantImageLabel;
    private javax.swing.JLabel vacantImageLabel1;
    private javax.swing.JLabel vacantImageLabel2;
    // End of variables declaration//GEN-END:variables
}