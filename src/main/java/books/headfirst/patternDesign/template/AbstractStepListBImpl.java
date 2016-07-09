package books.headfirst.patternDesign.template;

/**
 * Created by csophys on 16/7/9.
 */
public class AbstractStepListBImpl extends AbstractStepList {
    @Override
    protected void second() {
        System.out.println("second in B");
    }

    @Override
    protected void first() {
        System.out.println("first in B");
    }
}
