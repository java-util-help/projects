/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.Frames;

import cinema.DatabaseProcesses.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginPage extends javax.swing.JFrame {

	private int xMouse;
	private int yMouse;
	
	private int customerID;
	private DatabaseConnector connector;
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public LoginPage() {
		initComponents();
		
		this.connector = new DatabaseConnector(); // makes a connection to the database
		this.connection = connector.getConnection(); // gets the connection from the DatabaseConnector
	}
	
	private boolean login(String email, String password) {
		String query = "SELECT * FROM customers WHERE email = ? AND password = ?";
		
		try {
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet  = preparedStatement.executeQuery();
			if(resultSet.next()) {
				this.customerID = resultSet.getInt("id");
				return true;
			}
			return false;
		} catch (SQLException ex) {
			System.out.println("[TRY-CATCH] Error. (signInButton)");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        passwordArea = new javax.swing.JPasswordField();
        emailArea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signInButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        signOutButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cinema - java.util.help");
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(231, 232, 235));
        mainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mainPanelMouseDragged(evt);
            }
        });
        mainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainPanelMousePressed(evt);
            }
        });

        loginPanel.setBackground(new java.awt.Color(217, 193, 183));

        passwordArea.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        passwordArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordAreaActionPerformed(evt);
            }
        });

        emailArea.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        emailArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailAreaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(122, 24, 26));
        jLabel1.setText("Email");

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(122, 24, 26));
        jLabel2.setText("Password");

        signInButton.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        signInButton.setText("Sign In");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(47, 52, 63));

        signOutButton.setText("Sign Out");
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(217, 193, 183));
        jLabel3.setForeground(new java.awt.Color(231, 232, 235));
        jLabel3.setText("Not an user ?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signOutButton)
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signOutButton)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailArea, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(passwordArea, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(49, 49, 49)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cinema/logo.png"))); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMouseDragged
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		
		this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_mainPanelMouseDragged

    private void mainPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMousePressed
		this.xMouse = evt.getX();
		this.yMouse = evt.getY() + 30; // 30 is for the top panel of the system.
    }//GEN-LAST:event_mainPanelMousePressed

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
		String email = this.emailArea.getText();
		String password = (String) this.passwordArea.getText();
		
		if(email.equals("") || password.equals("")){
			JOptionPane.showMessageDialog(this, "Please fill out all information."); // shows an error if informations is not completed.
		}
		else {
			if(login(email, password)) {
				System.out.println("SignIn is successful.");
				JOptionPane.showMessageDialog(this, "SignIn is successful.");
				
				
			}
			else {
				System.out.println("Email or Password is invalid.");
				JOptionPane.showMessageDialog(this, "Email or Password is invalid.");
			}
		}
    }//GEN-LAST:event_signInButtonActionPerformed

    private void passwordAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordAreaActionPerformed
		signInButtonActionPerformed(evt);
    }//GEN-LAST:event_passwordAreaActionPerformed

    private void emailAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailAreaActionPerformed
		signInButtonActionPerformed(evt);
    }//GEN-LAST:event_emailAreaActionPerformed

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
		SignOut signOut = new SignOut();
		
		this.dispose();
		signOut.setVisible(true);
    }//GEN-LAST:event_signOutButtonActionPerformed

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
			java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginPage().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField passwordArea;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signOutButton;
    // End of variables declaration//GEN-END:variables
}