
/**
 * Snacks stock list
 */
public class Snack extends Product
{
    public SnackType snackType;
    public int grams;
    
    public Snack(String name, double price, int quantity, int weight, SnackType snackType) {
        super(name, price, quantity);
        this.snackType = snackType;
        grams = weight;
    }
    
    public void viewSnack() {
        super.displayProductInfo();
        System.out.println("Weight: " + grams + "g");
        System.out.println("Type: " + snackType);
    }
}
