
/**
 * Snacks stock list
 * 
 * @author Bruce Lam
 */
public class Snack extends Product
{
    public SnackFlavor snackFlavor;
    public int grams;
    
    public Snack(String name, double price, int quantity, int weight, SnackFlavor snackFlavor) {
        super(name, price, quantity);
        this.snackFlavor = snackFlavor;
        grams = weight;
    }
    
    public void viewSnack() {
        super.displayProductInfo();
        System.out.println("Weight: " + grams + "g");
        System.out.println("Type: " + snackFlavor);
    }
}
