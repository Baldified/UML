import java.util.HashMap;

/**
 * This class represents a vending machine.
 * @author Dylan Scalia & Bruce Lam
 */
public class VendingMachine 
{
    int currentSelection;
    HashMap<Integer, Product> stock;
    int confirmation;
    /**
     * Constructor to initiate the vending machine class.
     * 
     */
    public VendingMachine()
    {
        stock = new HashMap<>();
        
        Drink coke = new Drink("Coke", 1.99, 10, 250, DrinkFlavor.Sugar);
        Drink juice = new Drink("Juice", 1.49, 10, 350, DrinkFlavor.Sugar);
        Drink water = new Drink("Water", 1.00, 10, 300, DrinkFlavor.No_Sugar);
        Drink energyDrink = new Drink("Energy Drink", 1.49, 10, 350, DrinkFlavor.Sugar);
        stock.put(100, coke);
        stock.put(101, juice);
        stock.put(102, water);
        stock.put(103, energyDrink);
        
        Snack chips = new Snack("Lays", 3.00, 10, 200, SnackFlavor.Salty);
        Snack candy = new Snack("Skittles", 2.75, 10, 250, SnackFlavor.Sweet);
        Snack chocolate = new Snack("Kitkat", 2.75, 10, 100, SnackFlavor.Sweet);
        Snack gum = new Snack("Bubble Gum", 2.00, 10, 200, SnackFlavor.Sweet);
        stock.put(200, chips);
        stock.put(201, candy);
        stock.put(202, chocolate);
        stock.put(203, gum);
        
        for (int emptyRow = 3; emptyRow <= 8; emptyRow++) {
            for (int emptyCol = 0; emptyCol < 4; emptyCol++) {
                int emptyCode = emptyRow * 100 + emptyCol;
                Snack empty = new Snack("Empty", 0, 0, 0, SnackFlavor.None);
                stock.put(emptyCode, empty);
            }
        }
    }

    /**
     *Method to prompt the menu in Main class.
     */
    public void displayMenu()
    {
        System.out.println("Make a selection");
        System.out.println();
        
        for (int row = 1; row <= 8; row++) {
            for (int col = 0; col < 4; col++) {
                int showProductCode = row * 100 + col;
                
                if (showProductCode < 104 || showProductCode >= 200 || showProductCode < 204) {
                    
                        System.out.print(showProductCode + "(" + stock.get(showProductCode).getProductName() + ") ");
                        showProductCode++;
                    
                }
                else {
                    System.out.print(showProductCode + "(" + stock.get(showProductCode).getProductName() + ") ");
                } 
            }
            System.out.println();
        }
        System.out.print("Enter code: ");
    }
    
    /**
     * Method to select an item in the stock of the vending machine.
     * @param numberCode Number code of a snack or drink
     */
    public void selectItem(int numberCode) 
    {
        currentSelection = numberCode;
        System.out.println(currentSelection);
    }
    
    /**
     * Method that confirms a selection.
     */
    public void confirmSelection() 
    {
        if (stock.containsKey(currentSelection)) {
            System.out.println("Are you sure you want to select" +" "+ currentSelection + " (" + stock.get(currentSelection).getProductName() + ")");
            System.out.println("(y/n)");
        }
        else {
            System.out.println("This code is not available");
        }
    }
    
    /**
     * Method dispenses item to customer.
     */
    public void dispenseItem() 
    {
        System.out.println( currentSelection + " " + "has been dispensed");
    }
    
    /**
     * Method to view the current remaining stock.
     */
    public void showStock()
    {
        System.out.println("working");
    }
    
    /**
     * Method to show sales history of the vending machine.
     */
    public void showAccounting()
    {
        System.out.println("working");
    }
}    
