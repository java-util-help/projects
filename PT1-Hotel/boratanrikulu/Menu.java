/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.startMenu();
	}

	public void startMenu() {
		Scanner scan = new Scanner(System.in);
		// objects
		                                                            /*
		                                                             ┌────────────────────────────── 5    Economic Rooms
		                                                             │  ┌─────────────────────────── 8    Normal Rooms
		                                                             │  │  ┌──────────────────────── 2    Royal Rooms
		                                                             │  │  │  ┌───────────────────── 30$  for Economic Rooms
		                                                             │  │  │  │   ┌───────────────── 75$  for Normal Rooms
		                                                             │  │  │  │   │   ┌───────────── 250$ for Royal Rooms
		                                                             │  │  │  │   │   │
		                                                             │  │  │  │   │   │                                       */
		Hotel hotel = new Hotel("TANRIKULU HOTEL", "Bora Tanrikulu", 3, 4, 2, 30, 75, 250);


		while(true) {
			clear();
			for(int counter=0; counter<(hotel.getHotelName().length()+16); counter++)
				System.out.print("#");
			System.out.println("\n#       "+ hotel.getHotelName() +"       #");
			System.out.println("#");
			System.out.println("# 1) Make Reservation");
			System.out.println("# 2) Manage Your Reservation");
			System.out.println("# 3) Show All Rooms");
			System.out.println("#");
			String temp = "# 9) Exit";
			System.out.print(temp);
			for(int counter=0; counter<(hotel.getHotelName().length()+16-(temp.length()+1)); counter++)
				System.out.print(" ");
			System.out.print("#\n");
			for(int counter=0; counter<(hotel.getHotelName().length()+16); counter++)
				System.out.print("#");
			System.out.print("\n\t Menu Option: "); int menuOption = scan.nextInt();
			scan.nextLine();
			switch(menuOption) {
				case 1:
					clear();
					hotel.bookingMenu();
					break;
				case 2:
					clear();
					hotel.startManageReservation();
					break;
				case 3:
					clear();
					hotel.displayAll();
					break;
				case 9:
					System.exit(0);
					break;
				default:
					System.out.print("\n(!) Select appropriate menu options.");
					scan.nextLine();
					break;
			}
		}
	}

	public void clear() {
		System.out.print("\033[H\033[2J");  
   		System.out.flush();  
	}
}