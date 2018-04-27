package hotel;

import java.util.Scanner;

public class Hotel {
    
    private String Name;
    private int roomNumber;
    private int hotelStar;
    Room[] roomsAray;
    //These are keep the people count..
    int eco2=0;
    
    int eco4=0;
    int nrml2=0;
    
    int nrml4=0;
    int kingS=0;
    
    
    public Hotel(String Name, int roomNumber, int hotelStar){
        this.Name = Name;
        this.roomNumber = 20;
        this.hotelStar = hotelStar;
        createRoom();
        
        
    }
    
    
    public Hotel(){
        
    }

    public int getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(int hotelStar) {
        this.hotelStar = hotelStar;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    
    public void createRoom(){
        roomsAray = new Room[roomNumber];
        double preratio = 0.2;
       double ratio = (double)roomNumber * preratio;
        
       int stringCount = 0;
        for (; stringCount < ratio; stringCount++){
            roomsAray[stringCount]  = new Room(Room.roomSelect.economic2,"10"+stringCount);
            eco2++;
        }
        
        for (; stringCount < (ratio*2) ; stringCount++) {
            roomsAray[stringCount] = new Room(Room.roomSelect.economic4,"10"+stringCount);
            eco4++;
         }
        
        for (; stringCount < (ratio*3) ; stringCount++) {
           roomsAray[stringCount] = new Room(Room.roomSelect.normal2,"10"+stringCount);
            nrml2++;
         }
        
        for (; stringCount < (ratio*4) ; stringCount++) {
           roomsAray[stringCount] = new Room(Room.roomSelect.normal4,"10"+stringCount);
            nrml4++;
         }
        
        for (; stringCount < (ratio*5) ; stringCount++) {
            roomsAray[stringCount] = new Room(Room.roomSelect.kingSuit,"10"+stringCount);
            kingS++;
         }
        
        System.out.println("The rooms are ready.");
        System.out.println("##################");
         
    }
    
    
    public void displayHotelInfo(){
        System.out.print("\n------------------------------");
        System.out.println("Hotel Name ="+Name);
        System.out.println("Room Number ="+roomNumber);
        System.out.println("Hotel Star ="+hotelStar);
        
        for (int counter=0; counter < 20; counter++) {
            roomsAray[counter].Display();
        }
        
    }

    public void getCustomer() {

        Scanner scan = new Scanner(System.in);

        //------- GET CUSTOMER -------
        System.out.print("NAME =");
        String a = scan.next();

        System.out.print("SURNAME =");
        String b = scan.next();

        System.out.print("PROFESSION =");
        String c = scan.next();

        System.out.print("AGE =");
        String d = scan.next();

        System.out.println("ROOM TYPE =");

        System.out.println("economic2");
        System.out.println("economic3");
        System.out.println("economic4");
        System.out.println("normal2");
        System.out.println("normal3");
        System.out.println("normal4");
        System.out.println("KingSuit");

        String e = scan.next();

        System.out.println("HOW MANY NIGHT WILL YOU STAY? =");
        
        int f = scan.nextInt();

        System.out.println("CHOSE TARIFF TYPE =");

        System.out.println("1-justRoom");
        System.out.println("2-halfTariff");
        System.out.println("3-fullTariff");
        System.out.println("4-icludeEverything");

        String g = scan.next();
        
        
        
        

    }

}
