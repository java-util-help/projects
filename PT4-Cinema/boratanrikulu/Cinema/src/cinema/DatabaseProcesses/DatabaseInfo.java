/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.DatabaseProcesses;

public class DatabaseInfo {

	private static final String username = "root";
	private static final String password = "password'";
	private static final String name = "cinema";
	private static final String host = "localhost";
	private static final int port = 3306;

	/* getters */
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	public static String getName() {
		return name;
	}
	public static String getHost() {
		return host;
	}
	public static int getPort() {
		return port;
	}	
}