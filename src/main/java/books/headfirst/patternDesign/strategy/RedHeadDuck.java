package books.headfirst.patternDesign.strategy;

/**
 * Created by csophys on 16/6/26.
 */
public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        flyBehavior = new DefaultFlyBehavior();
        quackBehavior = new HighQuackBehavior();
    }
}
