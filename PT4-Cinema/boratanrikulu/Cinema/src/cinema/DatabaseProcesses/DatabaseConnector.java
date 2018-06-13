/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.DatabaseProcesses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	
	public Connection connection = null;

	/* constructor */
	public DatabaseConnector() {
		String url = "jdbc:mysql://" + DatabaseInfo.getHost() + ":" + DatabaseInfo.getPort() + "/" + DatabaseInfo.getName() + "?useUnicode=true&characterEncoding=utf8";
		
		try {	// loads driver
			 Class.forName("org.mariadb.jdbc.Driver");
			 System.out.println("Driver is loaded.");
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver is not found.");
		}
		
		try {	// makes connection
			connection = DriverManager.getConnection(url, DatabaseInfo.getUsername(), DatabaseInfo.getPassword());
			System.out.println("Connection is successful.");
		} catch (SQLException ex) {
			System.out.println("Connection is failed.");
		}
	}

	/* getter */
	public Connection getConnection() {
		return this.connection;
	}
}