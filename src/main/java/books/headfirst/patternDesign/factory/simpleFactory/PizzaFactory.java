package books.headfirst.patternDesign.factory.simpleFactory;

import books.headfirst.patternDesign.factory.ChicagoPizza;
import books.headfirst.patternDesign.factory.NYPizza;
import books.headfirst.patternDesign.factory.Pizza;

/**
 * Created by csophys on 16/7/2.
 */
public class PizzaFactory {

    public Pizza createPizza(String type) {
        switch (type) {
            case "Chicago":
                return new ChicagoPizza();
            case "NY":
                return new NYPizza();
        }

        throw new NullPointerException("没有正确创建pizza对象");
    }
}
