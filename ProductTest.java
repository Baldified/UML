

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ProductTest has test methods for Product class methods.
 * Has Fields such as product, productWithStock.
 *
 * @author  Dylan Scalia
 */
public class ProductTest
{
    private Product product;
    private Product productWithStock;
    /**
     * Default constructor for test class ProductTest
     */
    public ProductTest()
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
       product = new Product("Dylan", 1.50, 10);
       productWithStock = new Product("test", 1.50, 10);  
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
    public void testGetProductName()
    {
        String name = "Dylan";
        Product p = new Product("Dylan", 1.50, 1);
        assertEquals(name, p.getProductName());
        
        String falseName = "not dylan";
        assertNotEquals(falseName, p.getProductName());
    }

    @Test
    public void testGetProductPrice()
    {
        Product product1 = new Product("Dylan", 10.00, 10);
        assertEquals(10.00, product1.getProductPrice(), 0.1);
        assertNotEquals(100, product1.getProductPrice(), 0.1);
    }

   

    @Test
    public void testGetProductStock()
    {
        assertEquals(10, product.getProductStock());
        assertNotEquals(1, product.getProductStock());
    }
    
    @Test
    public void testGetProductDisplay() {
        String info = ("Product: Dylan, Price: $1.5\nStock: 10");
        assertEquals(info, product.displayProductInfo());
        
        String falseInfo = ("Product: Bylan, Price: $1111.5\nStock: 1110");
        assertNotEquals(falseInfo, product.displayProductInfo()) ;
    }
}





