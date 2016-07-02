package books.headfirst.patternDesign.decorater;

/**
 * Created by csophys on 16/6/29.
 */
public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public void cost() {
        beverage.cost();
        System.out.println("Mocha");
    }
}
