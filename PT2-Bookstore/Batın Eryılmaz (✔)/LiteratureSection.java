
package project2;

import java.util.ArrayList;
/**
 *
 * @author BATIN
 */
public class LiteratureSection  extends Section {

    public LiteratureSection(int BookCount, Staff staff, ArrayList<Book> booklist) {
        super(BookCount, staff, booklist);
    }

    
@Override
    public void Display() {
        System.out.println("##Philosophy Section##");
        super.Display();
    }
    
        
    
}
