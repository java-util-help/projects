/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;
import java.util.ArrayList;

public class History extends Section {

	// temps to create default sections
	private Book bookTemp;
	private ArrayList<Book> booksTemp;

	// constructor
	public History(Employee employee) {
		super("History", employee);

		buildHistorySection();
	}

	private void buildHistorySection() {
		// creates default books and adds
		this.booksTemp = new ArrayList<Book>();

		this.bookTemp = new Book("Türklerin Tarihi - I", "Ilber Ortaylı", "2015", 40);
		this.booksTemp.add(this.bookTemp);

		this.bookTemp = new Book("NUTUK", "Atatürk", "1927", 40);
		this.booksTemp.add(this.bookTemp);

		// sends arraylist to the history section
		setBooks(this.booksTemp);
	}
}