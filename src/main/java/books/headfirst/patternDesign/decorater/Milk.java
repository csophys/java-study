package books.headfirst.patternDesign.decorater;

/**
 * Created by csophys on 16/6/29.
 */
public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public void cost() {
        beverage.cost();
        System.out.println("Milk");
    }
}
