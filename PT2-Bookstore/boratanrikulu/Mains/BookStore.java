/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {

	private final String name;
	private ArrayList<Section> sections;
	private static Employee employeeTemp;
	private final Scanner scan;

	// constructor
	public BookStore(String name) {
		if(name.equals(""))
			throw new IllegalArgumentException("(!) The Name of The Book Store is not entered.");

		this.name = name;

		scan = new Scanner(System.in);
		// Creates Default Section Objects
		sections = new ArrayList<Section>();

		createHistorySection(); // sections[0]
		createMythologySection(); // sections[1]
		createPoemSection(); // sections[2]
		createSciFiSection(); // sectons[3]
	}

	// creates default section objects
	private void createHistorySection() {
		// creates a history class with an employee
		this.employeeTemp = new Staff("Aslı Türk", Employee.Gender.F, 30, 7);
		Section history = new History(this.employeeTemp);

		this.sections.add(history);
	}
	private void createMythologySection() {
		// creates a mythology class with an employee
		this.employeeTemp = new Staff("Kuzey Batı", Employee.Gender.M, 30, 7);
		Section mythology = new Mythology(this.employeeTemp);

		this.sections.add(mythology);
	}
	private void createPoemSection() {
		// creates a poem class with an employee
		this.employeeTemp = new Staff("Asya Asya", Employee.Gender.F, 30, 7);
		Section poem = new Poem(this.employeeTemp);

		this.sections.add(poem);
	}
	private void createSciFiSection() {
		// creates a sciFi class with an employee
		this.employeeTemp = new Staff("Bora Tanrıkulu", Employee.Gender.M, 30, 7);
		Section sciFi = new SciFi(this.employeeTemp);

		this.sections.add(sciFi);
	}

	// methods
	public void showAllBooks() {
		int counter = 0;

		System.out.println("##########################################################################");
		for(Section temp : this.sections) {
			System.out.println("# ");
			temp.showTheBooks();
		}
		System.out.println("#");
		System.out.println("##########################################################################");
	}

	public void addABook() {
		boolean flag = true;

		while(flag) {
			clear();
			int counter = 0;
			System.out.println("##########################################################################");
			System.out.println("# Which Section to Add A Book ?                                          #");
			System.out.println("#");
			for(Section temp : this.sections) {
				System.out.println("# "+(++counter)+") " + temp.getName());
			}
			System.out.println("#");
			System.out.println("# 9) Return to Upper Menu                                                #");
			System.out.println("##########################################################################");
			System.out.print("\t Menu Option: "); String menuOption = scan.nextLine();

			switch(menuOption) {
				case "1":
				case "2":
				case "3":
				case "4":
					sections.get((Integer.parseInt(menuOption))-1).addABook(takeBookInfo());
					scan.nextLine(); // to ignore the "residual enter issue"
					System.out.print("\n(->) " + sections.get((Integer.parseInt(menuOption)-1)).getBookTitle(sections.get((Integer.parseInt(menuOption)-1)).getBooksNumber()));
					System.out.print(" has been added.");
					scan.nextLine();
					clear();
					break;
				case "9":
					flag = false;
					break;
				default:
					System.out.print("\n(!) Select appropriate menu options.");
					scan.nextLine();
					break;
			}
		}
	}

	public void sellABook() {
		boolean flag = true;

		while(flag) {
			clear();
			int counter = 0;
			showAllBooks();
			System.out.println("\n# Which Section to Sell A Book ?");
			System.out.println("#");
			for(Section temp : this.sections) {
				System.out.println("# "+(++counter)+") " + temp.getName());
			}
			System.out.println("#");
			System.out.println("# 9) Return to Upper Menu");
			System.out.print("\n\t Menu Option: "); String menuOption = scan.nextLine();
			int numberTemp;

			switch(menuOption) {
				case "1":
				case "2":
				case "3":
				case "4":
					sections.get((Integer.parseInt(menuOption))-1).sellABook((numberTemp = takeBookNumber()));
					System.out.print("\n(->) \"" + sections.get((Integer.parseInt(menuOption))-1).getBook(numberTemp).getTitle().toUpperCase() + " by "  +"\" has been sold.");
					scan.nextLine(); // to ignore the "residual enter issue"
					scan.nextLine();
					/*scan.nextLine();
					String nameTemp = sections.get((Integer.parseInt(menuOption))-1).getBookTitle(takeBookNumber());
					sections.get((Integer.parseInt(menuOption))-1).sellABook(takeBookNumber());
					scan.nextLine(); // to ignore the "residual enter issue"
					System.out.println("(->) nameTemp has been sold.");
					//scan.nextLine();
					//clear();*/
					break;
				case "9":
					flag = false;
					break;
				default:
					System.out.print("\n(!) Select appropriate menu options.");
					scan.nextLine();
					break;
			}
		}
	}

	// sub-methods
	private Book takeBookInfo() {
		String title;
		String author;
		String publishDate;
		int price;

		System.out.println();
		System.out.print("# Title of The Book: "); title = scan.nextLine();
		System.out.print("# Author of The Book: "); author = scan.nextLine();
		System.out.print("# Publish Date of The Book: "); publishDate = scan.nextLine();
		System.out.print("# Price of The Book: "); price = scan.nextInt();

		Book book = new Book(title, author, publishDate, price);
		return book;
	}

	private int takeBookNumber() {
		int number;

		System.out.println();
		System.out.print("# The Number of The Book: "); number = scan.nextInt();

		return number;
	}

	// clear
	private void clear() {
		System.out.print("\033[H\033[2J");  
   		System.out.flush();  
	}

	// getters
	public String getName() {
		return this.name;
	}

	
}