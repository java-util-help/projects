/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.Frames;

import cinema.Frames.ShowMovies;
import cinema.Objects.Theatre;
import java.sql.Connection;
import javax.swing.ImageIcon;

public class ShowSeats extends javax.swing.JFrame {

	private int xMouse;
	private int yMouse;
	private Connection connection;
	private Theatre theatre;
	
	public ShowSeats(Connection connection) {
		initComponents();
		
		this.connection = connection;
		theatre = new Theatre(30);
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(seat6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seat11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addComponent(seat5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addComponent(seat17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addComponent(seat23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addComponent(seat29)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seat0)
                    .addComponent(seat1)
                    .addComponent(seat2)
                    .addComponent(seat3)
                    .addComponent(seat4)
                    .addComponent(seat5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seat6)
                    .addComponent(seat7)
                    .addComponent(seat8)
                    .addComponent(seat9)
                    .addComponent(seat10)
                    .addComponent(seat11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seat12)
                    .addComponent(seat13)
                    .addComponent(seat14)
                    .addComponent(seat15)
                    .addComponent(seat16)
                    .addComponent(seat17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seat18)
                    .addComponent(seat19)
                    .addComponent(seat20)
                    .addComponent(seat21)
                    .addComponent(seat22)
                    .addComponent(seat23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seat24)
                    .addComponent(seat25)
                    .addComponent(seat26)
                    .addComponent(seat27)
                    .addComponent(seat28)
                    .addComponent(seat29))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap(997, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(40, 40, 40))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButton)
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(380, Short.MAX_VALUE))
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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
		ShowMovies showMovies = new ShowMovies(connection);

		showMovies.setLocation(this.getLocation());
		this.dispose();
		showMovies.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void seat0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat0MouseClicked
		if(theatre.getSeat(0).isVacant()) {
			ImageIcon selectedSeatIcon = new ImageIcon(getClass().getResource("/cinema/selected-seat.png"));
			seat0.setIcon(selectedSeatIcon);
			theatre.getSeat(0).setStatusSeleted();
		}
		else if(theatre.getSeat(0).isSelected()) {
			ImageIcon vacantSeatIcon = new ImageIcon(getClass().getResource("/cinema/vacant-seat.png"));
			seat0.setIcon(vacantSeatIcon);
			theatre.getSeat(0).setStatusVacant();
		}
    }//GEN-LAST:event_seat0MouseClicked

    private void seat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat1MouseClicked
		if(theatre.getSeat(1).isVacant()) {
			ImageIcon selectedSeatIcon = new ImageIcon(getClass().getResource("/cinema/selected-seat.png"));
			seat1.setIcon(selectedSeatIcon);
			theatre.getSeat(1).setStatusSeleted();
		}
		else if(theatre.getSeat(1).isSelected()) {
			ImageIcon vacantSeatIcon = new ImageIcon(getClass().getResource("/cinema/vacant-seat.png"));
			seat1.setIcon(vacantSeatIcon);
			theatre.getSeat(1).setStatusVacant();
		}
    }//GEN-LAST:event_seat1MouseClicked

    private void seat2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat2MouseClicked
		if(theatre.getSeat(2).isVacant()) {
			ImageIcon selectedSeatIcon = new ImageIcon(getClass().getResource("/cinema/selected-seat.png"));
			seat2.setIcon(selectedSeatIcon);
			theatre.getSeat(2).setStatusSeleted();
		}
		else if(theatre.getSeat(2).isSelected()) {
			ImageIcon vacantSeatIcon = new ImageIcon(getClass().getResource("/cinema/vacant-seat.png"));
			seat2.setIcon(vacantSeatIcon);
			theatre.getSeat(2).setStatusVacant();
		}
    }//GEN-LAST:event_seat2MouseClicked

    private void seat3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat3MouseClicked
		if(theatre.getSeat(3).isVacant()) {
			ImageIcon selectedSeatIcon = new ImageIcon(getClass().getResource("/cinema/selected-seat.png"));
			seat3.setIcon(selectedSeatIcon);
			theatre.getSeat(3).setStatusSeleted();
		}
		else if(theatre.getSeat(3).isSelected()) {
			ImageIcon vacantSeatIcon = new ImageIcon(getClass().getResource("/cinema/vacant-seat.png"));
			seat3.setIcon(vacantSeatIcon);
			theatre.getSeat(3).setStatusVacant();
		}
    }//GEN-LAST:event_seat3MouseClicked

    private void seat4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat4MouseClicked

    private void seat5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat5MouseClicked

    private void seat6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat6MouseClicked

    private void seat7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat7MouseClicked

    private void seat8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat8MouseClicked

    private void seat9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat9MouseClicked

    private void seat10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat10MouseClicked

    private void seat11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat11MouseClicked

    private void seat12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat12MouseClicked

    private void seat13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat13MouseClicked

    private void seat14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat14MouseClicked

    private void seat15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat15MouseClicked

    private void seat16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat16MouseClicked

    private void seat17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat17MouseClicked

    private void seat18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat18MouseClicked

    private void seat19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat19MouseClicked

    private void seat20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat20MouseClicked

    private void seat21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat21MouseClicked

    private void seat22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat22MouseClicked

    private void seat23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat23MouseClicked

    private void seat24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat24MouseClicked

    private void seat25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat25MouseClicked

    private void seat26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat26MouseClicked

    private void seat27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat27MouseClicked

    private void seat28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat28MouseClicked

    private void seat29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_seat29MouseClicked

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
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JLabel seat4;
    private javax.swing.JLabel seat5;
    private javax.swing.JLabel seat6;
    private javax.swing.JLabel seat7;
    private javax.swing.JLabel seat8;
    private javax.swing.JLabel seat9;
    // End of variables declaration//GEN-END:variables
}