/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;

public abstract class Employee {

	enum Gender {
		M("Male"),
		F("Female"),
		NULL("NULL");

		String gender;
		Gender(String gender) {
			this.gender = gender;
		}

		String getGender() {
			return this.gender;
		}
	}
	private final String name;
	private final Gender gender;
	private int weeklyHours;
	private int hourlySalary;

	// constuctor
	public Employee(String name, Gender gender, int weeklyHours, int hourlySalary) {
		if(name.equals(""))
			throw new IllegalArgumentException("(!) The Name of The Employee is not entered.");
		if(gender.getGender().equals(""))
			throw new IllegalArgumentException("(!) The Gender of The Employee is not entered.");
		if(weeklyHours < 0)
			throw new IllegalArgumentException("(!) The Weekly Hours of The Employee can not be negative.");
		if(hourlySalary < 0)
			throw new IllegalArgumentException("(!) The Hourly Salary of The Employee can not be negative.");

		this.name = name;
		this.gender = gender;
		this.weeklyHours = weeklyHours;
		this.hourlySalary = hourlySalary;
	}

	public Employee() {
		this.name = null;
		this.gender = Gender.NULL;
		this.weeklyHours = 0;
		this.hourlySalary = 0;
	}

	// setters
	public void setWeeklyHours(int weeklyHours) {
		if(weeklyHours < 0)
			throw new IllegalArgumentException("(!) The Weekly Hours of The Employee can not be negative.");
		
		this.weeklyHours = weeklyHours;
	}
	public void setHourlySalary(int hourlySalary) {
		if(hourlySalary < 0)
			throw new IllegalArgumentException("(!) The Hourly Salary of The Employee can not be negative.");
		
		this.hourlySalary = hourlySalary;
	}
	// getters
	public String getName() {
		return this.name;
	}
	public Gender getGender() {
		return gender;
	}
	public int getSalary() {
		return weeklyHours*hourlySalary;
	}

	// toString
	public String toString() {
		return String.format("%s [%s], %s$ at a week", this.name, this.gender, (this.weeklyHours*this.hourlySalary));
	}
}