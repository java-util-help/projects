

/**
 *
 * @author BATIN
 */
public class Room {

    private String RoomNumber;
    private double Bill;
    private final int CustomerCount;

    public enum Status {
        Avalible,
        NotAvalible
    }
    Status S;

    public enum Types {
        KingSuite,
        BedRoomFor2,
        BedRoomfor3,
        BedRoomfor4,
        EconomicRoom

    };
    Types type;
    Customer[] customers;

    public Room(String RoomNumber, double Bill, int CustomerCount, Types type) {
        this.RoomNumber = RoomNumber;
        this.Bill = Bill;
        this.CustomerCount = CustomerCount;
        this.type = type;
        customers = new Customer[CustomerCount];
        for (int i = 0; i < CustomerCount; i++) {
            customers[i] = new Customer();
        }
        this.S = Status.Avalible;
    }

    public Status getS() {
        return S;
    }

    public void setS(Status S) {
        this.S = S;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public double getBill() {
        return Bill;
    }

    public void setBill(double Bill) {
        this.Bill = Bill;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public void Display() {
        System.out.println("Room " + RoomNumber + " Room Type: " + type + " Status: " + S + " Bill: " + Bill);

    }

    public void DisplayCutomers() {
        for (Customer c1 : customers) {
           c1.Display();
            
        }

    }
}
