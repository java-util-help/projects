package hotel;

public class Customer {

    private String name;
    private String surname;
    private String profession;
    private int age;
    private String ID;
    private Room Room;
    private int howManyNight;
    private int bill = 0;   // müşterinin hesabı ..... tüm ücretlendirmeler bunun üstününe olucak

    public enum Tariff {           // pansiyonları burda aldırıdım seçime göre ana paraya ne kadar eklencek o belirleniyor.
        justRoom("justRoom", 0),
        halfTariff("halfTarif", 20),
        fullTariff("fullTarif", 40),
        includeEverything("includeEverything", 100);

        String tariffType;
        int credit;

        Tariff(String tariffType, int credit) {
            this.tariffType = tariffType;
            this.credit = credit;
        }
    }
    
    private Tariff tariff; 

    Customer(String name, String surname, String profession, int age, String ID, Room Room, int HowManyNight,Tariff tariff) {
        this.name = name;
        this.surname = surname;
        this.profession = profession;
        this.age = age;
        this.ID = ID;
        
        
        this.Room = Room; // hotel classında bunu aldıramadım...
        //  this.ta // tariff i buraya nasıl dahil edicem 
        
        this.tariff = tariff;

    }

    public int gethowManyNight() {
        return howManyNight;
    }

    public void sethowManyNight(int howManyNight) {
        this.howManyNight = howManyNight;
    }

    public Room getRoom() {
        return Room;
    }

    public void setRoom(Room room) {
        this.Room = room;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void Display() {
        System.out.println("Name= " + name);
        System.out.println("Surname= " + surname);
        System.out.println("Age= " + age);
        System.out.println("Profession= " + profession);
        System.out.println("ID= " + ID);
        System.out.println("How many night will they stay=" + howManyNight);

        //String kelek = Room.Display();
        System.out.println("Room Info= "); Room.Display();      // void tüüründeki bi şeyi sout içine çağıramassın ve herhangi bir değişkene eşitleyemezsin.

        System.out.println("Bill == " + bill);
    }

}
