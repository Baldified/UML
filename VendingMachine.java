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
                System.out.print((row * 100 + col) + " ");
            }
            System.out.println();
        }
        System.out.print("Enter code: ");
    }
    
    /**
     * Method to select an item in the stock of the vending machine.
     * @param numberCode Number code of a snack or drink
     */
    public boolean selectItem(int numberCode) 
    {
        
        
        if (numberCode < 100 || numberCode > 803 || numberCode % 100 > 3) {
          return false;
         }
        this.currentSelection = numberCode;
        return true;
    }
    
    /**
     * Method that confirms a selection.
     */
    public void confirmSelection() 
    {
        System.out.println("Are you sure you want to select" +" "+ currentSelection);
        System.out.println("(y/n)");
        
            
        
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
