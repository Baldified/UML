
/**
 * Drinks stock list
 * 
 * @author Bruce Lam
 */
public class Drink extends Product
{
    public DrinkFlavor drinkFlavor;
    public int volume;
    public Drink(String name, double price, int quantity, int volume, DrinkFlavor drinkFlavor) {
        super(name, price, quantity);
        this.drinkFlavor = drinkFlavor;
        this.volume = volume;
    }
    
    public void viewDrink() {
        super.displayProductInfo();
        System.out.println("Volume: " + volume + "ml");
        System.out.println("Type: " + drinkFlavor);
    }
}
