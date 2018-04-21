
/**
 *
 * @author BATIN
 */
public class Customer {

    private String Name = "";
    private String Surname = "";
    private String Occupation = "";
    private int Age = 0;

    public enum Sex {
        Female,
        Male
    };
    Sex sex;

    public Customer() {

    }

    public Customer(String Name, String Surname, String Occupation, int Age, Sex sex) {
        this.Name = Name;
        this.Surname = Surname;
        this.Occupation = Occupation;
        this.Age = Age;
        this.sex = sex;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String Occupation) {
        this.Occupation = Occupation;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void Display() {
        if (this.Age != 0) {
            System.out.println("Name: " + Name + " Surname: " + Surname + " Occupation: " + Occupation + " Age: " + Age + " Sex: " + sex);


    }
}
}