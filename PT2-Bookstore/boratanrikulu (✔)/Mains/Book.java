/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;

public class Book {

	private final String title;
	private final String author;
	private final String publishDate;
	private int price;

	// constructor
	public Book(String title, String author, String publishDate, int price) {
		if(title.equals(""))
			throw new IllegalArgumentException("(!) The Book Title is not entered.");
		if(author.equals(""))
			throw new IllegalArgumentException("(!) The Author of The Book is not entered.");
		if(publishDate.equals(""))
			throw new IllegalArgumentException("(!) The Publish Date of The Book is not entered.");
		if(price < 0)
			throw new IllegalArgumentException("(!) The Price of The Book can not be negative.");

		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
		this.price = price;
	}

	// setters
	public void setPrice(int price) {
		if(price < 0)
			throw new IllegalArgumentException("(!) The Price of The Book can not be negative.");

		this.price = price;
	}
	// getters
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getPublishDate() {
		return this.publishDate;
	}
	public int getPrice() {
		return this.price;
	}

	// toString
	public String toString() {
		return String.format("[%d$] \"%s\" by %s, published in %s", this.price, this.title.toUpperCase(), this.author, this.publishDate);
	}
}