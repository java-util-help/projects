/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.Frames;

import cinema.Objects.Seat;
import cinema.Frames.ShowMovies;
import java.sql.Connection;
import javax.swing.ImageIcon;

public class ShowSeats extends javax.swing.JFrame {

	private int xMouse;
	private int yMouse;
	private Connection connection;
	private Seat seats1;
	
	public ShowSeats(Connection connection) {
		initComponents();
		
		this.connection = connection;
		seats1 = new Seat();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        seat1 = new javax.swing.JLabel();

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

        seat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/vacant-seat.png"))); // NOI18N
        seat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seat1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(40, 40, 40))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(seat1)
                .addContainerGap(893, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backButton)
                .addGap(61, 61, 61)
                .addComponent(seat1)
                .addContainerGap(560, Short.MAX_VALUE))
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

    private void seat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seat1MouseClicked
		if(seats1.isVacant()) {
			ImageIcon selectedSeatIcon = new ImageIcon(getClass().getResource("/cinema/selected-seat.png"));
			this.seat1.setIcon(selectedSeatIcon);
			seats1.setStatusSeleted();
		}
		else if(seats1.isSelected()) {
			ImageIcon vacantSeatIcon = new ImageIcon(getClass().getResource("/cinema/vacant-seat.png"));
			this.seat1.setIcon(vacantSeatIcon);
			seats1.setStatusVacant();
		}
    }//GEN-LAST:event_seat1MouseClicked

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
    private javax.swing.JLabel seat1;
    // End of variables declaration//GEN-END:variables
}