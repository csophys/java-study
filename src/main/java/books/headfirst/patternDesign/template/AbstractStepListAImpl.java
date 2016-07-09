package books.headfirst.patternDesign.template;

/**
 * Created by csophys on 16/7/9.
 */
public class AbstractStepListAImpl extends AbstractStepList {
    @Override
    protected void second() {
        System.out.println("second in A");
    }

    @Override
    protected void first() {
        System.out.println("first in A");
    }

    protected void hook(){
        System.out.println("hook in A");
    }
}
