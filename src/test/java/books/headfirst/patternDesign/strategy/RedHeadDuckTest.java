package books.headfirst.patternDesign.strategy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by csophys on 16/6/26.
 */
public class RedHeadDuckTest {

    Duck duck = new RedHeadDuck();

    @Test
    public void fly(){
        Assert.assertTrue(duck.performFly());
    }

    @Test
    public void quack(){
        Assert.assertTrue(duck.performQuack());
    }
}