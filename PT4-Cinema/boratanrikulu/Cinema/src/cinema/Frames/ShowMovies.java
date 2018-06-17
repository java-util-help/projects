/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.Frames;

import cinema.Objects.Movie;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ShowMovies extends javax.swing.JFrame {

	private int xMouse;
	private int yMouse;
	private int movieID;
	private int customerID;
	private ArrayList<Movie> movies;
	private Connection connection;
	private DefaultTableModel defaultMovieTable;
	private PreparedStatement preparedStatement;
	private ImageIcon imageIcon;
	
	public ShowMovies(Connection connection, int customerID) {
		initComponents();
		
		this.connection = connection;
		this.customerID = customerID;
		this.defaultMovieTable = (DefaultTableModel) movieTable.getModel();
		this.movies = new ArrayList<Movie>();
		
		getAllMovies();
		showTheMovies(this.movies);
	}
	
	private void getAllMovies() {		
		String query = "SELECT * from movies";
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!movies.isEmpty()) {
				movies.clear(); // clears all movies from the arraylist to make a new start.
			}
			while(resultSet.next()) {
				Movie movie = new Movie(resultSet.getInt("id"), resultSet.getString("title"),
						resultSet.getString("genre"), resultSet.getDouble("rate"), resultSet.getString("date"),
						resultSet.getString("time"), resultSet.getString("urlPoster"));
				movies.add(movie);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ShowMovies.class.getName()).log(Level.SEVERE, null, ex);
		}
	} 
	
	private void showTheMovies(ArrayList<Movie> movies) {
		defaultMovieTable.setRowCount(0);		
		for(Movie movie : movies) {
			Object[] willAdd = {movie.getID(), movie.getTitle(), 
					movie.getGenre(), movie.getRate(),
					movie.getDate(), movie.getTime()};
			defaultMovieTable.addRow(willAdd); // adds all movies to the model
		}
	}
	
	private void showThePoster(int id) {
		for(Movie movie : movies) {
			if(movie.getID() == id) {
				try {
					URL url = new URL(movie.getUrlPoster());
					BufferedImage img = ImageIO.read(url);
					Image dimg = img.getScaledInstance(posterLabel.getWidth(), posterLabel.getHeight(), Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(dimg);
					posterLabel.setIcon(imageIcon);
				} catch (MalformedURLException ex) {
					Logger.getLogger(ShowMovies.class.getName()).log(Level.SEVERE, null, ex);
				} catch (IOException ex) {
					Logger.getLogger(ShowMovies.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	private void searchAMovie(String search) {
		ArrayList<Movie> searchedMovies = new ArrayList<Movie>();
		for(Movie movie : movies) {
			if(movie.toString().toLowerCase().contains(search.toLowerCase())) {
				searchedMovies.add(movie);
			}
		}
		showTheMovies(searchedMovies);
	}
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        signOutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        movieTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        searchArea = new javax.swing.JTextField();
        showSeatsButton = new javax.swing.JButton();
        posterPanel = new javax.swing.JPanel();
        posterLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cinema - java.util.help");
        setResizable(false);

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

        signOutButton.setText("Sign Out");
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        movieTable.setBackground(new java.awt.Color(47, 52, 63));
        movieTable.setForeground(new java.awt.Color(231, 232, 235));
        movieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Gendre", "Rate", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        movieTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movieTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(movieTable);
        if (movieTable.getColumnModel().getColumnCount() > 0) {
            movieTable.getColumnModel().getColumn(0).setMinWidth(0);
            movieTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            movieTable.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(122, 24, 26));
        jLabel2.setText("SEARCH   :");

        searchArea.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        searchArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchAreaKeyReleased(evt);
            }
        });

        showSeatsButton.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        showSeatsButton.setText("Show Seats");
        showSeatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSeatsButtonActionPerformed(evt);
            }
        });

        posterPanel.setMaximumSize(new java.awt.Dimension(409, 428));

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

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(searchArea))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(posterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(signOutButton)
                            .addComponent(showSeatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(signOutButton)
                .addGap(40, 40, 40)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(searchArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(posterPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(showSeatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
		SignIn signIn = new SignIn();
		
		signIn.setLocation(this.getLocation());
		this.dispose();
		signIn.setVisible(true);
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void movieTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movieTableMouseClicked
		movieID = (int) movieTable.getValueAt(movieTable.getSelectedRow(), 0);
		
		showThePoster(movieID);
    }//GEN-LAST:event_movieTableMouseClicked

    private void searchAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchAreaKeyReleased
		String search = searchArea.getText();
		
		searchAMovie(search);
    }//GEN-LAST:event_searchAreaKeyReleased

    private void showSeatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSeatsButtonActionPerformed
		if(movieTable.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Please select a movie.");
		}
		else {
			int id = (int) movieTable.getValueAt(movieTable.getSelectedRow(), 0);

			ShowSeats showTickets = new ShowSeats(this.connection, imageIcon, movieID, customerID);
			showTickets.setLocation(this.getLocation());
			this.dispose();
			showTickets.setVisible(true);
		}
    }//GEN-LAST:event_showSeatsButtonActionPerformed

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
			java.util.logging.Logger.getLogger(ShowMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ShowMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ShowMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ShowMovies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/*java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ShowMovies().setVisible(true);
			}
		});*/
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable movieTable;
    private javax.swing.JLabel posterLabel;
    private javax.swing.JPanel posterPanel;
    private javax.swing.JTextField searchArea;
    private javax.swing.JButton showSeatsButton;
    private javax.swing.JButton signOutButton;
    // End of variables declaration//GEN-END:variables
}