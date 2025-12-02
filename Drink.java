
/**
 * Drinks stock list
 */
public class Drink extends Product
{
    public DrinkType drinkType;
    public int volume;
    public Drink(String name, double price, int quantity, int volume, DrinkType drinkType) {
        super(name, price, quantity);
        this.drinkType = drinkType;
        this.volume = volume;
    }
    
    public void viewDrink() {
        super.displayProductInfo();
        System.out.println("Volume: " + volume + "ml");
        System.out.println("Type: " + drinkType);
    }
}
