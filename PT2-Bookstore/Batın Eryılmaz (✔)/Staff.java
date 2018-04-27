package project2;
/**
 *
 * @author BATIN
 */
public class Staff extends Employee {

    public Staff(String Name, String Surname, Sex sex, int HourlySalary, int Hours) {
        super(Name, Surname, sex, HourlySalary, Hours);
    }
    
     @Override
    public String toString() {
        return super.toString() + "|| Type:     Staff"; 
    }
}
