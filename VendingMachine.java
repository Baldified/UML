import java.util.HashMap;

/**
 * This class represents a vending machine.
 * @author Dylan Scalia
 */
public class VendingMachine 
{
    int currentSelection;
    HashMap<Integer, Product> stock;
    int confirmation;
    double money;
    double balance;
    double balanceHistory;
    /**
     * Constructor to initiate the vending machine class.
     * 
     */
    public VendingMachine()
    {
        stock = new HashMap<>();
        
        Drink coke = new Drink("Coke", 1.99, 10, 250, DrinkFlavor.Sugar_Drink);
        Drink juice = new Drink("Juice", 1.49, 10, 350, DrinkFlavor.Sugar_Drink);
        Drink water = new Drink("Water", 1.00, 10, 300, DrinkFlavor.No_Sugar_Drink);
        Drink energyDrink = new Drink("Energy Drink", 1.49, 10, 350, DrinkFlavor.Sugar_Drink);
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
                Snack empty = new Snack("Empty", 0, 0, 0, SnackFlavor.Empty);
                stock.put(emptyCode, empty);
            }
        }
    }

    /**
     *Method to prompt the menu in Main class.
     */
    public void displayMenu()
    {
        System.out.println();
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
        if (stock.containsKey(currentSelection)) {
            System.out.println();
            System.out.println("Are you sure you want to select" +" "+ currentSelection + " (" + stock.get(currentSelection).getProductName() + ")");
            if (stock.containsKey(currentSelection >= 300)){
                System.out.println("This slot is empty.");
            }
            else {
                System.out.println(stock.get(currentSelection).displayProductInfo());
                System.out.println("(y/n)");
            }
        }
    }
    
    /**
     * Method dispenses item to customer.
     */
    public void dispenseItem() 
    {
        stock.get(currentSelection).removeFromStock();
        System.out.println( currentSelection + " " + "has been dispensed");
    }
    
    /**
     * Method to view the current remaining stock.
     */
    public void showStock()
    {   
        System.out.println();
        System.out.println("Currently in Stock:");
        for (int allStock : stock.keySet()) {
            if (!(allStock > 300) && stock.get(allStock).getProductStock() > 0) {
                System.out.println("(" + allStock + ")" + stock.get(allStock).getProductName() + ": " + stock.get(allStock).getProductStock());
            }
        }
    }
    
    public void addSelectedStock() {
        stock.get(currentSelection).addToStock();
    }
    
    public void removeSelectStock() {
        stock.get(currentSelection).removeFromStock();
    }
    
    public void insertMoney(double money) {
         this.money = money;
         balance += money;
    }
    
    public double returnBalance() {
        return balance;
    }
    
    public void payPrice() {
        balance -= stock.get(currentSelection).getProductPrice();
    }
    
    public void clearBalance() {
        balance = 0;
    }
    
    /**
     * Method to show sales history of the vending machine.
     */
    public void showAccounting()
    {
        System.out.println(balanceHistory);
    }
    
    public void addToHistory() {
        balanceHistory += stock.get(currentSelection).getProductPrice();
    }
}    