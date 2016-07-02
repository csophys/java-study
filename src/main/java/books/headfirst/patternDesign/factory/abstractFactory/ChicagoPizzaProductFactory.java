package books.headfirst.patternDesign.factory.abstractFactory;

import books.headfirst.patternDesign.factory.ChicagoPizza;
import books.headfirst.patternDesign.factory.Pizza;

/**
 * Created by csophys on 16/7/2.
 */
public class ChicagoPizzaProductFactory extends PizzaProductFactory {
    @Override
    public Pizza createPizza() {
        return new ChicagoPizza();
    }

    @Override
    public PizzaPackage createPizzaPackage() {
        return new DefaultPizzaPackage();
    }
}
