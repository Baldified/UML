

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
    VendingMachine vendingM1;
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
        vendingM1 = new VendingMachine();
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
        assertEquals(true, vendingM1.selectItem(100));
        assertEquals(true, vendingM1.selectItem(101));
        assertEquals(true, vendingM1.selectItem(102));
        assertEquals(true, vendingM1.selectItem(103));
        assertEquals(false, vendingM1.selectItem(104));
        assertEquals(false, vendingM1.selectItem(99));
    }
    
    @Test
    public void returnBalance()
    {
        assertEquals(0, vendingM1.returnBalance(), 0.1);
        assertNotEquals(1, vendingM1.returnBalance(), 0.1);
        assertNotEquals(-1, vendingM1.returnBalance(), 0.1);
        assertNotEquals(100, vendingM1.returnBalance(), 0.1);
    }

    @Test
    public void insertMoney()
    {
        vendingM1.insertMoney(15.15);
        assertEquals(15.15, vendingM1.money, 0.1);
        assertEquals(15.15, vendingM1.balance, 0.1);
        
        vendingM1.insertMoney(3);
        assertEquals(3, vendingM1.money, 0.1);
        assertEquals(18.15, vendingM1.balance, 0.1);
        
        vendingM1.insertMoney(4);
        assertEquals(4, vendingM1.money, 0.1);
        assertNotEquals(20.15, vendingM1.balance, 0.1);
        
        vendingM1.insertMoney(5);
        assertNotEquals(3, vendingM1.money, 0.1);
        assertEquals(27.15, vendingM1.balance, 0.1);
    }
}