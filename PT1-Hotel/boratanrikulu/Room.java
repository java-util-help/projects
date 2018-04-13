/*
	NOTE: This program is written without using any IDE.
	Tests were completed manually by using java-9-openjdk.
	Please read the README.md file that is in the project.
*/
public class Room {

	/* instance variables */
	enum RoomType {
		ECONOMIC("Ecomomic Room", "> Our lowest priced room. Does not include anything except the bed!\n#    We recommend you only if you need somewhere to stay."),
		NORMAL("Normal Room", "> Our average priced room has products for general needs in the room.\n#    Also breakfast is free with the Normal Room."),
		ROYAL("Royal Room", "> Are you a member of a royal ?. Than come baby!\n#    But this room is extremely expensive!");

		/* constructor */
		String name;
		String feature;
		RoomType(String name, String feature){
			this.name = name;
			this.feature = feature;
		}

		/* getters */
		String getRoomFeature() {
			return this.feature;
		}
		String getRoomName() {
			return this.name;
		}

	}
	enum RoomStatus {
		NONAVAILABLE("NOT available"),
		AVAILABLE("available");

		String status;
		RoomStatus(String status) {
			this.status = status;
		}

		String getRoomStatus() {
			return this.status;
		}
	}
	private int price;
	public RoomStatus roomStatus;
	public Customer customer;
	public RoomType roomType;

	/* constructor */
	public Room(RoomType roomType, int price) {
		this.price = price;
		this.roomType = roomType;
		this.roomStatus = RoomStatus.AVAILABLE;
	}
	public Room() {
	}

	/* methods */
	public String displayCustomer() {
		return customer.display();
	}

	/* setters */
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
		this.roomStatus = RoomStatus.NONAVAILABLE;
	}
	public void addPrice(int price) {
		this.price += price;
	}
	/* getters */
	public int getPrice(){
		return this.price;
	}
	public  Customer getCustomer() {
		return this.customer;
	}
}