package hotel;

public class Room {

    public enum roomSelect {
        economic2("economic", 2, 45),
        economic4("economic", 4, 45),
        normal2("normal", 2, 70),
        normal4("normal", 4, 70),
        kingSuit("KingSuit", 2, 150);

        String roomType;
        int numberOfPeople;
        int oneManOneNigthPrice;

        roomSelect(String roomType, int numberOfPeople, int oneManOneNigthPrice) {  //enums constructor..
            this.roomType = roomType;
            this.numberOfPeople = numberOfPeople;
            this.oneManOneNigthPrice = oneManOneNigthPrice;
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
        System.out.println("Room Number= "+RS.getRoomName());
        System.out.println("Room Price Per a Person= " + RS.oneManOneNigthPrice);
    }

}
