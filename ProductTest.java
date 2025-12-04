

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
    Product product = new Product("Dylan", 1.50, 1);
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
        String displayTest = "Product: " + product.name + ", Price: $" + product.price;
        displayTest += "Stock: " + product.quantity; 
        Product product1 = new Product("Dylan", 1.50, 1);
        assertEquals(product, product1.displayProductInfo());
        product1.payForProduct();
        product1.removeFromStock();
        product1.addToStock();
    }
}

