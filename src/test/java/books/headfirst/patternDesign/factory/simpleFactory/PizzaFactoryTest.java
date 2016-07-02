package books.headfirst.patternDesign.factory.simpleFactory;

import books.headfirst.patternDesign.factory.NYPizza;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by csophys on 16/7/2.
 */
public class PizzaFactoryTest {

    @Test
    public void testCreatePizza() throws Exception {
        Assert.assertTrue(new PizzaFactory().createPizza("NY") instanceof NYPizza);
    }
}