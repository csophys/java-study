package books.headfirst.patternDesign.factory.abstractFactory;

import books.headfirst.patternDesign.factory.Pizza;

/**
 * Created by csophys on 16/7/2.
 */
public abstract class PizzaProductFactory {

    public abstract Pizza createPizza();

    public abstract PizzaPackage createPizzaPackage();
}
