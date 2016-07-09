package books.headfirst.patternDesign.template;

import org.junit.Test;

/**
 * Created by csophys on 16/7/9.
 */
public class AbstractStepListTest {

    @Test
    public void step(){
        AbstractStepList abstractStepAList = new AbstractStepListAImpl();
        AbstractStepList abstractStepBList = new AbstractStepListBImpl();

        abstractStepAList.step();
        abstractStepBList.step();
    }

}