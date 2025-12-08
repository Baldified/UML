import java.util.Scanner;

/**
 * @author Dylan Scalia
 * The main driver in the class
 */
public class Main 
{
    static boolean running = true;
    /**
     * 
     * 
     * Prints menu with scanner
     */
    public static void main(String[] args){

        Scanner a = new Scanner(System.in);
        VendingMachine vm = new VendingMachine();

        System.out.println("Welcome to the vending machine");

        int choice;

        do {
            System.out.println();
            System.out.println("Please select one of the following options");
            System.out.println("1. Display vending machine options");
            System.out.println("2. Exit");
            System.out.println();
            System.out.println("FOR OWNER OF MACHINE");
            System.out.println("3. Show stock remaining of machine");
            System.out.println("4. Show total earnings of the machine");
            choice = a.nextInt();

            if (choice > 5 || choice < 0) {
                System.out.println("Invalid choice, please try again");
            }
        }
        while(choice>5 || choice<0);
        while (running) {
            switch(choice){
                case 1:
                    openVendingMachine(vm, a, choice);
                    break;

                case 2: 
                    System.out.println("Thank you for visiting the machine");
                    running = false;
                    break;

                case 3:
                    stockSystem(vm, a,choice);
                    break;

                case 4:
                    System.out.println("\n----------------------");
                    System.out.print("$" + vm.showAccounting());
                    System.out.println();
                    returnToMenu(choice, vm, a, running);
                    break;

                default: System.out.println("An invalid input has been entered");
                    break;

            }
        }
    }

    private static void stockSystem(VendingMachine vm, Scanner a,int choice) {
        vm.showStock();

        System.out.println();
        System.out.println("Would you like to refill the stock, remove from stock or return?");
        System.out.println("(refill/remove/return)");

        a.nextLine();
        String chooseStock = a.next().trim().toLowerCase();

        switch (chooseStock) {
            case "refill":
                System.out.println("Please select a stock to refill."); 
                int addItemCode = a.nextInt();

                if (vm.selectItem(addItemCode)) {
                    vm.addSelectedStock();
                } 
                else {
                    System.out.println("Invalid item code.");
                }
                break;

            case "remove":
                System.out.println("Please select a stock to remove from");
                int removeItemCode = a.nextInt();

                if (vm.selectItem(removeItemCode)) {
                    vm.removeSelectStock();
                }
                else {
                    System.out.println("Invalid item code.");
                }
                break;

            case "return":
                returnToMenu(choice, vm, a, running);
                break;

        }
    }

    private static void openVendingMachine(VendingMachine vm, Scanner a, int choice) {
        System.out.println("\n----------------------");
        vm.displayMenu();
        int itemCode = a.nextInt();
        if (!vm.selectItem(itemCode)) {
            System.out.print("Invalid code \n");
            System.out.println("\n----------------------");
            returnToMenu(choice, vm, a, running);
        }
        else if (vm.stock.get(itemCode).getProductStock() == 0) {
            System.out.println("This slot is empty.");
            returnToMenu(choice, vm, a, running);
        }
        else {
            System.out.println("\n----------------------");
            vm.confirmSelection();
            String chooseMenu = a.next().trim().toLowerCase();
            if(chooseMenu.equals("n"))
            {
                returnToMenu(choice, vm, a, running);
            }else if(chooseMenu.equals("y")){
                accountingSystem(vm, a, choice);
            }else {
                System.out.println("Invalid input. Enter 'y' or 'n'.");
            }
        }
    }

    private static void accountingSystem(VendingMachine vm, Scanner a, int choice) {
        System.out.println("----------------------");
        System.out.println("Please insert $" + vm.stock.get(vm.currentSelection).getProductPrice());

        a.nextLine();
        double insertedMoney = a.nextDouble();

        if (insertedMoney >= vm.stock.get(vm.currentSelection).getProductPrice()) {
            payingSystem(vm, a, insertedMoney, choice);
        } 
        else if (insertedMoney == 0 ){
            System.out.println("No money was inserted");
            a.nextLine();
            payingSystem(vm, a, insertedMoney, choice);
        } 
        else {
            System.out.println("Not enough money inserted");
            System.out.println("----------------------");
            System.out.println("Please insert $" + vm.stock.get(vm.currentSelection).getProductPrice());
            a.nextLine();
            payingSystem(vm, a, insertedMoney, choice);
        }

    }
    
    private static void payingSystem(VendingMachine vm, Scanner a, double insertedMoney, int choice) {
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
                    returnToMenu(choice, vm, a, running);
                }
            }
        } 
    }

    private static void returnToMenu(int choice, VendingMachine vm, Scanner a, boolean running){
        vm.clearBalance();
        choice = 0;
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
                System.out.println("Invalid choice, please try again");
            }
        }
        while(choice>5 || choice<0);

        switch(choice){
            case 1:
                openVendingMachine(vm, a, choice);
                break;

            case 2: 
                System.out.println("Thank you for visiting the machine");
                running = false;
                break;

            case 3:
                stockSystem(vm, a,choice);
                break;

            case 4:
                System.out.println("\n----------------------");
                System.out.print("$" + vm.showAccounting());
                System.out.println();
                returnToMenu(choice, vm, a, running);
                break;

            default: System.out.println("An invalid input has been entered");
                break;

        }
    }
}

