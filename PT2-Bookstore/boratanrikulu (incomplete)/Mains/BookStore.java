/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {

	
	private ArrayList<Section> sections;
	private final String name;
	private final Scanner scan;
	private final double wholeSalerPercent;
	private double moneyCase;
	private Employee employeeTemp;
	private Employee employeeSuperVisor;

	// constructor
	public BookStore(String name,double moneyCase, double wholeSalerPercent) {
		if(name.equals(""))
			throw new IllegalArgumentException("(!) The Name of The Book Store is not entered.");
		if(moneyCase < 0)
			throw new IllegalArgumentException("(!) The Money Case can not be negative.");
		if(wholeSalerPercent < 0)
			throw new IllegalArgumentException("(!) Thw Whole Saler Percent can not be negative.");

		this.name = name;
		this.moneyCase = moneyCase;
		this.wholeSalerPercent = wholeSalerPercent;

		scan = new Scanner(System.in);
		// Creates Default Section Objects
		sections = new ArrayList<Section>();

		employeeSuperVisor = new SuperVisor("Lagertha", Employee.Gender.F, 35, 10);
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

	public void showAllEmployees() {
		int counter = 0;

		System.out.println("##########################################################################");
		System.out.println("#");
		System.out.println("# The SuperVisor of The BookStore >");
		System.out.println("#   - " + employeeSuperVisor.toString());
		for(Section temp : this.sections) {
			System.out.println("# ");
			temp.showTheEmployees();
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
					Book newBook = takeBookInfo();
					sections.get((Integer.parseInt(menuOption))-1).addABook(newBook);
					scan.nextLine(); // to ignore the "residual enter issue"
					this.moneyCase -= newBook.getPrice() * this.wholeSalerPercent;
					System.out.print("\n(->) \"" + newBook.getTitle().toUpperCase() + " by ");
					System.out.print(newBook.getAuthor() + "\" ");
					System.out.print("has been added.");
					System.out.print("\n(->) The Money Case: " + getMoneyCase() + "$");
						
					System.out.print("\n\n(->) Push enter to return Upper Menu.");
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

	public void hireAEmployee() {
		boolean flag = true;

		while(flag) {
			clear();
			System.out.println("##########################################################################");
			System.out.println("# Which Type Employee to Hire ?                                          #");
			System.out.println("#");
			System.out.println("# 1) SuperVisor");
			System.out.println("# 2) Staff");
			System.out.println("#");
			System.out.println("# 9) Return to Upper Menu                                                #");
			System.out.println("##########################################################################");
			System.out.print("\t Menu Option: "); String menuOption = scan.nextLine();
			switch(menuOption) {
				case "1":
					hireASuperVisor();
					break;
				case "2":
					hireAStaff();
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
			System.out.println("##########################################################################");
			System.out.println("# Which Section to Sell A Book ?");
			System.out.println("#");
			for(Section temp : this.sections) {
				System.out.println("# "+(++counter)+") " + temp.getName());
			}
			System.out.println("#");
			System.out.println("# 9) Return to Upper Menu");
			System.out.println("##########################################################################");

			System.out.print("\n\t Menu Option: "); String menuOption = scan.nextLine();
			int numberTemp;

			switch(menuOption) {
				case "1":
				case "2":
				case "3":
				case "4":
					clear();
					System.out.println("##########################################################################");
					System.out.println("# ");
						sections.get((Integer.parseInt(menuOption))-1).showTheBooks();
					System.out.println("#");
					System.out.println("##########################################################################");

					numberTemp = takeBookNumber();
					if(numberTemp <= sections.get((Integer.parseInt(menuOption))-1).getBooksNumber()) {
						Book deletedBook = sections.get((Integer.parseInt(menuOption))-1).getBook(numberTemp);
						sections.get((Integer.parseInt(menuOption))-1).sellABook(numberTemp);
						this.moneyCase += deletedBook.getPrice();
						System.out.print("\n(->) \"" + deletedBook.getTitle().toUpperCase() + " by " + deletedBook.getAuthor() + "\" has been sold."  );
						System.out.print("\n(->) The Money Case: " + getMoneyCase() + "$");
						
						System.out.print("\n\n(->) Push enter to return Upper Menu.");
						scan.nextLine(); // to ignore the "residual enter issue"
						scan.nextLine();
					}
					else {
						System.out.print("\n(!) The Book is not found.");
						scan.nextLine(); // to ignore the "residual enter issue"
						scan.nextLine();
					}
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

	public void fireAEmployee() {

	}

	// sub-methods
	private void hireAStaff() {
		clear();

		boolean flag = true;
		int counter = 0;
		while(flag) {
			clear();

			System.out.println("##########################################################################");
			System.out.println("# Which Section to Hire A Staff ?                                         #");
			System.out.println("#");
			for(Section temp : this.sections) {
				System.out.println("# "+(++counter)+") " + temp.getName());
			}
			System.out.println("#");
			System.out.println("# 9) Return to Upper Menu                                                #");
			System.out.println("##########################################################################");
			System.out.print("\t Menu Option: "); String menuOption2 = scan.nextLine();

			switch(menuOption2) {
				case "1":
				case "2":
				case "3":
				case "4":
					Employee newStaff = takeEmployeeInfo(1);
					sections.get((Integer.parseInt(menuOption2))-1).hireAEmployee(newStaff);
					scan.nextLine(); // to ignore the "residual enter issue"
					System.out.print("\n(->) \"" + newStaff.getName().toUpperCase() + "\" ");
					System.out.print(" has been hired.");
						
					System.out.print("\n\n(->) Push enter to return Upper Menu.");
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

	private void hireASuperVisor() {
		Employee newSuperVisor = takeEmployeeInfo(0);
		this.employeeSuperVisor = newSuperVisor;
		scan.nextLine(); // to ignore the "residual enter issue"
		System.out.print("\n(->) \"" + newSuperVisor.getName().toUpperCase() + "\" ");
		System.out.print("has been hired.");
			
		System.out.print("\n\n(->) Push enter to return Upper Menu.");
		scan.nextLine();
		clear();
	}

	private Book takeBookInfo() {
		Book book;
		String title;
		String author;
		String publishDate;
		int price;

		System.out.println();
		System.out.print("# Title of The Book: "); title = scan.nextLine();
		System.out.print("# Author of The Book: "); author = scan.nextLine();
		System.out.print("# Publish Date of The Book: "); publishDate = scan.nextLine();
		System.out.print("# Price of The Book: "); price = scan.nextInt();

		book = new Book(title, author, publishDate, price);
		return book;
	}

	private Employee takeEmployeeInfo(int type) {
		String name = "";
		Employee.Gender gender = Employee.Gender.F;
		int genderTemp = 0;
		int weeklyHours = 0;
		int hourlySalary = 0;

		boolean flag = true;
		while(flag) {
			flag = false;
			System.out.println();
			System.out.print("# Name of The Employee: "); name = scan.nextLine();
			System.out.print("# Gender of The Employee [Male:0/Female:1]: "); genderTemp = scan.nextInt();
			switch(genderTemp) {
				case 0:
					gender = Employee.Gender.M;
					break;
				case 1:
					gender = Employee.Gender.F;
					break;
				default:
					flag = true;
					System.out.print("\n(!) Please only select 0 or 1.");
					scan.nextLine(); // to ignore the "residual enter issue"
					scan.nextLine();
					continue;
			}
			System.out.print("# Weekly Hours of The Employee: "); weeklyHours = scan.nextInt();
			System.out.print("# Hourly Salary of The Employee: "); hourlySalary = scan.nextInt();
						
			if(type == 0)
				this.employeeTemp = new SuperVisor(name, gender, weeklyHours, hourlySalary);
			else if(type == 1)
				this.employeeTemp = new Staff(name, gender, weeklyHours, hourlySalary);
		}

		return this.employeeTemp;
	}

	private int takeBookNumber() {
		int number;

		System.out.println();
		System.out.print("# The Number of The Book: "); number = scan.nextInt();

		return (number-1);
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
	public double getMoneyCase() {
		return this.moneyCase;
	}	
}