
/**
 * Drink class serves as a class to create drink objects.
 * Has fields such as drinkType and volume.
 * @author Bruce Lam
 */
public class Drink extends Product
{
    public DrinkType drinkType;
    public int volume;
    /**
     * Constructor to create a new Drink object.
     * @param name The name given to a drink.
     * @param price The price given to a drink.
     * @param quantity The quantity amount of a certain drink.
     * @param volume The amount of volume a drink has.
     * @param drinkType The type of a drink.
     */
    public Drink(String name, double price, int quantity, int volume, DrinkType drinkType) {
        super(name, price, quantity);
        this.drinkType = drinkType;
        this.volume = volume;
    }
    
    /**
     * Method to display the drink info.
     */
    public String displayProductInfo() {
        super.displayProductInfo();
        System.out.println("Volume: " + volume + "ml");
        System.out.println("Type: " + drinkType);
        return " ";
    }
}
