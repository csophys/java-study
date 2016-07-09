package books.headfirst.patternDesign.Adapter;

import org.junit.Test;

/**
 * Created by csophys on 16/7/9.
 */
public class AdapterClientTest {

    @Test
    public void AdapterClientTest(){
        //实例化被适配类
        Adaptee adaptee = new AdapteeImpl();
        //实例化适配器
        Target targetAdapter = new TargetAdapter(adaptee);
        targetAdapter.execute(1,2);
    }

}