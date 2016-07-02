package books.headfirst.patternDesign.factory.abstractFactory;

import books.headfirst.patternDesign.factory.NYPizza;
import books.headfirst.patternDesign.factory.Pizza;

/**
 * Created by csophys on 16/7/2.
 */
public class NYPizzaProductFactory extends PizzaProductFactory {
    @Override
    public Pizza createPizza() {
        return new NYPizza();
    }

    @Override
    public PizzaPackage createPizzaPackage() {
        return new DefaultPizzaPackage();
    }
}
