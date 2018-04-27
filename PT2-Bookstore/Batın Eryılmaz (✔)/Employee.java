package project2;

/**
 *
 * @author BATIN
 */
public abstract class Employee {

    protected final String Name;
    protected final String Surname;

    public enum Sex {
        FEMALE,
        MALE
    }
    protected final Sex sex;
    protected final int HourlySalary;//hourly
    protected final int Hours;
    protected int Salary;

    public Employee(String Name, String Surname, Sex sex, int HourlySalary, int Hours) {
        this.Name = Name;
        this.Surname = Surname;
        this.sex = sex;
        this.HourlySalary = HourlySalary;
        this.Hours = Hours;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public Sex getSex() {
        return sex;
    }

    public int getSalary() {
        return HourlySalary;
    }

    public int getHours() {
        return Hours;
    }

    @Override
    public String toString() {
        return String.format("Name: %10s || Surname: %10s || Sex: %10s || Salary: %10s || Hours: %10s ", Name, Surname, sex, HourlySalary, Hours);
    }

    public void salary() {

        if (this.Hours % 40 > 0) {
            Salary += (HourlySalary*1.5) * (Hours % 40);
            Salary += HourlySalary*40;
        } else {
            Salary += HourlySalary * Hours;
        }
    }
}
