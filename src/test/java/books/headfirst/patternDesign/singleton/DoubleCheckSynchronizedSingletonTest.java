package books.headfirst.patternDesign.singleton;

import org.junit.Test;

/**
 * Created by csophys on 16/7/3.
 */
public class DoubleCheckSynchronizedSingletonTest {


    //单例创建线程不安全
    @Test
    public void testGetInstance() throws Exception {
        SingletonTest.multilpleGetInstance("DoubleCheckSynchronizedSingleton");
    }
}