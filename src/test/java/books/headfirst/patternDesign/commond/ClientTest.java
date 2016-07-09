package books.headfirst.patternDesign.commond;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by csophys on 16/7/9.
 */
public class ClientTest {

    @Test
    public void testInvokeCommand(){

        //设置命令的receiver
        Receiver receiver = new ReceiverImpl();
        //创建commond命令
        ICommond commond = new CommondImpl(receiver);
        //设置invoker common命令
        Invoker invoker = new Invoker();
        invoker.setCommond(commond);
        //执行invoker的common命令
        invoker.fire();
        try {
            invoker.cancel();
        } catch (UnsupportedOperationException e) {
            Assert.assertTrue(true);
        }
    }

}