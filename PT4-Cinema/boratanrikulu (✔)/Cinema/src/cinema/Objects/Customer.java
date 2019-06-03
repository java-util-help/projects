/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.Objects;

public class Customer {

	private String name;
	private String surname;
	private String email;
	private String password;
	private String birthdate;
	private String address;

	/* constructor */
	public Customer(String name, String surname, String email, String password, String birthdate) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
	}
	
	/* getters */
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public String getAddress() {
		return address;
	}
}