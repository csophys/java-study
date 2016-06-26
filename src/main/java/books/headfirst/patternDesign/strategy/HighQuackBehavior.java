package books.headfirst.patternDesign.strategy;

/**
 * Created by csophys on 16/6/26.
 */
public class HighQuackBehavior implements QuackBehavior {
    public boolean quack() {
        System.out.println("high quack");
        return true;
    }
}
