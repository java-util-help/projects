package project2;

/**
 *
 * @author BATIN
 */
public class BookStoreTest {

    public static void main(String[] args) {
        BookStore DR = new BookStore("D&R");
        //DR.Buy();
        //DR.ShowSections();
        // DR.Booklist();
        // DR.Buy();
        // DR.Booklist();
        //DR.Sell();
        // DR.Booklist();
        //DR.Hire();
        //DR.EmployeeList();
        boolean flag = true;
        while (flag) {
            System.out.println("1 to Buy from Supply");
            System.out.println("2 to Sell to Customer");
            System.out.println("3 to Hire an Emplloyee");
            System.out.println("4 to Fire an Emplloyee");
            System.out.println("5 to See List of Books");
            System.out.println("6 to See List of Emplloyees");
            System.out.println("7 to See The Sections");
            System.out.println("8 to EXIT");
            int choice = DR.GetInteger(8);
            switch (choice) {
                case 1:
                    DR.Buy();
                    break;
                case 2:
                    DR.Sell();
                    break;
                case 3:
                    DR.Hire();
                    break;
                case 4:
                    DR.Firing();
                    break;
                case 5:
                    DR.Booklist();
                    break;
                case 6:
                    DR.EmployeeList();
                    break;
                case 7:
                    DR.ShowSections();
                    break;
                     case 8:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong");
                    break;
            }

        }
    }

}
