/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
public class Customer {

	/* instance variables */
	private String name;
	private String surname;
	private int age;
	private String job;

	/* constructor */
	public Customer(String name, String surname, int age, String job) {
		if(age < 1)
			throw new IllegalArgumentException("(!) age must be at least 1.");
		if(age > 140)
			throw new IllegalArgumentException("(!) age must be at most 140.");
		if(name.equals(""))
			throw new IllegalArgumentException("(!) name not entered.");
		if(surname.equals(""))
			throw new IllegalArgumentException("(!) surname not entered.");
		if(job.equals(""))
			throw new IllegalArgumentException("(!) job not entered.");

		this.name = name;
		this.surname = surname;
		this.age = age;
		this.job = job;
	}

	/* methods */
	public String display() {
		return this.name+" "+this.surname+", "+this.age+" years old, "+this.job;
	}

	/* setters */
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setJob(String job) {
		this.job = job;
	}
	/* getters */
	public String getName() {
		return this.name;
	}
	public String getSurname() {
		return this.surname;
	}
	public int getAge() {
		return this.age;
	}
	public String getJob() {
		return this.job;
	}
}