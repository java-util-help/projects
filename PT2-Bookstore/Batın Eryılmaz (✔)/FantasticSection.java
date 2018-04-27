
package project2;

import java.util.ArrayList;
/**
 *
 * @author BATIN
 */
public class FantasticSection extends Section {

    public FantasticSection( int BookCount, Staff staff, ArrayList<Book> booklist) {
        super(BookCount, staff, booklist);
    }

   @Override
    public void Display() {
        System.out.println("##Fantastic Section##");
        super.Display(); 
    }
 
    
    
    
}
