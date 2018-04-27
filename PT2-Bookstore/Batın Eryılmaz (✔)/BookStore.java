package project2;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author BATIN
 */
public class BookStore {

    private final String StoreName;
    ArrayList<Book> booklist = new ArrayList();
    ArrayList<Employee> Employeelist = new ArrayList();
    Scanner sc = new Scanner(System.in);
    SecureRandom rand = new SecureRandom();
    private final SciFiSection SciFi;
    private final FantasticSection Fantastic;
    private final PhilosophySection Philosophy;
    private final LiteratureSection Literature;
    Employee Staff1 = new Staff("Batin", "Eryilmaz", Employee.Sex.MALE, 9000, 40);

    /*----------------------------------------------------------------------------*/
    Employee Staff2 = new Staff("Proje2yi", "YapınArtık", Employee.Sex.MALE, 9000, 40);
    Employee Staff3 = new Staff("Hasan", "Tezcan", Employee.Sex.MALE, 9000, 40);
    Employee Staff4 = new Staff("Bora", "Tanrıkulu", Employee.Sex.MALE, 9000, 40);
    Employee Staff5 = new Staff("Uzay", "Kaya", Employee.Sex.MALE, 9000, 40);
    Employee Sv = new SuperVisor("Batın", "Eryılmaz", Employee.Sex.MALE, 9000, 40, 5000);
    Book book1 = new Book("Harry Potter 1", 35);
    Book book2 = new Book("Harry Potter 2", 35);
    Book book3 = new Book("Harry Potter 3", 35);
    Book book4 = new Book("Harry Potter 4", 35);
    Book book5 = new Book("Harry Potter 5", 35);
    Book book6 = new Book("Harry Potter 6", 35);
    Book book7 = new Book("Harry Potter 7", 35);
    Book book8 = new Book("Fantastic", 35);
    Book book9 = new Book("Literature", 35);
    Book book10 = new Book("Philosophy", 35);

    /*----------------------------------------------------------------------------*/
    public BookStore(String StoreName) {
        this.StoreName = StoreName;
        SciFi = new SciFiSection(booklist.size(), ((Staff) Staff1), booklist);
        Fantastic = new FantasticSection(booklist.size(), ((Staff) Staff1), booklist);
        Philosophy = new PhilosophySection(booklist.size(), ((Staff) Staff1), booklist);
        Literature = new LiteratureSection(booklist.size(), ((Staff) Staff1), booklist);
        SciFi.AddBook(book1);
        SciFi.AddBook(book2);
        SciFi.AddBook(book3);
        SciFi.AddBook(book4);
        SciFi.AddBook(book5);
        SciFi.AddBook(book6);
        SciFi.AddBook(book7);
        Fantastic.AddBook(book8);
        Literature.AddBook(book9);
        Philosophy.AddBook(book10);
        booklist.add(book1);
        booklist.add(book2);
        booklist.add(book3);
        booklist.add(book4);
        booklist.add(book5);
        booklist.add(book6);
        booklist.add(book7);
        booklist.add(book8);
        booklist.add(book9);
        booklist.add(book10);
        Employeelist.add(Staff2);
        Employeelist.add(Staff3);
        Employeelist.add(Staff4);
        Employeelist.add(Staff5);
        Employeelist.add(Sv);
    }

    /*----------------------------------------------------------------------------*/
    public void Buy() {
        //Book book = new Book("Angels&Deamons", 50.0);
        while (true) {
            System.out.println("Please Enter Book Name");
            String BookName = sc.next();
            System.out.println("Please Enter Numbers of " + BookName + " Book");
            int BookC = GetInteger();
            Book book = new Book(BookName, ((rand.nextInt(15) + 30)));
            System.out.println("Which Section Will Those Books Be Stored");
            System.out.println("\t1 to Sci-Fi");
            System.out.println("\t2 to Fantastic");
            System.out.println("\t3 to Philosophy");
            System.out.println("\t4 to Literature");
            int choice = GetInteger(4);
            switch (choice) {
                case 1:
                    for (int i = 0; i < BookC; i++) {
                        SciFi.AddBook(book);
                        booklist.add(book);
                    }
                    break;
                case 2:
                    for (int i = 0; i < BookC; i++) {
                        Fantastic.AddBook(book);
                        booklist.add(book);
                    }
                    break;
                case 3:
                    for (int i = 0; i < BookC; i++) {
                        Philosophy.AddBook(book);
                        booklist.add(book);
                    }
                    break;
                case 4:
                    for (int i = 0; i < BookC; i++) {
                        Literature.AddBook(book);
                        booklist.add(book);
                    }
                    break;
                default:
                    System.out.println("Wrong");
                    break;
            }
            System.out.println("Would You Buy More Book? (y/n)");
            String c2 = sc.next().toLowerCase();
            if (c2.charAt(0) == 'n') {
                break;
            }
        }
    }

    /*----------------------------------------------------------------------------*/
    public void ShowSections() {
        System.out.println("Which Section Will You Want to See");
        System.out.println("\t1 to Sci-Fi");
        System.out.println("\t2 to Fantastic");
        System.out.println("\t3 to Philosophy");
        System.out.println("\t4 to Literature");
        int choice = GetInteger(4);
        switch (choice) {
            case 1:
                SciFi.Display();
                break;
            case 2:
                Fantastic.Display();
                break;
            case 3:
                Philosophy.Display();
                break;
            case 4:
                Literature.Display();
                break;
            default:
                System.out.println("Wrong");
                break;
        }

    }

    /*----------------------------------------------------------------------------*/
    public void Booklist() {

        booklist.forEach((book) -> {

            System.out.println(book);
        });

    }

    /*----------------------------------------------------------------------------*/
    public void Sell() {
        System.out.println("Welcome to " + this.StoreName);
        int counter = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("Which Section Will You Want to See");
            System.out.println("\t1 to Sci-Fi");
            System.out.println("\t2 to Fantastic");
            System.out.println("\t3 to Philosophy");
            System.out.println("\t4 to Literature");
            int choice = GetInteger(4);
            switch (choice) {
                case 1:
                    System.out.println("My Name is " + SciFi.getStaff().getName() + "How May I Help You ?\nWhich Book You Want to Buy?");
                    String Bname = sc.next();
                    for (int i = 0; i < booklist.size(); i++) {
                        if (Bname.equals(booklist.get(i).getName())) {
                            counter++;
                        }
                        if (counter == 1) {
                            System.out.println(booklist.get(i));
                            booklist.remove(booklist.get(i));
                        }
                    }
                    if (counter == 0) {
                        System.out.println("Sorry,We Do Not Have That Book.");
                    }
                    break;
                case 2:
                    System.out.println("My Name is " + Fantastic.getStaff().getName() + "How May I Help You?\nWhich Book You Want to Buy?");
                    String Bname1 = sc.next();
                    for (int i = 0; i < booklist.size(); i++) {
                        if (Bname1.equals(booklist.get(i).getName())) {
                            counter++;
                        }
                        if (counter == 1) {
                            System.out.println(booklist.get(i));
                            booklist.remove(booklist.get(i));
                        }
                    }
                    if (counter == 0) {
                        System.out.println("Sorry,We Do Not Have That Book.");
                    }
                    break;
                case 3:
                    System.out.println("My Name is " + Philosophy.getStaff().getName() + "How May I Help You?\nWhich Book You Want to Buy?");
                    String Bname2 = sc.next();
                    for (int i = 0; i < booklist.size(); i++) {
                        if (Bname2.equals(booklist.get(i).getName())) {
                            counter++;
                        }
                        if (counter == 1) {
                            System.out.println(booklist.get(i));
                            booklist.remove(booklist.get(i));
                        }
                    }
                    if (counter == 0) {
                        System.out.println("Sorry,We Do Not Have That Book.");
                    }
                    break;
                case 4:
                    System.out.println("My Name is " + Literature.getStaff().getName() + "How May I Help You?\nWhich Book You Want to Buy?");
                    String Bname3 = sc.next();
                    for (int i = 0; i < booklist.size(); i++) {
                        if (Bname3.equals(booklist.get(i).getName())) {
                            counter++;
                        }
                        if (counter == 1) {
                            System.out.println(booklist.get(i));
                            booklist.remove(booklist.get(i));
                        }
                    }
                    if (counter == 0) {
                        System.out.println("Sorry,We Do Not Have That Book.");
                    }
                    break;
                default:
                    System.out.println("Wrong");
                    break;
            }

            System.out.println("Do You Want to Buy Another Book?(y/n)");
            String c2 = sc.next().toLowerCase();
            if (c2.charAt(0) == 'n') {
                flag = false;
            }
        }
    }

    /*----------------------------------------------------------------------------*/
    public void Hire() {
        int counter = 0;
        System.out.println("Is He/She Supervisor?(y/n)");
        String c2 = sc.next().toLowerCase();
        switch (c2.charAt(0)) {
            case 'n': {
                System.out.print("Please Enter Employee Name: ");
                String Hname = sc.next();
                System.out.print("Please Enter Employee Surname: ");
                String Hsurname = sc.next();
                System.out.print("Please Enter Hourly Salary: ");
                int Hs = GetInteger();
                System.out.print("Please Enter Hour He/She Will Work: ");
                int H = GetInteger();
                System.out.println("1 -> Male \n2 -> Female");
                int S = GetInteger(2);
                boolean flag = true;
                while (flag) {
                    switch (S) {
                        case 1:
                            Employee he = new Staff(Hname, Hsurname, Employee.Sex.MALE, Hs, H);
                            for (int i = 0; i < Employeelist.size(); i++) {
                                if (Employeelist.get(i).getName().equals(he.getName()) && Employeelist.get(i).getSurname().equals(he.getSurname())) {
                                    counter++;
                                }

                            }
                            if (counter == 0) {
                                Employeelist.add(he);
                                System.out.println("She's been hired");
                            } else {
                                System.out.println("She is Exist");
                            }
                            /*Employeelist.forEach((Employee Employee) -> {
                                if (!Employee.equals(he)) {
                                Employeelist.add(he);
                                System.out.println("He's been hired");
                                } else {
                                System.out.println("He is Exist");
                                }
                                });*/

                            flag = false;
                            break;
                        case 2:
                            Employee she = new Staff(Hname, Hsurname, Employee.Sex.FEMALE, Hs, H);
                            for (int i = 0; i < Employeelist.size(); i++) {
                                if (Employeelist.get(i).getName().equals(she.getName()) && Employeelist.get(i).getSurname().equals(she.getSurname())) {
                                    counter++;
                                }

                            }
                            if (counter == 0) {
                                Employeelist.add(she);
                                System.out.println("She's been hired");
                            } else {
                                System.out.println("She is Exist");
                            }
                            /* Employeelist.forEach((Employee Employee) -> {
                                if (!Employee.equals(she)) {
                                Employeelist.add(she);
                                System.out.println("She's been hired");
                                } else {
                                System.out.println("She is Exist");
                                }  
                                });*/

                            flag = false;
                            break;
                        default:
                            System.out.println("1 or 2 You Should Chose");
                            break;
                    }
                }
                break;
            }
            case 'y': {
                System.out.print("Please Enter Employee Name: ");
                String Hname = sc.next();
                System.out.print("Please Enter Employee Surname: ");
                String Hsurname = sc.next();
                System.out.print("Please Enter Hourly Salary: ");
                int Hs = GetInteger();
                System.out.print("Please Enter Hour He/She Will Work: ");
                int H = GetInteger();
                System.out.print("Please Enter Base Salary: ");
                int B = GetInteger();
                System.out.println("1 -> Male \n2 -> Female");
                int S = GetInteger(2);
                boolean flag = true;

                while (flag) {
                    switch (S) {
                        case 1:
                            Employee he = new SuperVisor(Hname, Hsurname, Employee.Sex.MALE, Hs, H, B);
                            for (int i = 0; i < Employeelist.size(); i++) {
                                if (Employeelist.get(i).getName().equals(he.getName()) && Employeelist.get(i).getSurname().equals(he.getSurname())) {
                                    counter++;
                                }

                            }
                            if (counter == 0) {
                                Employeelist.add(he);
                                System.out.println("She's been hired");
                            } else {
                                System.out.println("She is Exist");
                            }
                            /*                        Employeelist.forEach((Employee) -> {
                                if (!Employee.equals(he)) {
                                Employeelist.add(he);
                                System.out.println("He's been hired");
                                } else {
                                System.out.println("He is Exist");
                                }
                                });
                             */
                            flag = false;
                            break;

                        case 2:
                            Employee she = new SuperVisor(Hname, Hsurname, Employee.Sex.FEMALE, Hs, H, B);
                            for (int i = 0; i < Employeelist.size(); i++) {
                                if (Employeelist.get(i).getName().equals(she.getName()) && Employeelist.get(i).getSurname().equals(she.getSurname())) {
                                    counter++;
                                }

                            }
                            if (counter == 0) {
                                Employeelist.add(she);
                                System.out.println("She's been hired");
                            } else {
                                System.out.println("She is Exist");
                            }
                            /* Employeelist.forEach((Employee) -> {
                                if (!Employee.equals(she)) {
                                Employeelist.add(she);
                                System.out.println("She's been hired");
                                } else {
                                System.out.println("She is Exist");
                                }  
                                });*/

                            flag = false;
                            break;
                        default:
                            System.out.println("1 or 2 You Should Chose");
                            break;
                    }
                }
                break;
            }
            default:
                System.out.println("Wrong!");
                break;
        }

    }

    /*----------------------------------------------------------------------------*/
    public void Firing() {
        System.out.println("Current List of Employees");
        EmployeeList();
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Please Enter Employee Name That You Want to Fire");
        String FName = sc.next();
        Employee fired1 = new Staff(FName, "Yoy", Employee.Sex.FEMALE, 0, 0);
        // Employee Fired2 = new SuperVisor(FName, "Yoy", Employee.Sex.FEMALE, 0, 0, 8);

        for (int i = 0; i < Employeelist.size(); i++) {
            if (Employeelist.get(i).getName().equals(fired1.getName())) {
                System.out.println("He/She Fired");
                Employeelist.remove(Employeelist.get(i));
            }
        }

    }

    /*----------------------------------------------------------------------------*/
    public void EmployeeList() {
        Employeelist.forEach((employee) -> {

            System.out.println(employee);
        });
    }

    /*-------------------------INPUT LOOP WITH TRY CATCH--------------------------*/
    public int GetInteger(int Num) {
        int input = -199;
        do {
            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please give a number between 1 and " + Num);
                sc.next();
            }
        } while (input == -199);
        return input;
    }

    public int GetInteger() {
        int input = -1999;
        do {
            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {

                sc.next();
            }
        } while (input < 0);
        return input;
    }
    /*----------------------------------------------------------------------------*/
}
