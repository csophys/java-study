package books.headfirst.patternDesign.strategy;

/**
 * Created by csophys on 16/6/26.
 */
public class DefaultFlyBehavior implements FlyBehavior {
    public boolean fly() {
        System.out.println("default fly");
        return true;
    }
}
