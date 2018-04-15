/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
import java.util.Scanner;

public class Hotel {

	/* instance variables */
	enum FoodOrDrink {
		WATER("Water", 3),
		COKE("Coke", 5),
		BEER("Beer", 7),
		SANDWITCH("Sandwitch", 11);

		/* constructor */
		String name;
		int price;
		FoodOrDrink(String name, int price) {
			this.name = name;
			this.price = price;
		}

		/* getters */
		String getFoodOrDrinkName() {
			return this.name;
		}
		int getFoodOrDrinkPrice() {
			return this.price;
		}
	}

	private FoodOrDrink foodOrDrink;
	private String hotelName;
	private String hotelOwner;
	private int economicRoomNumbers;
	private int normalRoomNumbers;
	private int royalRoomNumbers;
	private int economicRoomPrice;
	private int normalRoomPrice;
	private int royalRoomPrice;
	private	Room[] economicRooms;
	private Room[] normalRooms;
	private Room[] royalRooms;
	Scanner scan = new Scanner(System.in);
	
	/* constructor */
	public Hotel(String hotelName, String hotelOwner, int economicRoomNumbers, int normalRoomNumbers, int royalRoomNumbers, int economicRoomPrice, int normalRoomPrice, int royalRoomPrice) {
		// control
		if("".equals(hotelName))
			throw new IllegalArgumentException("(!) Hotel name not entered.");
		if("".equals(hotelOwner))
			throw new IllegalArgumentException("(!) Hotel Owner name not entered.");
		if(economicRoomNumbers<0 || economicRoomPrice<0 || normalRoomNumbers<0 || normalRoomPrice<0 || royalRoomNumbers<0 || royalRoomPrice<0)
			throw new IllegalArgumentException("(!) Do not enter negative values as room number or price.");
		
		this.hotelName = hotelName;
		this.hotelOwner = hotelOwner; 
		this.economicRoomNumbers = economicRoomNumbers;
		this.normalRoomNumbers = normalRoomNumbers;
		this.royalRoomNumbers = royalRoomNumbers;
		this.economicRoomPrice = economicRoomPrice;
		this.normalRoomPrice = normalRoomPrice;
		this.royalRoomPrice = royalRoomPrice;
		
		// room arrays
		economicRooms = new Room[this.economicRoomNumbers];
		normalRooms = new Room[this.normalRoomNumbers];
		royalRooms = new Room[this.royalRoomNumbers];
		
		// room objects
		for(int counter=0; counter<economicRoomNumbers; counter++) {
			economicRooms[counter] = new Room(Room.RoomType.ECONOMIC, this.economicRoomPrice);
		}
		for(int counter=0; counter<normalRoomNumbers; counter++) {
			normalRooms[counter] = new Room(Room.RoomType.NORMAL, this.normalRoomPrice);
		}
		for(int counter=0; counter<royalRoomNumbers; counter++) {
			royalRooms[counter] = new Room(Room.RoomType.ROYAL, this.royalRoomPrice);
		}
	}

	/* methods */
	public void bookingMenu() {
		boolean infinity = true;
		while(infinity) {
			clear();
			System.out.println("##########################################################################");
			System.out.println("# Which Class Do You Want to Choose ?                                    #");
			System.out.println("#");
			System.out.println("# 1) "+ Room.RoomType.ECONOMIC.getRoomName() +" ("+this.economicRoomPrice+"$)\n#  "+
									Room.RoomType.ECONOMIC.getRoomFeature());
			System.out.println("#");
			System.out.println("# 2) "+ Room.RoomType.NORMAL.getRoomName() +" ("+this.normalRoomPrice+"$)\n#  "+
									Room.RoomType.NORMAL.getRoomFeature());
			System.out.println("#");
			System.out.println("# 3) "+ Room.RoomType.ROYAL.getRoomName() +" ("+this.royalRoomPrice+"$)\n#  "+
									Room.RoomType.ROYAL.getRoomFeature());
			System.out.println("#");
			System.out.println("# 9) Return to Main Menu                                                 #");
			System.out.println("##########################################################################");
			System.out.print("\t Menu Option: "); int menuOption2 = scan.nextInt();
			scan.nextLine();

				switch(menuOption2) {
					case 1:
						System.out.println();
						if(economicRooms[(economicRoomNumbers-1)].roomStatus == Room.RoomStatus.NONAVAILABLE)
							System.out.print("(!) Sorry! All "+ Room.RoomType.ECONOMIC.getRoomName() +"s are booked.");
						else
							System.out.print(booking(Room.RoomType.ECONOMIC, getInfo()));
						scan.nextLine(); // to see result.
						break;
					case 2:
						System.out.println();
						if(normalRooms[(normalRoomNumbers-1)].roomStatus == Room.RoomStatus.NONAVAILABLE)
							System.out.print("(!) Sorry! All "+ Room.RoomType.NORMAL.getRoomName() +"s are booked.");
						else
							System.out.print(booking(Room.RoomType.NORMAL, getInfo()));
						scan.nextLine(); // to see result.
						break;
					case 3:
						System.out.println();
						if(royalRooms[(royalRoomNumbers-1)].roomStatus == Room.RoomStatus.NONAVAILABLE)
							System.out.print("(!) Sorry! All "+ Room.RoomType.ROYAL.getRoomName() +"s are booked.");
						else
							System.out.print(booking(Room.RoomType.ROYAL, getInfo()));
						scan.nextLine(); // to see result.
						break;
					case 9:
						infinity = false;
						break;
					default:
						System.out.print("(!) Select appropriate menu options.");
						scan.nextLine();
						break;
				}
		}
	}

	public Customer getInfo() {
		String nameTemp, surnameTemp, jobTemp;
		int ageTemp;
		System.out.print("# Name:  "); nameTemp = scan.nextLine();
		System.out.print("# Surname: "); surnameTemp = scan.nextLine();
		System.out.print("# Age: "); ageTemp = scan.nextInt();
		scan.nextLine();
		System.out.print("# Job: "); jobTemp = scan.nextLine();
		System.out.println();
		Customer customerTemp = new Customer(nameTemp, surnameTemp, ageTemp, jobTemp);
		return customerTemp;
	}

	public String booking(Room.RoomType roomType, Customer customer) {
		switch(roomType) {
			case ECONOMIC:
				for(int roomNumber=0; roomNumber<economicRoomNumbers; roomNumber++) {
				 	if(economicRooms[roomNumber].roomStatus == Room.RoomStatus.AVAILABLE) {
						economicRooms[roomNumber].setCustomer(customer);
						return "(->) The registration was successful.";
					}
				}

			case NORMAL:
				for(int roomNumber=0; roomNumber<normalRoomNumbers; roomNumber++) {
					if(normalRooms[roomNumber].roomStatus == Room.RoomStatus.AVAILABLE) {
						normalRooms[roomNumber].setCustomer(customer);
						return "(->) The registration was successful.";
					}
				}

			case ROYAL:
				for(int roomNumber=0; roomNumber<royalRoomNumbers; roomNumber++) {
				 	if(royalRooms[roomNumber].roomStatus == Room.RoomStatus.AVAILABLE) {
						royalRooms[roomNumber].setCustomer(customer);
						return "(->) The registration was successful.";
					}
				}
			default:
				return "";
		}
	}

	public void displayAll() {
		System.out.println("##########################################################################");
		System.out.println("#                                                                        #");
		display(Room.RoomType.ECONOMIC);
		System.out.println("#");
		display(Room.RoomType.NORMAL);
		System.out.println("#");
		display(Room.RoomType.ROYAL);
		System.out.println("#                                                                        #");
		System.out.println("##########################################################################");
		System.out.print("\n(->) Push enter to return Main Menu."); scan.nextLine();
	}

	public void display(Room.RoomType roomType) {
		switch(roomType) {
			case ECONOMIC:
				System.out.println("# "+Room.RoomType.ECONOMIC.getRoomName()+"\t>>");
				for(int counter=0; counter<economicRoomNumbers; counter++) {
					System.out.printf("# %2d. %s is %s\n", (counter+1), economicRooms[counter].roomType.getRoomName(), economicRooms[counter].roomStatus.getRoomStatus());
					if(economicRooms[counter].roomStatus == Room.RoomStatus.NONAVAILABLE)
						System.out.println("# \tCustomer: "+economicRooms[counter].displayCustomer());
				}
				break;
			
			case NORMAL:
				System.out.println("# "+Room.RoomType.NORMAL.getRoomName()+"\t>>");
				for(int counter=0; counter<normalRoomNumbers; counter++) {
					System.out.printf("# %2d. %s is %s\n", (counter+1), normalRooms[counter].roomType.getRoomName(), normalRooms[counter].roomStatus.getRoomStatus());
					if(normalRooms[counter].roomStatus == Room.RoomStatus.NONAVAILABLE)
						System.out.println("# \tCustomer: "+normalRooms[counter].displayCustomer());
				}
				break;

			case ROYAL:
				System.out.println("# "+Room.RoomType.ROYAL.getRoomName()+"\t>>");
				for(int counter=0; counter<royalRoomNumbers; counter++) {
					System.out.printf("# %2d. %s is %s\n", (counter+1), royalRooms[counter].roomType.getRoomName(), royalRooms[counter].roomStatus.getRoomStatus());
					if(royalRooms[counter].roomStatus == Room.RoomStatus.NONAVAILABLE)
						System.out.println("# \tCustomer: "+royalRooms[counter].displayCustomer());
				}
				break;

			default:
				break;
		}
	}

	public void startManageReservation() {
		clear();
		int roomNumberTemp;
		Room roomTemp = new Room();
		
		clear();
		System.out.println("##########################################################################");
		System.out.println("# What is Your Room Type ?                                              #");
		System.out.println("#");
		System.out.println("# 1) "+ Room.RoomType.ECONOMIC.getRoomName());
		System.out.println("# 2) "+ Room.RoomType.NORMAL.getRoomName());
		System.out.println("# 3) "+ Room.RoomType.ROYAL.getRoomName());
		System.out.println("#");
		System.out.println("# 9) Return to Main Menu                                                 #");
		System.out.println("##########################################################################");
		System.out.print("\t Menu Option: "); int menuOption2 = scan.nextInt();
		scan.nextLine();
		switch(menuOption2) {
			case 1:
				System.out.print("\n# Room Number: "); roomNumberTemp = scan.nextInt();
				roomTemp.setRoomType(Room.RoomType.ECONOMIC);
				if(controlInfo(roomTemp.roomType, roomNumberTemp-1) == true)
					manageReservation(roomTemp, roomNumberTemp-1);
				else {
					System.out.print("\n(!) No reservation was found for \""+roomTemp.roomType.getRoomName()+" "+roomNumberTemp+"\"");
					scan.nextLine();scan.nextLine();
				}
				break;
			case 2:
				System.out.print("\n# Room Number: "); roomNumberTemp = scan.nextInt();
				roomTemp.setRoomType(Room.RoomType.NORMAL);
				if(controlInfo(roomTemp.roomType, roomNumberTemp-1) == true)
					manageReservation(roomTemp, roomNumberTemp-1);
				else {
					System.out.print("\n(!) No reservation was found for \""+roomTemp.roomType.getRoomName()+" "+roomNumberTemp+"\"");
					scan.nextLine();scan.nextLine();
				}
				break;
			case 3:
				System.out.print("\n# Room Number: "); roomNumberTemp = scan.nextInt();
				roomTemp.setRoomType(Room.RoomType.ROYAL);
				if(controlInfo(roomTemp.roomType, roomNumberTemp-1) == true)
					manageReservation(roomTemp, roomNumberTemp-1);
				else {
					System.out.print("\n(!) No reservation was found for \""+roomTemp.roomType.getRoomName()+" "+roomNumberTemp+"\"");
					scan.nextLine();scan.nextLine();
				}
				break;
			case 9:
				break;
			default:
				System.out.print("\n(!) Select appropriate menu options.");
				scan.nextLine();
				break;
		}
	}

	public boolean controlInfo(Room.RoomType roomType, int roomNumber) {
		switch(roomType) {
			case ECONOMIC:
                return economicRooms[roomNumber].roomStatus == Room.RoomStatus.NONAVAILABLE;
			case NORMAL:
                return normalRooms[roomNumber].roomStatus == Room.RoomStatus.NONAVAILABLE;
			case ROYAL:
                return royalRooms[roomNumber].roomStatus == Room.RoomStatus.NONAVAILABLE;
			default:
				return false;
		}
	}

	public void manageReservation(Room roomTemp, int roomNumberTemp) {
		boolean infinity = true;
		while(infinity) {	
			clear();
			System.out.println("##########################################################################");
			System.out.println("# What Do You Want to Do ?                                               #");
			System.out.println("#");
			System.out.println("# 1) Order Food or Drink");
			System.out.println("# 2) See Current Room Charge");
			System.out.println("# 3) Check Out");
			System.out.println("#");
			System.out.println("# 9) Return to Main Menu                                                 #");
			System.out.println("##########################################################################");
			System.out.print("\t Menu Option: "); int menuOption4 = scan.nextInt();
			scan.nextLine();
			clear();
			switch(menuOption4) {
				case 1:
					orderFoodOrDrink(roomTemp.roomType, roomNumberTemp);
					break;
				case 2:
					showCurrentCharge(roomTemp.roomType, roomNumberTemp);
					System.out.print("\n(->) Push enter to return Upper Menu."); scan.nextLine();
					break;
				case 3:
					infinity = ( checkOut(roomTemp.roomType, roomNumberTemp) );
					break;
				case 9:
					infinity = false;
					break;
				default:
					System.out.print("(!) Select appropriate menu options.");
					scan.nextLine();
					break;
			}
		}
	}

	public void orderFoodOrDrink(Room.RoomType roomType, int roomNumber) {
		clear();
		System.out.println("##########################################################################");
		System.out.println("# Which Food/Drink Do You Want to Choose ?                               #");
		System.out.println("#");
		System.out.println("# 1) "+FoodOrDrink.WATER.getFoodOrDrinkName()+" ("+FoodOrDrink.WATER.getFoodOrDrinkPrice()+"$)");
		System.out.println("# 2) "+FoodOrDrink.COKE.getFoodOrDrinkName()+" ("+FoodOrDrink.COKE.getFoodOrDrinkPrice()+"$)");
		System.out.println("# 3) "+FoodOrDrink.BEER.getFoodOrDrinkName()+" ("+FoodOrDrink.BEER.getFoodOrDrinkPrice()+"$)");
		System.out.println("# 4) "+FoodOrDrink.SANDWITCH.getFoodOrDrinkName()+" ("+FoodOrDrink.SANDWITCH.getFoodOrDrinkPrice()+"$)");
		System.out.println("#");
		System.out.println("# 9) Return to Main Menu                                                 #");
		System.out.println("##########################################################################");
		System.out.print("\t Menu Option: "); int menuOption2 = scan.nextInt();
		scan.nextLine();

		switch(menuOption2) {
				case 1:
					addPrice(roomType, roomNumber, FoodOrDrink.WATER.getFoodOrDrinkPrice());
					System.out.print("\n(->) Water has been ordered.");
					scan.nextLine(); // to see result.
					break;
				case 2:
					addPrice(roomType, roomNumber, FoodOrDrink.COKE.getFoodOrDrinkPrice());
					System.out.print("\n(->) Coke has been ordered.");
					scan.nextLine(); // to see result.
					break;
				case 3:
					addPrice(roomType, roomNumber, FoodOrDrink.BEER.getFoodOrDrinkPrice());
					System.out.print("\n(->) Beer has been ordered.");
					scan.nextLine(); // to see result.
					break;
				case 4:
					addPrice(roomType, roomNumber, FoodOrDrink.SANDWITCH.getFoodOrDrinkPrice());
					System.out.print("\n(->) Sandwitch has been ordered.");
					scan.nextLine(); // to see result.
					break;
				case 9:
					break;
				default:
					System.out.print("(!) Select appropriate menu options.");
					scan.nextLine(); // to see result.
					break;
		}
	}

	public boolean checkOut(Room.RoomType roomType, int roomNumber) {
		showCurrentCharge(roomType, roomNumber);

		System.out.print("\n# Are you sure to leave the hotel (y/n)? ");
		String temp = scan.nextLine().toLowerCase();

		boolean infinityTemp = true;
		switch(temp) {
			case "y":
				if(deleteReservation(roomType, roomNumber) == true) {
					infinityTemp = false;
					System.out.print("\n(->) Deleting the reservation was successful.");
				}
				else
					System.out.print("\n(!) The reservation could not find.");
					
				scan.nextLine();
				break;
			case "n":
				break;
			default:
				System.out.print("\n(!) Select appropriate menu options.");
				scan.nextLine();
				break;
		}
		return infinityTemp;
 	}

 	public boolean deleteReservation(Room.RoomType roomType, int roomNumber) {
 		switch(roomType) {
 			case ECONOMIC:
	 			if(economicRooms[roomNumber].roomStatus == Room.RoomStatus.NONAVAILABLE) {
	 				for(int counter=roomNumber; counter<economicRoomNumbers; counter++) {
					 	if(economicRooms[counter+1].roomStatus == Room.RoomStatus.AVAILABLE)
							break;
						else {
							economicRooms[counter].setCustomer(economicRooms[counter+1].getCustomer());
						}
					}
	 				return true;
	 			}
	 			else
	 				return false;
 			case NORMAL:
	 			if(normalRooms[roomNumber].roomStatus == Room.RoomStatus.NONAVAILABLE) {
	 				for(int counter=roomNumber; counter<normalRoomNumbers; counter++) {
					 	if(normalRooms[counter+1].roomStatus == Room.RoomStatus.AVAILABLE)
							break;
						else {
							normalRooms[counter].setCustomer(normalRooms[counter+1].getCustomer());
							normalRooms[counter].roomStatus = Room.RoomStatus.NONAVAILABLE;
							normalRooms[counter+1].roomStatus = Room.RoomStatus.AVAILABLE;
						}
					}
	 				return true;
	 			}
	 			else
	 				return false;
 			case ROYAL:
	 			if(royalRooms[roomNumber].roomStatus == Room.RoomStatus.NONAVAILABLE) {
	 				for(int counter=roomNumber; counter<royalRoomNumbers; counter++) {
					 	if(royalRooms[counter+1].roomStatus == Room.RoomStatus.AVAILABLE)
							break;
						else {
							royalRooms[counter].setCustomer(royalRooms[counter+1].getCustomer());
						}
					}
	 				return true;
	 			}
	 			else
	 				return false;
 			default:
 				return false;
 		}
 	}

	public void showCurrentCharge(Room.RoomType roomType, int roomNumber) {
		System.out.println("##########################################################################");
		System.out.println("#                                                                        #");
		System.out.println("# The Current Charge of \""+ roomType.getRoomName()+" "+(roomNumber+1)+"\"");
		System.out.println("# Charge: "+ getPrice(roomType, roomNumber)+"$");
		System.out.println("#                                                                        #");
		System.out.println("##########################################################################");
	}

	public void addPrice(Room.RoomType roomType, int roomNumber, int price) {
		switch(roomType) {
			case ECONOMIC:
				economicRooms[roomNumber].addPrice(price);
				break;

			case NORMAL:
				normalRooms[roomNumber].addPrice(price);
				break;

			case ROYAL:
				royalRooms[roomNumber].addPrice(price);
				break;
		}
	}

	public int getPrice(Room.RoomType roomType, int roomNumber) {
		switch(roomType) {
			case ECONOMIC:
				return economicRooms[roomNumber].getPrice();
			case NORMAL:
				return normalRooms[roomNumber].getPrice();
			case ROYAL:
				return royalRooms[roomNumber].getPrice();
			default:
				return 0;
		}
	}

	public void clear() {
		System.out.print("\033[H\033[2J");  
   		System.out.flush();  
	}

	/* getters */
	public String getHotelName() {
		return hotelName;
	}
}