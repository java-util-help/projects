package project2;

/**
 *
 * @author BATIN
 */
public class SuperVisor extends Employee {

    private final int BaseSalary;

    public SuperVisor(String Name, String Surname, Sex sex, int HourlySalary, int Hours, int BaseSalary) {
        super(Name, Surname, sex, HourlySalary, Hours);
        this.BaseSalary = BaseSalary;
    }

    @Override
    public void salary() {
        super.salary();
        this.Salary += BaseSalary;
    }

    @Override
    public String toString() {
        return super.toString() + "|| Type: SuperVisor"; 
    }

    
}
