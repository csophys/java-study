package books.headfirst.patternDesign.factory.abstractFactory;

import books.headfirst.patternDesign.factory.NYPizza;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by csophys on 16/7/2.
 */
public class ChicagoPizzaProductFactoryTest {

    @Test
    public void testCreatePizza() throws Exception {
        Assert.assertTrue(new NYPizzaProductFactory().createPizza() instanceof NYPizza);
    }

    @Test
    public void testCreatePizzaPackage() throws Exception {
        Assert.assertTrue(new ChicagoPizzaProductFactory().createPizzaPackage() instanceof DefaultPizzaPackage);
    }
}