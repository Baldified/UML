
/**
 * Product class serves as a super class to Drink and Snack classes.
 * Has fields such as name, price, and quantity.
 * @author Bruce Lam
 */
public class Product
{
    public String name;
    public double price;
    public int quantity;
    
    /**
     * Constructor to create a new Product object.
     * @param name The name given to a product.
     * @param price The price given to a product.
     * @param quantity The quantity amount of a certain product.
     */
    public Product(String name, double price, int quanity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quanity;
    }
    
    /**
     * Method to view the price of a product.
     */
    public double getProductPrice() {
        return price;
    }
    
    /**
     * Method to view the name of a product.
     */
    public String getProductName() {
        return name;
    }
    
    /**
     * Method to view the quantity of a product.
     */ 
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
            System.out.println("\n----------------------");
            System.out.println("There is nothing to remove from.");
        }
    }
    
    /**
     * Method to add 1 to stock.
     */
    public void addToStock() {
        if (quantity < 10) {
            quantity++;
        }
        else if (quantity >= 10) {
            System.out.println("\n----------------------");
            System.out.println("The selected stock is currently full.");
        }
    }
}
