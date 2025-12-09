
/**
 * Snack class serves as a class to create snack objects.
 * Has fields such as snackFlavor, grams, and snackDetails.
 * @author Bruce Lam
 */
public class Snack extends Product
{
    public SnackFlavor snackFlavor;
    public int grams;
    public String snackDetails;
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
        snackDetails = (super.displayProductInfo()
                        + "\nWeight: " + grams + "g"
                        + "\nType: " + snackFlavor);
        return snackDetails;
    }
    
}
