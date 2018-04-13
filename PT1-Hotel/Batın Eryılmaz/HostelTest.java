

import java.util.Scanner;

/**
 *
 * @author BATIN
 */
public class HostelTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hostel h1 = new Hostel("Bato", 10);
        System.out.println("Welcome To Hostel " + h1.getHostelName());
        boolean flag = true;
        
        while (flag) {
            System.out.println("1 to Rent A Room");
            System.out.println("2 to List of Customers");
            System.out.println("3 to See The Rooms");
            System.out.println("4 to Order Something To Your Room");
            System.out.println("5 to Exit");
            int Choice = h1.GetInteger(5);
            switch (Choice) {
                case 1:
                    h1.CutomerEnterence();
                    break;
                case 2:
                    h1.DisplayCustomers();
                    break;
                case 3:
                    h1.DisplayRooms();
                    break;
                case 4:
                    h1.Order();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong! Choice Must Be Between 1-5");
            }
        }
    }
}
