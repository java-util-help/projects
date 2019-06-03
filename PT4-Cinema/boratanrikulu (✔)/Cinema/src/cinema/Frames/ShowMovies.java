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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		setDays();
		showTheMovies(this.movies, dateComboBox.getSelectedItem().toString(), timeComboBox.getSelectedItem().toString());
	}
	
	private void getAllMovies() {		
		String query = "SELECT * FROM movies ORDER BY id DESC LIMIT 160";
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!movies.isEmpty()) {
				movies.clear(); // clears all movies from the arraylist to make a new start.
			}
			while(resultSet.next()) {
				Movie movie = new Movie(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("genre"), resultSet.getString("duration"), resultSet.getDouble("rating"), 
						resultSet.getString("director"), resultSet.getString("actors"), resultSet.getString("date"), resultSet.getString("time"), resultSet.getString("urlPoster"), resultSet.getString("summary"));
				movies.add(movie);
			}
			Collections.sort(movies, new Comparator<Movie>() { // sorts by id
				@Override
				public int compare(Movie movie1, Movie movie2){
					if(movie1.getID() < movie2.getID()) return -1;
					if(movie1.getID() > movie2.getID()) return 1;
					return 0;
				}
			});
		} catch (SQLException ex) {
			Logger.getLogger(ShowMovies.class.getName()).log(Level.SEVERE, null, ex);
		}
	} 
	
	private void showTheMovies(ArrayList<Movie> movies, String date, String time) {
		defaultMovieTable.setRowCount(0);		
		for(Movie movie : movies) {
			if(movie.getDate().equals(date) && movie.getTime().equals(time)) {
				Object[] willAdd = {movie.getID(), movie.getTitle(), 
						movie.getGenre(), movie.getRating(),
						movie.getDirector()};
				defaultMovieTable.addRow(willAdd); // adds all movies to the model
			}
		}
	}
	
	private void showThePoster(int movieID) {
		for(Movie movie : movies) {
			if(movie.getID() == movieID) {
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
					imageIcon = new ImageIcon(getClass().getResource("/cinema/logo.png"));
					posterLabel.setIcon(imageIcon);
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
		showTheMovies(searchedMovies, dateComboBox.getSelectedItem().toString(), timeComboBox.getSelectedItem().toString());
	}
	
	private void setTheInfos(int movieID) {
		for(Movie movie : movies) {
			if(movie.getID() == movieID) {
				titleLabel.setText(movie.getTitle() + " by " + movie.getDirector());
				actorsLabel.setText("Actors : " + movie.getActors());
				ratingLabel.setText(String.valueOf(movie.getRating()));
				durationLabel.setText(movie.getDuration());
				summaryArea.setText("SUMMARY:\n\n"+ movie.getSummary());
			}
		}
	}

	private void setInfosNull() {
		titleLabel.setText("");
		actorsLabel.setText("");
		ratingLabel.setText("");
		durationLabel.setText("");
		summaryArea.setText("");
		warningLabel.setText("");
		
		if(defaultMovieTable.getRowCount() == 0) {
			warningLabel.setText("<html>No movie is found at <b>"
					+ dateComboBox.getSelectedItem().toString() + "</b>, <b>" + timeComboBox.getSelectedItem().toString()
					+ "</b>. <br>Please select another date and time.</html>");
		}
		else {
			warningLabel.setText("<html>The movies are at <b>"
					+ dateComboBox.getSelectedItem().toString() + "</b>, <b>" + timeComboBox.getSelectedItem().toString()
					+ "</b>.</html>");
		}
	}
	
	public void setDays() {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		
		localDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
		dateComboBox.addItem(date.format(localDate));
		
		localDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()+1);
		dateComboBox.addItem(date.format(localDate));
		
		localDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()+1);
		dateComboBox.addItem(date.format(localDate));
		
		localDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()+1);
		dateComboBox.addItem(date.format(localDate));
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
        dateComboBox = new javax.swing.JComboBox<>();
        timeComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ratingLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        actorsLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        summaryArea = new javax.swing.JTextArea();
        warningLabel = new javax.swing.JLabel();

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

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        movieTable.setBackground(new java.awt.Color(47, 52, 63));
        movieTable.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        movieTable.setForeground(new java.awt.Color(231, 232, 235));
        movieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Title", "Gendre", "Rating", "Director"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            movieTable.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
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

        dateComboBox.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        dateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateComboBoxActionPerformed(evt);
            }
        });

        timeComboBox.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        timeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00", "13:00", "16:00", "21:00" }));
        timeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(122, 24, 26));
        jLabel3.setText("TIME");

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(122, 24, 26));
        jLabel4.setText("DATE");

        ratingLabel.setFont(new java.awt.Font("Monospaced", 1, 28)); // NOI18N
        ratingLabel.setForeground(new java.awt.Color(122, 24, 26));
        ratingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ratingLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        titleLabel.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(122, 24, 26));

        actorsLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        actorsLabel.setForeground(new java.awt.Color(122, 24, 26));

        durationLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        durationLabel.setForeground(new java.awt.Color(122, 24, 26));
        durationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        durationLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        summaryArea.setBackground(new java.awt.Color(231, 232, 235));
        summaryArea.setColumns(20);
        summaryArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        summaryArea.setForeground(new java.awt.Color(122, 24, 26));
        summaryArea.setLineWrap(true);
        summaryArea.setRows(5);
        summaryArea.setWrapStyleWord(true);
        summaryArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setViewportView(summaryArea);

        warningLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(122, 24, 26));
        warningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warningLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchArea, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                                    .addComponent(actorsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(durationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ratingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(warningLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
                                .addGap(0, 11, Short.MAX_VALUE)))))
                .addGap(45, 45, 45)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(posterPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signOutButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(showSeatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(posterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(showSeatsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(searchArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ratingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(actorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(durationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
		setTheInfos(movieID);
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

			ShowSeats showTickets = new ShowSeats(this.connection, imageIcon, movieID, customerID, movies.get(movieID-1));
			showTickets.setLocation(this.getLocation());
			this.dispose();
			showTickets.setVisible(true);
		}
    }//GEN-LAST:event_showSeatsButtonActionPerformed

    private void dateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateComboBoxActionPerformed
		showTheMovies(this.movies, dateComboBox.getSelectedItem().toString(), timeComboBox.getSelectedItem().toString());
		setInfosNull();
    }//GEN-LAST:event_dateComboBoxActionPerformed

    private void timeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeComboBoxActionPerformed
		showTheMovies(this.movies, dateComboBox.getSelectedItem().toString(), timeComboBox.getSelectedItem().toString());
		setInfosNull();
    }//GEN-LAST:event_timeComboBoxActionPerformed

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
    private javax.swing.JLabel actorsLabel;
    private javax.swing.JComboBox<String> dateComboBox;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable movieTable;
    private javax.swing.JLabel posterLabel;
    private javax.swing.JPanel posterPanel;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JTextField searchArea;
    private javax.swing.JButton showSeatsButton;
    private javax.swing.JButton signOutButton;
    private javax.swing.JTextArea summaryArea;
    private javax.swing.JComboBox<String> timeComboBox;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}