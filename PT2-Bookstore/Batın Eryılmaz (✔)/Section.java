
package project2;

import java.util.ArrayList;
/**
 *
 * @author BATIN
 */
public abstract class Section {
    protected final int BookCount;
    protected Staff staff;

    protected ArrayList<Book> booklist = new ArrayList();

    public Section(int BookCount, Staff staff,  ArrayList<Book> booklist) {
        this.BookCount = BookCount;
        this.staff = staff;
        
        booklist.forEach((book) -> { //arraylistlere ozel bir foreach (cool di mi? :D)
            this.booklist.add(book);
        });
        
    }

    public ArrayList<Book> getBooklist() {
        return booklist;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public int getBookCount() {
        return BookCount;
    }
    public void AddBook(Book book) {
        this.booklist.add(book);
    }

    
    public void Display() {
        System.out.printf("BookCount: %5d Staff: %s \n",BookCount,staff.getName());
        booklist.forEach((Book book) -> {
            System.out.printf("\t Book Name: %15s || Book Price: %5d $\n7",book.getName(),book.getPrice());
        });
         
    }
    
   
}
