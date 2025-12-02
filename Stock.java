import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the stock system for the vending machine.
 * @author Bruce Lam
 */
public class Stock
{
    private HashMap<Integer, Drinks> drinkStock;
    private HashMap<Integer, Snacks> snackStock;
    private String stockName;
    private int number;
    /**
     * Constructor to initialize the stock system of the vending machine
     */
    public Stock()
    {
        /*drinkStock = new HashMap<>();
        
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
        */
    }
    
    /**
     * Method to select a stock.
     */
    public void selectStock(String stockName, int number) {
        this.stockName = stockName.toLowerCase();
        this.number = number;
        /*if (this.stockName.equals("drinks") && drinkStock.containsKey(number)) {
            System.out.println(drinkStock.get(number));
        }
        else if (this.stockName.equals("snacks") && snackStock.containsKey(number)) {
            System.out.println(snackStock.get(number));
        }
        else if (!this.stockName.equals("snacks") && !this.stockName.equals("drinks")) {
            System.out.println("Invalid stock");
        }
        else if (!drinkStock.containsKey(number) && !snackStock.containsKey(number)) {
            System.out.println("Invalid number selection.");         
        }
        */
       
        switch (this.stockName.toLowerCase()) {
            case "drinks":
                if (drinkStock.containsKey(number)) {
                    System.out.println(drinkStock.get(number));
                }
                else {
                    System.out.println("Invalid number selection.");
                }
                break;
            case "snacks":
                if (snackStock.containsKey(number)) {
                    System.out.println(snackStock.get(number));
                }
                else {
                    System.out.println("Invalid number selection.");
                }
                break;
            default:
                    System.out.println("Invalid stock.");
                    break;
        }
    }
    /**
     * Method to add more to snack stock.
     */
    public void addToSnackStock(int amount)
    {   
        //Snacks.stockName.stockQuantity += amount;
    }
    
    /**
     * Method to add more to drink stock.
     */
    public void addToDrinkStock(int amount)
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
        System.out.println(drinkStock);
        System.out.println(snackStock);
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
