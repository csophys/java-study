package books.headfirst.patternDesign.derector;

import org.junit.Test;

/**
 * Created by csophys on 16/6/29.
 */
public class CondimentDecoratorTest {


    @Test
    public void decoratorTest() {
        //牛奶烘烤
        Beverage beverage = new Milk(new DarkRoast());
        beverage.cost();

        //双份牛奶烘烤
        beverage = new Milk(beverage);
        beverage.cost();

        //酱油双份牛奶烘烤
        beverage = new Soy(beverage);
        beverage.cost();

        //摩卡酱油双份牛奶烘烤
        beverage = new Mocha(beverage);
        beverage.cost();
    }

}