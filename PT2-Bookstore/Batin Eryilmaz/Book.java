package project2;
/**
 *
 * @author BATIN
 */
public class Book {
    private String Name;
    private int Price;

    public Book(String Name, int Price) {
        this.Name = Name;
        this.Price = Price;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return String.format("Book Name: %15s || Book Price: %3d$",Name,Price);
    }
    
    
}
