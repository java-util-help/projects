package hotel;

public class Room {

    public enum roomSelect {
        economic2("ecomoic", 2, 45),
        economic3("ecomoic", 3, 45),
        economic4("ecomoic", 4, 45),
        normal2("normal", 2, 70),
        normal3("normal", 3, 70),
        normal4("normal", 4, 70),
        kingSuit("KingSuit", 2, 150);

        String roomType;
        int numberOfPeople;
        int roomPrice;

        roomSelect(String roomType, int numberOfPeople, int roomPrice) {  //enums constructor..
            this.roomType = roomType;
            this.numberOfPeople = numberOfPeople;
            this.roomPrice = roomPrice;
        }

        String getRoomName() {
            return roomType + " " + numberOfPeople;
        }
    }

    public roomSelect RS;
    public String roomName;

    public Room(roomSelect RS,String roomName) {  //constructor
        this.RS = RS;
        this.roomName = roomName;

    }

    public void Display() {
        System.out.println("Room Type= " + RS.roomType);
        System.out.println("Number Of People= " + RS.numberOfPeople);
        System.out.println("Room Price= " + RS.roomPrice);
    }

}
