/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;
import java.util.ArrayList;

public class Mythology extends Section {

	// temps to create default sections
	private Book bookTemp;
	private ArrayList<Book> booksTemp;

	// constructor
	public Mythology(Employee employee) {
		super("Mythology", employee);

		buildMythologySection();
	}

	private void buildMythologySection() {
		// creates default books and adds
		this.booksTemp = new ArrayList<Book>();
		this.bookTemp = new Book("Mythology", "Edith Hamilton", "1942", 39);
		this.booksTemp.add(this.bookTemp);
		this.bookTemp = new Book("The Prose Edda", "Snorri Sturluson", "1220", 34);
		this.booksTemp.add(this.bookTemp);

		// sends arraylist to the mythology section
		setBooks(this.booksTemp);
	}
}