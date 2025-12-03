import java.util.Scanner;

/**
 * @author Dylan Scalia
 * The main driver in the class
 */
public class Main 
{
    

    /**
     * 
     */
    public Main()
    {
        
    }

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
    
        do{
             System.out.println();
             System.out.println("Please select one of the following options");
             System.out.println("1. Display vending machine opptions");
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

                vm.displayMenu();
                int itemCode = a.nextInt();
                if (!vm.selectItem(itemCode)) {
                    System.out.print("Invalid code");
                    return;
                }
                vm.confirmSelection();
                a.nextLine();
                String choose = a.next().trim().toLowerCase();
                if(choose.equals("n"))
                {
                   System.out.println("Come back soon");
                }else if(choose.equals("y")){
                    vm.dispenseItem();
                }else {
                            System.out.println("Invalid input. Enter 'y' or 'n'.");
                        }
                while (!choose.equals("y") && !choose.equals("n"));
                break;
        
            case 3:
                vm.showStock();
                break;
                
            
            case 4:
                vm.showAccounting();
                break;
                
            case 2: 
                System.out.println("Thank you for visiting the machine");
                break;
                
            default: System.out.println("An invalid input has been entered");
                break;
            
        }
    }
}
