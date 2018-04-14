
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author BATIN
 */
public class Hostel {

    Scanner sc = new Scanner(System.in);
    private final String HostelName;
    private final int TotalRoomCount;
    private final int FullService = 100;
    private final int HalfService = 80;
    private final int OnlyRoom = 60;
    private final int FrencToast = 10;
    private final int Burger = 12;
    private final int Water = 3;
    private final int percent;
    Room[] rooms;
    private int Bill = 0;
    private int r1 = 0;
    private int r2 = 0;
    private int r3 = 0;
    private int r4 = 0;
    private int r5 = 0;

    public Hostel(String HostelName, int TotalRoomCount) {
        this.HostelName = HostelName;
        this.TotalRoomCount = TotalRoomCount;
        percent = TotalRoomCount / 10;
        rooms = new Room[TotalRoomCount];
        for (int i = 0; i < TotalRoomCount; i++) {
            if (percent * 2 > i) {
                rooms[i] = new Room("10" + i, 0, 2, Room.Types.BedRoomFor2);
                r1++;
            }
            if (percent * 2 <= i && percent * 4 > i) {
                rooms[i] = new Room("10" + i, 0, 3, Room.Types.BedRoomFor3);
                r2++;
            }
            if (percent * 4 <= i && percent * 6 > i) {
                rooms[i] = new Room("10" + i, 0, 4, Room.Types.BedRoomFor4);
                r3++;
            }
            if (percent * 6 <= i && percent * 7 > i) {
                rooms[i] = new Room("10" + i, 100, 5, Room.Types.KingSuite);
                r4++;
            }
            if (percent * 7 <= i && TotalRoomCount > i) {
                rooms[i] = new Room("10" + i, -25, 6, Room.Types.EconomicRoom);
                r5++;
            }

        }
    }

    public void CutomerEnterence() {
        //Room TheRoom=new Room(OnlyRoom, Room.Types.KingSuite);
        System.out.println("Which type of room you would like to stay");
        System.out.println("1 to Regular  Bed Room For 2");
        System.out.println("2 to Regular  Bed Room For 3");
        System.out.println("3 to Regular  Bed Room For 4");
        System.out.println("4 to Economic Bed Room For 6");
        System.out.println("5 to King Suite For 5");
        int S = GetInteger(5);

        switch (S) {
            case 1:
                AddPerson(2, rooms[r1]);
                r1--;
                break;
            case 2:
                AddPerson(3, rooms[r2]);
                r2--;
                break;
            case 3:
                AddPerson(4, rooms[r3]);
                r3--;
                break;
            case 4:
                AddPerson(6, rooms[r4]);
                r4--;
                break;
            case 5:
                AddPerson(5, rooms[r5]);
                r5--;
                break;
            default:
                System.out.println("Wrong! Choice Must Be Between 1-5");
        }
    }

    private void AddPerson(int num, Room r) {

        int RoomMateCount = 0;
        ArrayList<Customer> list = new ArrayList();
        Customer c1;

        char Choice = 'Y';
        while (Choice == 'Y') {
            System.out.println((RoomMateCount + 1) + ".Person");

            System.out.print("Name: ");
            String Name = GetString();

            System.out.print("Surname: ");
            String Surname = GetString();

            System.out.print("Occupation: ");
            String Occupation = GetString();

            System.out.print("Age: ");
            int Age = GetInteger(100);

            System.out.println("1 -> Male \n2 -> Female");
            int Sex = GetInteger(2);
            while (true) {
                if (Sex == 1) {
                    c1 = new Customer(Name, Surname, Occupation, Age, Customer.Sex.Male);
                    break;
                } else if (Sex == 2) {
                    c1 = new Customer(Name, Surname, Occupation, Age, Customer.Sex.Male);
                    break;
                }
            }
            System.out.println("Which Service Do You Want? ");
            System.out.println(" 1 -> Full Service: 100$ \n 2 -> Half Service:80$ \n 3 -> Just Room:60$ ");
            int Service = GetInteger(3);
            while (true) {
                if (Service == 1) {
                    if (c1.getAge() > 12) {
                        Bill += FullService;
                    } else {
                        Bill += FullService / 2;
                    }
                    break;
                } else if (Service == 2) {
                    if (c1.getAge() > 12) {
                        Bill += HalfService;
                    } else {
                        Bill += HalfService / 2;
                    }
                    break;
                } else if (Service == 3) {
                    if (c1.getAge() > 12) {
                        Bill += OnlyRoom;
                    } else {
                        Bill += OnlyRoom / 2;
                    }
                    break;
                } else {
                    System.out.println("Wrong! Choice Must Between 1-3");
                }
            }
            r.setBill(Bill);
            list.add(c1);
            RoomMateCount++;
            System.out.println("Would you like to add more person?(Y/N)");
            String temp=sc.next().toUpperCase();
            Choice = temp.charAt(0);
           
            if (RoomMateCount == num) {
                Choice = 'N';
            }
        }
        Customer[] roomMates = list.toArray(new Customer[list.size()]);

        r.setCustomers(roomMates);
        r.setS(Room.Status.NotAvalible);
    }

    public void CustomerLeaves() {
        ArrayList<Customer> list = new ArrayList();
        System.out.print("Please Enter Your Room Number:");
        String num = GetString();
        Customer c2 = new Customer();
        for (Room room : rooms) {
            for (int i = 0; i < room.getCustomerCount(); i++) {
                 list.add(c2);
            }
        Customer[] roomMates = list.toArray(new Customer[list.size()]);
            if (room.getRoomNumber().equals(num)) {
                room.setS(Room.Status.Avalible);
                if (null != room.getType()) {
                    switch (room.getType()) {
                        case BedRoomFor2:
                            room.setBill(0);
                            room.setCustomers(roomMates);
                            break;
                        case BedRoomFor3:
                            room.setCustomers(roomMates);
                            room.setBill(0);
                            break;
                        case BedRoomFor4:
                            room.setCustomers(roomMates);
                            room.setBill(0);
                            break;
                        case EconomicRoom:
                            room.setCustomers(roomMates);
                            room.setBill(-50);
                            break;
                        case KingSuite:
                            room.setCustomers(roomMates);
                            room.setBill(100);
                            break;
                        default:
                            break;
                    }
                }

            }
        }

    }

    public void DisplayRooms() {

        for (Room room : rooms) {
            room.Display();
        }

    }

    public void DisplayCustomers() {
        for (Room room : rooms) {
            room.DisplayCutomers();
        }

    }

    public void Order() {
        System.out.print("Please Enter Room Number: ");
        String num = GetString();
        int Choice;
        for (Room room : rooms) {
            if (num.equals(room.getRoomNumber())) {

                boolean flag = true;
                while (flag) {

                    System.out.println("1 to French Toast: 10$");
                    System.out.println("2 to Burger: 12$");
                    System.out.println("3 to Water: 3$");
                    System.out.println("4 to Exit");
                    Choice = GetInteger(4);
                    switch (Choice) {
                        case 1:
                            System.out.println("You ordered Frech Toast");
                            Bill += FrencToast;
                            break;
                        case 2:
                            System.out.println("You ordered Burger");
                            Bill += Burger;
                            break;
                        case 3:
                            System.out.println("You ordered Water");
                            Bill += Water;
                            break;
                        case 4:
                            room.setBill(Bill);
                            flag = false;
                            break;
                        default:
                            System.out.println("Wrong! Choice Must Be Between 1-4");
                    }

                }
            }
        }

    }

    /*------------ONLY GETTER I NEED--------------*/
    public String getHostelName() {
        return HostelName;
    }

    /*-------------------------------------------*/

 /*---------------INPUT LOOP WITH TRY CATCH--------------*/
    public int GetInteger(int Num) {
        int input = 0;
        do {
            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please give a number between 1 and " + Num);
                sc.next();
            }
        } while (input == 0);
        return input;
    }

    public String GetString() {
        String s = "";
        boolean t = true;
        while (t) {
            try {
                s = sc.next();
                t = false;
            } catch (InputMismatchException e) {
                System.out.println("Wrong!");
                t = true;
            }
        }
        return s;
    }
    /*-------------------------------------------*/
}
