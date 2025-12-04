
/**
 * Product class serves as a super class to Drink and Snack classes
 *
 * @author Bruce Lam
 */
public class Product
{
    public String name;
    public double price;
    public int quantity;
    
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
    
    public int getProductStock() {
        return quantity;
    }
    
    /**
     * Method to display the product info.
     */
    public String displayProductInfo() {
        System.out.println("Product: " + name + ", Price: $" + price);
        System.out.println("Stock: " + quantity);
        return " ";
    }
    
    /**
     * Method to remove 1 from stock.
     */
    public void removeFromStock() {
        if (quantity > 0) {
            quantity--;
        }
        else {
            System.out.println("There is no more stock");
        }
    }
    
    /**
     * Method to 
     */
    public void addToStock() {
        if (quantity < 10) {
            quantity++;
        }
        else if (quantity >= 10) {
            System.out.println("The stock is currently full.");
        }
    }
    
    public void payForProduct() {
        
    }
}
