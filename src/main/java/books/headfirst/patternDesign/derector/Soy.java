package books.headfirst.patternDesign.derector;

/**
 * Created by csophys on 16/6/29.
 */
public class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public void cost() {
        beverage.cost();
        System.out.println("Soy");
    }
}
