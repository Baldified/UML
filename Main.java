import java.util.Scanner;

/**
 * 
 */
public class Main
{
    

    /**
     * 
     */
    public Main()
    {
        
    }

    
    public static void main(String[] args){
        Scanner a = new Scanner(System.in);
        VendingMachine vm = new VendingMachine();
        
        System.out.println("Welcome to the vending machine");

        System.out.println("please make a selection");
        
        for (int row = 1; row <= 5; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print((row * 100 + col) + " ");
            }
            System.out.println();
        }
        

        System.out.println("Please select one of the following options");
        System.out.println("1. Display vending machine opptions");
        System.out.println("4. Exit");
        System.out.println();
        System.out.println("FOR OWNER OF MACHINE");
        System.out.println("2. Show stock remaining of machine");
        System.out.println("3. Show total earnings of the machine");

        System.out.println("Please select one of the following options");
        System.out.println("1. Display vending machine opptions");
        System.out.println("4. Exit");
        System.out.println();
        System.out.println("FOR OWNER OF MACHINE");
        System.out.println("2. Show stock remaining of machine");
        System.out.println("3. Show total earnings of the machine");

        System.out.println("Please select one of the following options");
        System.out.println("1. Display vending machine opptions");
        System.out.println("4. Exit");
        System.out.println();
        System.out.println("FOR OWNER OF MACHINE");
        System.out.println("2. Show stock remaining of machine");
        System.out.println("3. Show total earnings of the machine");
        int choice = a.nextInt();
        switch(choice){
            case 1:
                vm.displayMenu();
                System.out.print("Enter item code: ");
                int itemCode = a.nextInt();
                vm.selectItem(itemCode);
                break;
        
            case 2:
                vm.showStock();
                break;
                
            
            case 3:
                vm.showAccounting();
                break;
                
            case 4: 
                System.out.println("Thank you for visiting the machine");
                break;
                
            default: 
                break;
            
        }
    }
}
