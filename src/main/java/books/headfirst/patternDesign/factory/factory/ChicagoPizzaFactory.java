package books.headfirst.patternDesign.factory.factory;

import books.headfirst.patternDesign.factory.ChicagoPizza;
import books.headfirst.patternDesign.factory.Pizza;

/**
 * Created by csophys on 16/7/2.
 */
public class ChicagoPizzaFactory extends PizzaFactory {
    @Override
    public Pizza createPizza() {
        return new ChicagoPizza();
    }
}
