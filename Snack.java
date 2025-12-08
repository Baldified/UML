
/**
 * Snack class serves as a class to create snack objects.
 * Has fields such as snackFlavor and grams.
 * @author Bruce Lam
 */
public class Snack extends Product
{
    public SnackFlavor snackFlavor;
    public int grams;
    /**
     * Constructor to create a new Snack object.
     * @param name The name given to a snack.
     * @param price The price given to a snack.
     * @param quantity The quantity amount of a certain snack.
     * @param weight The amount of grams a snack has.
     * @param snackFlavor The flavor of a snack.
     */
    public Snack(String name, double price, int quantity, int weight, SnackFlavor snackFlavor) {
        super(name, price, quantity);
        this.snackFlavor = snackFlavor;
        grams = weight;
    }
    
    /**
     * Method to display the snack info.
     */
    public String displayProductInfo() {
        super.displayProductInfo();
        System.out.println("Weight: " + grams + "g");
        System.out.println("Type: " + snackFlavor);
        return " ";
    }
}
