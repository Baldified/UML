import java.util.HashMap;

/**
 * This class represents a vending machine.
 * Has fields such as currentSelection, stock, confirmation, money, balance, and balanceHistory.
 * @author Dylan Scalia & Bruce Lam
 */
public class VendingMachine 
{
    int currentSelection;
    HashMap<Integer, Product> stock;
    int confirmation;
    double money;
    double balance;
    double salesHistory;

    // Layer 1
    Drink coke = new Drink("Coke", 1.99, 2, 250, DrinkType.Sugar_Drink);
    Drink juice = new Drink("Juice", 1.49, 10, 350, DrinkType.Sugar_Drink);
    Drink water = new Drink("Water", 1.00, 10, 300, DrinkType.No_Sugar_Drink);
    Drink monster = new Drink("Monster", 1.49, 10, 350, DrinkType.Sugar_Drink);

    // Layer 2
    Drink sprite = new Drink("Sprite", 1.99, 10, 250, DrinkType.Sugar_Drink);
    Drink fanta = new Drink("Fanta", 1.49, 10, 350, DrinkType.Sugar_Drink);
    Drink dietCoke = new Drink("Diet Coke", 1.00, 10, 300, DrinkType.No_Sugar_Drink);
    Drink coffee = new Drink("Coffee", 1.49, 10, 350, DrinkType.No_Sugar_Drink);

    // Layer 3
    Snack chips = new Snack("Lays", 3.00, 10, 200, SnackFlavor.Salty);
    Snack candy = new Snack("Skittles", 2.75, 10, 250, SnackFlavor.Sweet);
    Snack chocolate = new Snack("Kitkat", 2.75, 10, 100, SnackFlavor.Sweet);
    Snack gum = new Snack("Bubble Gum", 2.00, 10, 200, SnackFlavor.Sweet);

    // Layer 4
    Snack pringles = new Snack("Pringles", 3.00, 10, 200, SnackFlavor.Salty);
    Snack cake = new Snack("Cake", 2.75, 10, 250, SnackFlavor.Sweet);
    Snack tootsie = new Snack("Tootsie Roll", 2.75, 10, 100, SnackFlavor.Sweet);
    Snack gummy = new Snack("Gummy Worms", 2.00, 10, 200, SnackFlavor.Sweet);

    Snack empty = new Snack("Empty", 0, 0, 0, SnackFlavor.None);
    /**
     * Constructor to create a new VendingMachine object.
     * Presets the items inside the vending machine.
     */
    public VendingMachine()
    {
        stock = new HashMap<>();

        // Layer 1
        stock.put(100, coke);
        stock.put(101, juice);
        stock.put(102, water);
        stock.put(103, monster);

        // Layer 2
        stock.put(200, sprite);
        stock.put(201, fanta);
        stock.put(202, dietCoke);
        stock.put(203, coffee);

        // Layer 3
        stock.put(300, chips);
        stock.put(301, candy);
        stock.put(302, chocolate);
        stock.put(303, gum);

        // Layer 4
        stock.put(400, pringles);
        stock.put(401, cake);
        stock.put(402, tootsie);
        stock.put(403, gummy);

        for (int emptyRow = 5; emptyRow <= 6; emptyRow++) {
            for (int emptyCol = 0; emptyCol < 4; emptyCol++) {
                int emptyCode = emptyRow * 100 + emptyCol;
                stock.put(emptyCode, empty);
            }
        }
    }

    /**
     *Method to prompt the menu.
     */
    public void displayMenu()
    {
        System.out.println("Make a selection");
        System.out.println();

        for (int row = 1; row <= 6; row++) {
            for (int col = 0; col < 4; col++) {
                int showProductCode = row * 100 + col;

                if (stock.get(showProductCode).getProductStock() == 0 && stock.get(showProductCode).getProductName() != "Empty") {
                    System.out.print(showProductCode + "(" + stock.get(showProductCode).getProductName() + "(empty)) ");
                    showProductCode++;
                } else {
                    System.out.print(showProductCode + "(" + stock.get(showProductCode).getProductName() + ") ");
                    showProductCode++;
                }
            }
            System.out.println();
        }
        System.out.print("Enter code: ");
    }

    /**
     * Method to select an item from the vending machine.
     * @param numberCode Number code of a product.
     */
    public boolean selectItem(int numberCode) 
    {
        if (!stock.containsKey(numberCode)) {
            return false;
        }
        this.currentSelection = numberCode;
        return true;
    }

    /**
     * Method to confirm a selection.
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
     * Method to dispense an item to the user.
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
        System.out.println("Currently in Stock:");
        for (int allStock : stock.keySet()) {
            if (stock.get(allStock).getProductName() != "Empty") {
                System.out.println("(" + allStock + ")" + stock.get(allStock).getProductName() + ": " + stock.get(allStock).getProductStock());
            }
        }
    }
    
    /**
     * Method to add to a selected stock.
     */
    public void addToSelectedStock() {
        stock.get(currentSelection).addToStock();
    }
    
    /**
     * Method to remove from a selected stock.
     */
    public void removeFromSelectedStock() {
        stock.get(currentSelection).removeFromStock();
    }
    
    /**
     * Method to insert money into vending machine.
     * @param money The amount of money inserted in the vending machine.
     */
    public void insertMoney(double money) {
        this.money = money;
        balance += money;
    }
    
    /**
     * Method to return the vending machine balance.
     */
    public double returnBalance() {
        return balance;
    }

    /**
     * Method to pay for a product.
     */
    public void payPrice() {
        balance -= stock.get(currentSelection).getProductPrice();
    }
    
    /**
     * Method to clear the vending machine balance.
     */
    public void clearBalance() {
        balance = 0;
    }
    
    /**
     * Method to show sales history of the vending machine.
     */
    public double showAccountingHistory()
    {
        return salesHistory;
    }
    
    /**
     * Method to add a sales to the sales history.
     */
    public void addToHistory() {
        salesHistory += stock.get(currentSelection).getProductPrice();
    }
}    