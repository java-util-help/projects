/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
package bookstore;
import java.util.Scanner;

public class Menu {
	private Scanner scan;
	private BookStore bookstore;

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.startMenu();
	}

	private void startMenu() {
		scan = new Scanner(System.in);
		bookstore = new BookStore("Tanrikulu BookStore", 1000, 0.7);

		while(true) {
			clear();
			String temp = "##########################################################################";
			System.out.println("##########################################################################");
			System.out.print("# ");
			for(int counter=0; counter<((temp.length()-bookstore.getName().length())/2)-2; counter++) {
				System.out.print(" ");
			}
			System.out.print("#" + bookstore.getName() + "#");
			for(int counter=0; counter<((temp.length()-bookstore.getName().length())/2)-2; counter++) {
				System.out.print(" ");
			}
			System.out.print("#\n");
			System.out.println("# ");
			System.out.println("# 1) Add or Sell Books");
			System.out.println("# 2) Manage Employees");
			
			System.out.println("# ");
			System.out.printf("# 9) Terminate The BookStore                  The Money Case: %9.2f$ #\n", bookstore.getMoneyCase());
			System.out.println("##########################################################################");
			System.out.print("\t Menu Option: "); String menuOption = scan.nextLine();

			switch(menuOption) {
				case "1":
					book();
					break;
				case "2":
					employee();
					break;
				case "9":
					System.exit(0);
					break;
				default:
					System.out.print("\n(!) Select appropriate menu options.");
					scan.nextLine();
					break;
			}
		}
	}

	private void book() {
		boolean flag = true;

		while(flag) {
			clear();
			System.out.println("##########################################################################");
			System.out.println("# Which Option Do You Want to Choose ?                                    #");
			System.out.println("# ");
			System.out.println("# 1) Add A Book");
			System.out.println("# 2) Sell A Book");
			System.out.println("# 3) Show All Books");
			System.out.println("# ");
			System.out.println("# 9) Return to Main Menu                                                 #");
			System.out.println("##########################################################################");
			System.out.print("\t Menu Option: "); String menuOption = scan.nextLine();

			switch(menuOption) {
				case "1":
					clear();
					bookstore.addABook();
					break;
				case "2":
					clear();
					bookstore.sellABook();
					break;
				case "3":
					clear();
					bookstore.showAllBooks();
					System.out.print("\n(->) Push enter to return Upper Menu.");
					scan.nextLine();
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

	private void employee() {
		boolean flag = true;

		while(flag) {
			clear();
			System.out.println("##########################################################################");
			System.out.println("# Which Option Do You Want to Choose ?                                    #");
			System.out.println("# ");
			System.out.println("# 1) Change/Hire A Employee");
			System.out.println("# 2) Fire A Employee");
			System.out.println("# 3) Show All Employees");
			System.out.println("# ");
			System.out.println("# 9) Return to Main Menu                                                 #");
			System.out.println("##########################################################################");
			System.out.print("\t Menu Option: "); String menuOption = scan.nextLine();

			switch(menuOption) {
				case "1":
					bookstore.hireAEmployee();
					clear();
					break;
				case "2":
					bookstore.fireAEmployee();
					clear();
					break;
				case "3":
					clear();
					bookstore.showAllEmployees();
					System.out.print("\n(->) Push enter to return Upper Menu.");
					scan.nextLine();
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

	private void clear() {
		System.out.print("\033[H\033[2J");  
   		System.out.flush();  
	}
}