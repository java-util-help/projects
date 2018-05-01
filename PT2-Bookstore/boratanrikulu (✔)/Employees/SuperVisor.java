/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;

public class SuperVisor extends Employee {

	public SuperVisor(String name, Employee.Gender gender, int weeklyHours, int hourlySalary) {
		super(name, gender, weeklyHours, hourlySalary);
	}

	public SuperVisor() {
		// to create a null employee
		super();
	}
}