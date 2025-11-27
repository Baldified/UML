
/**
 * This class represents a vending machine.
 * @author Dylan Scalia & Bruce Lam
 */
public class VendingMachine
{
    int currentSelection;
    Stock stock;
    Accounting accounting;
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
        
        
    }
    
    /**
     * Method to select an item in the stock of the vending machine.
     * @param numberCode Number code of a snack or drink
     */
    public void selectItem(int numberCode) 
    {
        currentSelection = numberCode;
    }
    
    /**
     * Method that confirms a selection.
     */
    public void confirmSelection() 
    {
        switch (currentSelection) {
            //case 101;
            //case
            
            
            
            default: System.out.println("Selection not found.");
            break;
            }
        
    }
    
    /**
     * Method dispenses item to customer.
     */
    public void dispenseItem(int numberCode) 
    {
        
    }
    
    /**
     * Method to view the current remaining stock.
     */
    public void showStock()
    {
        
    }
    
    /**
     * Method to show sales history of the vending machine.
     */
    public void showAccounting()
    {
        
    }
}
