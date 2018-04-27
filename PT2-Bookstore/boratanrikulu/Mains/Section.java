/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;
import java.util.ArrayList;

public abstract class Section {

	private final String name;
	private ArrayList<Book> books;
	private Employee employee;

	// constructor
	public Section(String name, Employee employee) {
		if(name.equals(""))
			throw new IllegalArgumentException("(!) The Name of The Section is not entered.");
		if(employee.getName().equals(""))
			throw new IllegalArgumentException("(!) The Employee is not sent.");

		this.name = name;
		this.employee = employee;
	}

	// setters
	public void setBooks(ArrayList<Book> books) {		
		this.books = books;
	}
	public void setEmployee(Employee employee) {
		if(employee.getName().equals(""))
			throw new IllegalArgumentException("(!) The Employee is not sent.");

		this.employee = employee;
	}
	// getters
	public String getName() {
		return this.name;
	}
	public ArrayList<Book> getBooks() {
		return this.books;
	}
	public int getNumberOfBooks() {
		return books.size();
	}
	public Employee getEmployee() {
		return this.employee;
	}

	// methods
	public void addABook(Book book) {
		this.books.add(book);
	}
	public void sellABook(int count) {
		this.books.remove(count-1);
	}

	// toString
	public void showTheBooks() {
		int counter = 0;
		System.out.println("# " + this.name.toUpperCase() + " >");
		for(Book temp : books) {
			System.out.println("#   " + (++counter) + ") " + temp.toString());
		}
	}
}