
package project2;

import java.util.ArrayList;
/**
 *
 * @author BATIN
 */
public class SciFiSection extends Section {

    public SciFiSection(int BookCount, Staff staff, ArrayList<Book> booklist) {
        super(BookCount, staff, booklist);
    }

    @Override
    public void Display() {
        System.out.println("##Sci-Fi Section##");
        super.Display(); 
    }

 
  

    
    
    
}
