

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ProductTest.
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

     public void testName() {
        Product p = new Product("Dylan", 1.50, 1);
        assertEquals("Dylan", p.getProductName());
    }

    
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
       product = new Product("Dylan", 1.50, 1);
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
    public void displayProductInfo()
    {
        String expected = "Product: Dylan, Price: $1.50, Stock: 1"; // match your implementation
        assertEquals(expected, product.displayProductInfo());
        
        
        String displayTest = "Product: " + product.name + ", Price: $" + product.price;
        displayTest += "Stock: " + product.quantity; 
        Product product1 = new Product("Dylan", 1.50, 1);
        assertEquals(product, product1.displayProductInfo());
        product1.payForProduct();
        product1.removeFromStock();
        product1.addToStock();
    }

    @Test
    public void getProductName()
    {
        Product product1 = new Product("test", 1.50, 10);
        assertEquals("Dylan", product.getProductName());
        assertEquals("test", product1.getProductName());
        String expectedBefore = "Product: test, Price: $1.50, Stock: 10";
        assertEquals(expectedBefore, product1.displayProductInfo());
        product1.addToStock();      
        product1.removeFromStock(); 
        product1.addToStock();     
        String expectedAfter = "Product: test, Price: $1.50, Stock: 11";
        assertEquals(expectedAfter, product1.displayProductInfo());
    }
}


