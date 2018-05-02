/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;
import java.util.ArrayList;

public class Poem extends Section {

	// temps to create default sections
	private Book bookTemp;
	private ArrayList<Book> booksTemp;

	// constructor
	public Poem(Employee employee) {
		super("Poem", employee);

		buildPoemSection();
	}

	private void buildPoemSection() {
		// creates default books and adds
		this.booksTemp = new ArrayList<Book>();
		this.bookTemp = new Book("Les Fleurs du mal", "Charles Baudelaire", "1857", 24);
		this.booksTemp.add(this.bookTemp);
		this.bookTemp = new Book("Otuz Beş Yaş", "Cahit Sıtkı Tarancı", "1857", 19);
		this.booksTemp.add(this.bookTemp);

		// sends arraylist to the poem section
		setBooks(this.booksTemp);
	}
}