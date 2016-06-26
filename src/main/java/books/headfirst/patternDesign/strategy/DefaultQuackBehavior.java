package books.headfirst.patternDesign.strategy;

/**
 * Created by csophys on 16/6/26.
 */
public class DefaultQuackBehavior implements QuackBehavior {
    public boolean quack() {
        System.out.println("default quack");
        return true;
    }
}
