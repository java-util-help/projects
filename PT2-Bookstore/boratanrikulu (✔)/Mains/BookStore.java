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
		if(employeeSuperVisor.getName() != null)
			System.out.println("#   - " + employeeSuperVisor.toString());
		else
			System.out.println("#   THIS SECTION HAS NOT A EMPLOYEE.");
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
					System.out.printf("\n(->) %.2f$ were paid to the WholeSaler.", (newBook.getPrice() * this.wholeSalerPercent));
					System.out.printf("\n(->) The Money Case: %.2f$",  getMoneyCase());
						
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
			System.out.println("# Which Type Employee to Change/Hire ?                                   #");
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
					if(!(this.employeeSuperVisor.getName() == null)) {
						if(sections.get((Integer.parseInt(menuOption))-1).getBooksNumber() >= 0) {
							if(!(sections.get((Integer.parseInt(menuOption))-1).getEmployee().getName() == null)) {
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
									System.out.printf("\n(->) %.2f$ were paid by the Customer.", (double)deletedBook.getPrice());
									System.out.printf("\n(->) The Money Case: %.2f$", getMoneyCase());
									
									System.out.print("\n\n(->) Push enter to return Upper Menu.");
									scan.nextLine(); // to ignore the "residual enter issue"
									scan.nextLine();
								}
								else {
									System.out.print("\n(!) The Book is not found.");
									scan.nextLine(); // to ignore the "residual enter issue"
									scan.nextLine();
								}
							}
							else {
								System.out.print("\n(!) This " + sections.get((Integer.parseInt(menuOption))-1).getName() + " Section has not any staff right now.");
								System.out.print("\n(!) Please hire a employee to sell book at this section.");
								scan.nextLine();
							}
						}
						else {
							System.out.print("\n(!) This " + sections.get((Integer.parseInt(menuOption))-1).getName() + " Section has not any book right now.");
							System.out.print("\n(!) Please add at least one book to sell book at this section.");
							scan.nextLine();
						}
					}
					else {
						System.out.print("\n(!) " + this.name + " has not a Super Visor right now. ");
						System.out.print("\n(!) Please hire a employee to sell book at BookStore.");
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
		boolean flag = true;

		while(flag) {
			clear();
			System.out.println("##########################################################################");
			System.out.println("# Which Type Employee to Fire ?                                          #");
			System.out.println("#");
			System.out.println("# 1) SuperVisor");
			System.out.println("# 2) Staff");
			System.out.println("#");
			System.out.println("# 9) Return to Upper Menu                                                #");
			System.out.println("##########################################################################");
			System.out.print("\t Menu Option: "); String menuOption = scan.nextLine();
			switch(menuOption) {
				case "1":
					fireASuperVisor();
					break;
				case "2":
					fireAStaff();
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
	private void hireAStaff() {
		clear();

		boolean flag = true;
		while(flag) {
			clear();
			int counter = 0;

			System.out.println("##########################################################################");
			System.out.println("# Which Section to Change/Hire A Staff ?                                 #");
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
					if(!(sections.get((Integer.parseInt(menuOption2))-1).getEmployee().getName() == null)) {
						System.out.print("\n(!) There is already a Staff of " + sections.get((Integer.parseInt(menuOption2))-1).getName().toUpperCase() + ".");
						System.out.print(".\n(->) Do You Want to Change The Staff [Y/N]? ");
						String menuOption3 = scan.nextLine();
						
						switch(menuOption3.toUpperCase()) {
							case "Y":
								if(takeEmployeeInfo(1)) {
									Employee newStaff = this.employeeTemp;
									Employee firedEmployee = sections.get((Integer.parseInt(menuOption2))-1).getEmployee();
									sections.get((Integer.parseInt(menuOption2))-1).hireAEmployee(newStaff);
									scan.nextLine(); // to ignore the "residual enter issue"
									
									System.out.print("\n(->) \"" + firedEmployee.getName().toUpperCase() + "\" ");
									System.out.print("has been fired.");
									this.moneyCase -= firedEmployee.getSalary();
									System.out.printf("\n(->) %.2f$ were paid to the Fired Employee.", (double)firedEmployee.getSalary());
									System.out.print("\n(->) \"" + newStaff.getName().toUpperCase() + "\" ");
									System.out.print(" has been hired.");
									System.out.printf("\n(->) The Money Case: %.2f$", getMoneyCase());

									System.out.print("\n\n(->) Push enter to return Upper Menu.");
									scan.nextLine();
									clear();
								}
							case "N":
								clear();
								break;
							default:
								flag = true;
								System.out.print("\n(!) Please only select Yes(Y) or No(N).");
								scan.nextLine();
								continue;
						}
					}

					else {
						if(takeEmployeeInfo(1)) {
							Employee newStaff = this.employeeTemp;
							sections.get((Integer.parseInt(menuOption2))-1).hireAEmployee(newStaff);
							scan.nextLine(); // to ignore the "residual enter issue"
							System.out.print("\n(->) \"" + newStaff.getName().toUpperCase() + "\" ");
							System.out.print(" has been hired.");
								
							System.out.print("\n\n(->) Push enter to return Upper Menu.");
							scan.nextLine();
							clear();
						}
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

	private void hireASuperVisor() {
		boolean flag = true;
		while(flag) {
			flag = false;
			if(!(this.employeeSuperVisor.getName() == null)) {
				System.out.print("\n(!) There is already a Super Visor of " + this.name.toUpperCase() + ".");
				System.out.print("\n(->) Do You Want to Change The Super Visor [Y/N]? ");
				String menuOption = scan.nextLine();

				switch(menuOption.toUpperCase()) {
					case "Y":
						if(takeEmployeeInfo(0)) {
							Employee firedEmployee = this.employeeSuperVisor;
							this.employeeSuperVisor = this.employeeTemp;
							scan.nextLine(); // to ignore the "residual enter issue"

							System.out.print("\n(->) \"" + firedEmployee.getName().toUpperCase() + "\" ");
							System.out.print("has been fired.");
							this.moneyCase -= firedEmployee.getSalary();
							System.out.printf("\n(->) %.2f$ were paid to the Fired Employee.", (double)firedEmployee.getSalary());
							System.out.print("\n(->) \"" + this.employeeSuperVisor.getName().toUpperCase() + "\" ");
							System.out.print("has been hired.");
							System.out.printf("\n(->) The Money Case: %.2f$", getMoneyCase());

							System.out.print("\n\n(->) Push enter to return Upper Menu.");
							scan.nextLine();
							clear();
						}
						break;
					case "N":
						clear();
						break;
					default:
						flag = true;
						System.out.print("\n(!) Please only select Yes(Y) or No(N).");
						scan.nextLine();
						continue;
				}
			}

			else {
				if(takeEmployeeInfo(0)) {
					this.employeeSuperVisor = this.employeeTemp;
					scan.nextLine(); // to ignore the "residual enter issue"
					System.out.print("\n(->) \"" + this.employeeSuperVisor.getName().toUpperCase() + "\" ");
					System.out.print("has been hired.");

					System.out.print("\n(->) Push enter to return Upper Menu.");
					scan.nextLine();
					clear();
				}
			}
		}	
	}
	
	private void fireAStaff() {
		clear();

		boolean flag = true;
		while(flag) {
			clear();
			int counter = 0;

			System.out.println("##########################################################################");
			System.out.println("# Which Section to Fire A Staff ?                                        #");
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
					if(!(sections.get((Integer.parseInt(menuOption2))-1).getEmployee().getName() == null)) {
						System.out.print("\n(!) The " + sections.get((Integer.parseInt(menuOption2))-1).getName().toUpperCase() + " Section can not sell books without a Staff.");
						System.out.print("\n(->) Are You Sure to Fire The Staff [Y/N]? ");
						
						String menuOption = scan.nextLine();
						switch(menuOption.toUpperCase()) {
							case "Y":
								Employee firedEmployee;
								firedEmployee = sections.get((Integer.parseInt(menuOption2))-1).getEmployee();
								Employee employeeStaffNULL = new Staff();
								sections.get((Integer.parseInt(menuOption2))-1).setEmployee(employeeStaffNULL);
								System.out.print("\n(->) \"" + firedEmployee.getName().toUpperCase() + "\" ");
								System.out.print("has been fired.");

								this.moneyCase -= firedEmployee.getSalary();
								System.out.printf("\n(->) %.2f$ were paid to the Fired Employee.", (double)firedEmployee.getSalary());
								System.out.printf("\n(->) The Money Case: %.2f$", getMoneyCase());
								
								System.out.print("\n\n(->) Push enter to return Upper Menu.");
								scan.nextLine();
								break;
							case "N":
								break;
							default:
								flag = true;
								System.out.print("\n(!) Please only select Yes(Y) or No(N).");
								scan.nextLine();
								continue;
						}
					}
					else {
						System.out.print("\n(!) There is no Staff of " + sections.get((Integer.parseInt(menuOption2))-1).getName().toUpperCase() + " to fire.");
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

	private void fireASuperVisor() {
		boolean flag = true;
		
		while(flag) {
			flag = false;
			if(!(this.employeeSuperVisor.getName() == null)) {
				System.out.print("\n(!) The BookStore can not sell books without a Super Visor.");
				System.out.print("\n(->) Are You Sure to Fire The Super Visor [Y/N]? ");
				
				String menuOption = scan.nextLine();
				switch(menuOption.toUpperCase()) {
					case "Y":
						Employee firedEmployee;
						firedEmployee = this.employeeSuperVisor;
						this.employeeSuperVisor = new SuperVisor();
						System.out.print("\n(->) \"" + firedEmployee.getName().toUpperCase() + "\" ");
						System.out.print("has been fired.");
						
						this.moneyCase -= firedEmployee.getSalary();
						System.out.printf("\n(->) %.2f$ were paid to the Fired Employee.", (double)firedEmployee.getSalary());
						System.out.printf("\n(->) The Money Case: %.2f$", getMoneyCase());
						
						System.out.print("\n\n(->) Push enter to return Upper Menu.");
						scan.nextLine();
						break;
					case "N":
						break;
					default:
						flag = true;
						System.out.print("\n(!) Please only select Yes(Y) or No(N).");
						scan.nextLine();
						continue;
				}
			}
			else {
				System.out.print("\n(!) There is no Super Visor to fire.");
				scan.nextLine();
			}
		}
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

	private boolean takeEmployeeInfo(int type) {
		String name = "";
		Employee.Gender gender = Employee.Gender.F;
		int weeklyHours = 0;
		int hourlySalary = 0;

		boolean flag = true;
		System.out.println();
		System.out.print("# Name of The Employee: "); name = scan.nextLine();
		System.out.print("# Gender of The Employee [M/F]: "); String genderTemp = scan.nextLine();
		switch(genderTemp.toUpperCase()) {
			case "M":
				gender = Employee.Gender.M;
				System.out.print("# Weekly Hours of The Employee: "); weeklyHours = scan.nextInt();
				System.out.print("# Hourly Salary of The Employee: "); hourlySalary = scan.nextInt();
							
				if(type == 0)
					this.employeeTemp = new SuperVisor(name, gender, weeklyHours, hourlySalary);
				else if(type == 1)
					this.employeeTemp = new Staff(name, gender, weeklyHours, hourlySalary);
				break;
			case "F":
				gender = Employee.Gender.F;
				System.out.print("# Weekly Hours of The Employee: "); weeklyHours = scan.nextInt();
				System.out.print("# Hourly Salary of The Employee: "); hourlySalary = scan.nextInt();
							
				if(type == 0)
					this.employeeTemp = new SuperVisor(name, gender, weeklyHours, hourlySalary);
				else if(type == 1)
					this.employeeTemp = new Staff(name, gender, weeklyHours, hourlySalary);
				break;
			default:
				flag = false;
				System.out.print("\n(!) Please only select Male(M) or Female(F).");
				scan.nextLine();
				break;
		}

		return flag;
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