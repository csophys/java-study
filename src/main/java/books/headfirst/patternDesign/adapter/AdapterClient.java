package books.headfirst.patternDesign.adapter;

/**
 * Created by csophys on 16/7/9.
 */
public class AdapterClient {

    public void testAdapter(){
        //实例化被适配类
        Adaptee adaptee = new AdapteeImpl();
        //实例化适配器
        Target targetAdapter = new TargetAdapter(adaptee);
        targetAdapter.execute(1,2);
    }
}
