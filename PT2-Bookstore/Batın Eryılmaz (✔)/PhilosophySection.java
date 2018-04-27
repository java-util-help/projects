
package project2;

import java.util.ArrayList;
/**
 *
 * @author BATIN
 */
public class PhilosophySection extends Section{

    public PhilosophySection(int BookCount, Staff staff, ArrayList<Book> booklist) {
        super(BookCount, staff, booklist);
    }

    @Override
    public void Display() {
        System.out.println("##Philosophy Section##");
        super.Display(); 
    }
    
}
