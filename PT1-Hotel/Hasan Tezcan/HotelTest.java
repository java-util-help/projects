package hotel;

import java.util.Scanner;

public class HotelTest {

    public static void hotelCreate(){
                
            Scanner scan = new Scanner(System.in);
        
            ///--START-- HOTEL CREATE SCREEN ---------
            
            System.out.println("---Create Your Hotel---");
            
            System.out.print("Enter your hotel Name: ");
            String hotelName = scan.next();
            
            System.out.print("How many rooms should hotel contain?");   //ING ÇEVİR.....!!!!
            int hotelRoomNumber = scan.nextInt();
            
            System.out.print("Enter yours hotel star:  ");
            int hotelStar = scan.nextInt();
            
            Hotel objHotel = new Hotel(hotelName,hotelRoomNumber,hotelStar);
            
            //--END-- HOTEL CREATE SCREEN ----------

            }
// HOTEL YARATMA KISMI OPSİYONEL OLCAK .....     
    
    public static void main(String[] args) {
//            
//            Room r1 = new Room(Room.roomSelect.economic3,"oda1");
//            Customer obj1 = new Customer("a","b","S",5,"55",r1 ,5,Customer.Tariff.justRoom);
//        
//            hotelCreate();
//           // objHotel.displayHotelInfo();
//        
            
// NOT: amaç :: method üzerinden hotel yaratmak ve sonra hotel class'ının methodolarına ulaşmak.  Static olan "hotelCreate" methodunu "objHotel" adlı obje oluşturdum ama 
// onu yemedi .. NASIL YAPILIR...



    //!! HOTEL YARATMA EKRANI KULLANILMAYACAKSA
        Hotel Tezcan = new Hotel("tezcan",20,5);
        Tezcan.createRoom();
        
        Tezcan.displayHotelInfo();
        Tezcan.getCustomer();
                    
        
    }
    
}
