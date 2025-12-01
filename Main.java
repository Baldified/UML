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
        
        System.out.println("Welcome to the vending machine");
        System.out.println("please make a selection");
        
        for (int row = 1; row <= 8; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.print((row * 100 + col) + " ");
            }
            System.out.println();
        }
        
        int choice = a.nextInt();
        System.out.println("You selected: " + choice);
    }
}
