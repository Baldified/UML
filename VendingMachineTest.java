

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class VendingMachineTest.
 *
 * @author Bruce Lam
 */
public class VendingMachineTest
{   
    /**
     * Default constructor for test class VendingMachineTest
     */
    public VendingMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void SelectItem()
    {
        VendingMachine vendingM1 = new VendingMachine();
        assertEquals(100, vendingM1.selectItem(100));
        assertEquals(101, vendingM1.selectItem(101));
        assertEquals(102, vendingM1.selectItem(102));
        assertEquals(103, vendingM1.selectItem(103));
        assertEquals(104, vendingM1.selectItem(104));
        assertEquals(99, vendingM1.selectItem(99));
    }
    
    @Test
    public void returnBalance()
    {
        VendingMachine vendingM1 = new VendingMachine();
        assertEquals(0, vendingM1.returnBalance(), 0.1);
        assertEquals(1, vendingM1.returnBalance(), 0.1);
        assertEquals(-1, vendingM1.returnBalance(), 0.1);
        assertEquals(100, vendingM1.returnBalance(), 0.1);
    }

    @Test
    public void insertMoney()
    {
        VendingMachine vendingM1 = new VendingMachine();
        vendingM1.insertMoney(15.15);
        assertEquals(15.15, vendingM1.money, 0.1);
        assertEquals(15.15, vendingM1.balance, 0.1);
        
        vendingM1.insertMoney(3);
        assertEquals(3, vendingM1.money, 0.1);
        assertEquals(18.15, vendingM1.balance, 0.1);
        
        vendingM1.insertMoney(4);
        assertEquals(4, vendingM1.money, 0.1);
        assertEquals(20.15, vendingM1.balance, 0.1);
        
        vendingM1.insertMoney(5);
        assertEquals(3, vendingM1.money, 0.1);
        assertEquals(27.15, vendingM1.balance, 0.1);
    }
}







