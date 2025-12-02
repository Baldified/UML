
/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    public String name;
    public double price;
    public int quantity;
    
    /**
     * Constructor for objects of class Product
     */
    public Product() {
        Drink coke = new Drink("coke", 1.99, 10, 250, DrinkType.Sugar);
        coke.displayProductInfo();
    }
    
    /**
     * Constructor to initiate the product super class
     */
    public Product(String name, double price, int quanity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quanity;
    }
    
    /**
     * Method to view the price of a product
     */
    public double getProductPrice() {
        return price;
    }
    
    /**
     * Method to view the name of a product
     */
    public String getProductName() {
        return name;
    }
    
    /**
     * Method to display the product info
     */
    public void displayProductInfo() {
        System.out.println("Product: " + name + ", Price: $" + price);
        System.out.println("Stock: " + quantity);
    }
}
