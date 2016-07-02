package books.headfirst.patternDesign.decorater;

/**
 * Created by csophys on 16/6/29.
 */
public class DarkRoast implements Beverage {
    public void getDescription() {
        System.out.println(this.getClass().getCanonicalName());
    }

    public void cost() {
        System.out.println(this.getClass().getCanonicalName()+":0.02");
    }
}
