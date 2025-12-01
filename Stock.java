import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the stock system for the vending machine.
 * @author Dylan Scalia & Bruce Lam
 */
public class Stock
{
    HashMap<Integer, Drinks> drinkStock;
    HashMap<Integer, Snacks> snackStock;

    /**
     * Constructor to initialize the stock system of the vending machine
     */
    public Stock()
    {
        drinkStock = new HashMap<>();
        
        drinkStock.put(101, Drinks.Soda); // NUMBERS ARE WIP
        drinkStock.put(102, Drinks.Water);
        drinkStock.put(103, Drinks.Juice);
        drinkStock.put(104, Drinks.EnergyDrink);
        
        snackStock = new HashMap<>();
        
        snackStock.put(201, Snacks.Chips);
        snackStock.put(202, Snacks.Candy);
        snackStock.put(203, Snacks.Chocolate);
        snackStock.put(301, Snacks.Gum);
        snackStock.put(302, Snacks.Dessert);
    }
    
    /**
     * Method to select a stock.
     */
    public void selectStock(String stockName, int number) {
        if (stockName.equals("Drinks") && drinkStock.containsKey(number)) {
            System.out.println(drinkStock.containsValue(number)); //not working yet
        }
    }
    /**
     * Method to add more to a stock.
     */
    public void addToStock(int number, int amount)
    {   
        
    }
    
    /**
     * Method to remove from a stock.
     */
    public void removeStock(int number, int amount)
    {
        
    }
    
    /**
     * Method to view a stock.
     */
    public int checkStock(int number)
    {
        return number;
    }
    
    /**
     * Method to list all stocks
     */
    public void listAllStock()
    {
        
    }
    
    /**
     * Method to add to snack stock.
     */
    public HashMap addSnackStock(Snacks snack, int amount)
    {
        return null;
    }
    
    /**
     * Method to add to drink stock.
     */
    public HashMap addDrinkStock(Drinks drink, int amount)
    {
        return null;
    }
}
