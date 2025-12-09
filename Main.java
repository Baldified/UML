import java.util.Scanner;

/**
 * Main class serves as a Driver class for the vending machine.
 * Has fields such as running.
 * @author Dylan Scalia
 */
public class Main 
{
    /**
     * Constructor to create a new Main object.
     * Starts the vending machine.
     */
    public static void main(String[] args){

        Scanner a = new Scanner(System.in);
        VendingMachine vm = new VendingMachine();

        System.out.println("Welcome to the vending machine");

        int choice = 0;

        openMenu(vm, a, choice);
    }

    /**
     * Method to open the menu of the vending machine.
     * @param vm The variable name of the vending machine.
     * @param a The variable name of the scanner.
     * @param choice The inputted choice of the user.
     */
    private static void openMenu( VendingMachine vm, Scanner a, int choice){
        vm.clearBalance();
        do {
            System.out.println("\n----------------------");
            System.out.println("Please select one of the following options");
            System.out.println("1. Display vending machine options");
            System.out.println("2. Exit");
            System.out.println();
            System.out.println("FOR OWNER OF MACHINE");
            System.out.println("3. Show stock remaining of machine");
            System.out.println("4. Show total earnings of the machine");
            choice = a.nextInt();

            if (choice > 5 || choice < 0) {
                System.out.println("\n----------------------");
                System.out.println("Invalid choice, please try again");
            }
        }
        while(choice>5 || choice<0);
        switch(choice){
            case 1:
                openChoiceSelection(vm, a, choice);
                break;

            case 2: 
                System.out.println("Thank you for visiting the machine");
                a.close();
                System.exit(0);
                break;

            case 3:
                stockSystem(vm, a,choice);
                break;

            case 4:
                System.out.println("\n----------------------");
                System.out.print("$" + vm.showAccountingHistory());
                System.out.println();
                openMenu(vm, a, choice);
                break;

            default: 
                System.out.println("\n----------------------");
                System.out.println("An invalid input has been entered");
                openMenu(vm, a, choice);
                break;

        }
    }
    
    /**
     * Method to open choice selection of the vending machine.
     * @param vm The variable name of the vending machine.
     * @param a The variable name of the scanner.
     * @param choice The inputted choice of the user.
     */
    private static void openChoiceSelection(VendingMachine vm, Scanner a, int choice) {
        System.out.println("\n----------------------");
        vm.displayMenu();
        int itemCode = a.nextInt();
        if (!vm.selectItem(itemCode)) {
            System.out.println("\n----------------------");
            System.out.print("Invalid code");
            System.out.println("Returning back to Menu");
            System.out.println();
            openMenu(vm, a, choice);
        }
        else if (vm.stock.get(itemCode).getProductStock() == 0) {
            System.out.println("\n----------------------");
            System.out.println("This slot is empty.");
            System.out.println("Returning back to Menu");
            openMenu(vm, a, choice);
        }
        else {
            System.out.println("\n----------------------");
            vm.confirmSelection();
            String chooseMenu = a.next().trim().toLowerCase();
            if(chooseMenu.equals("n"))
            {
                openMenu(vm, a, choice);
            }else if(chooseMenu.equals("y")){
                moneyInsertionSystem(vm, a, choice);
            }else {
                System.out.println("\n----------------------");
                System.out.println("Invalid input.");
                System.out.println("Returning back to Menu");
                openChoiceSelection(vm, a, choice);
            }
        }
    }

    /**
     * Method to open the stock system of the vending machine.
     * @param vm The variable name of the vending machine.
     * @param a The variable name of the scanner.
     * @param choice The inputted choice of the user.
     */
    private static void stockSystem(VendingMachine vm, Scanner a,int choice) {
        System.out.println("\n----------------------");
        vm.showStock();

        System.out.println();
        System.out.println("Would you like to refill the stock, remove from stock or return?");
        System.out.println("(refill/remove/return)");

        a.nextLine();
        String chooseStock = a.next().trim().toLowerCase();

        switch (chooseStock) {
            case "refill":
                System.out.println("\n----------------------");
                System.out.println("Please select a stock to refill."); 
                int addItemCode = a.nextInt();

                if (vm.selectItem(addItemCode)) {
                    vm.addToSelectedStock();
                    stockSystem(vm, a, choice);
                } 
                else {
                    System.out.println("\n----------------------");
                    System.out.println("Invalid item code.");
                    stockSystem(vm, a, choice);
                }
                break;

            case "remove":
                System.out.println("\n----------------------");
                System.out.println("Please select a stock to remove from");
                int removeItemCode = a.nextInt();

                if (vm.selectItem(removeItemCode)) {
                    vm.removeFromSelectedStock();
                    stockSystem(vm, a, choice);
                }
                else {
                    System.out.println("\n----------------------");
                    System.out.println("Invalid item code.");
                    stockSystem(vm, a, choice);
                }
                break;

            case "return":
                openMenu(vm, a, choice);
                break;
            
            default:
                System.out.println("\n----------------------");
                System.out.println("Please choose from the given options.");
                stockSystem(vm, a, choice);
                break;
        }
    }

    /**
     * Method to utilize the accounting system of the vending machine.
     * @param vm The variable name of the vending machine.
     * @param a The variable name of the scanner.
     * @param choice The inputted choice of the user.
     */
    private static void moneyInsertionSystem(VendingMachine vm, Scanner a, int choice) {
        System.out.println("----------------------");
        System.out.println("Please insert $" + vm.stock.get(vm.currentSelection).getProductPrice());

        a.nextLine();
        double insertedMoney = a.nextDouble();

        if (insertedMoney >= vm.stock.get(vm.currentSelection).getProductPrice()) {
            payingSystem(vm, a, choice, insertedMoney);
        } 
        else if (insertedMoney == 0){
            System.out.println("\n----------------------");
            System.out.println("No money was inserted");
            System.out.println("Returning back to Menu");
            openMenu(vm, a, choice);
        } 
        else {
            System.out.println("\n----------------------");
            System.out.println("Not enough money inserted");
            System.out.println("Returning back to Menu");
            openMenu(vm, a, choice);
        }

    }

    /**
     * Method to utilize the paying system of the vending machine.
     * @param vm The variable name of the vending machine.
     * @param a The variable name of the scanner.
     * @param choice The inputted choice of the user.
     * @param insertedMoney The amount of money inserted in the vending machine.
     */
    private static void payingSystem(VendingMachine vm, Scanner a, int choice, double insertedMoney) {
        if (insertedMoney >= vm.stock.get(vm.currentSelection).getProductPrice()) {
            vm.insertMoney(insertedMoney);
            if (vm.balance >= vm.stock.get(vm.currentSelection).getProductPrice()) {
                System.out.println("\n----------------------");
                vm.payPrice();
                vm.addToHistory();
                vm.dispenseItem();

                if(vm.balance > 0) {
                    System.out.printf("Your change is $%.2f", (vm.returnBalance()));
                    System.out.println();
                    openMenu(vm, a, choice);
                }
            }
        } 
    }
}

