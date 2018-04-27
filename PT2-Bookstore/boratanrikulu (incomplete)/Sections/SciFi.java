/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;
import java.util.ArrayList;

public class SciFi extends Section {

	// temps to create default sections
	private Book bookTemp;
	private ArrayList<Book> booksTemp;

	// constructor
	public SciFi(Employee employee) {
		super("Sci-Fi", employee);

		buildSciFiSection();
	}

	private void buildSciFiSection() {
		// creates default books and adds
		this.booksTemp = new ArrayList<Book>();
		this.bookTemp = new Book("Nineteen Eighty-Four", "George Orwell", "1949", 40);
		this.booksTemp.add(this.bookTemp);
		this.bookTemp = new Book("Brave New World", "Aldous Huxley", "1932", 30);
		this.booksTemp.add(this.bookTemp);

		// sends arraylist to the sciFi section
		setBooks(this.booksTemp);
	}
}