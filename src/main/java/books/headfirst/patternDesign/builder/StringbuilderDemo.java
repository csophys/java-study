package books.headfirst.patternDesign.builder;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by csophys on 2018/4/16.
 */
public class StringbuilderDemo {

    public static void main(String[] args) {
    }

    @Test
    public void testAppendNull() {
        String append = null;
        StringBuilder csophys = new StringBuilder("csophys");
        csophys.append(append);
        Assert.assertEquals(csophys.toString(), "csophysnull");
    }

    @Test
    public void testNonThreadSafe() throws InterruptedException {
        final StringBuilder csophys = new StringBuilder("csophys");
        //final StringBuffer csophys = new StringBuffer("csophys");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int threadNums = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNums);
        StringBuilder expectStr = new StringBuilder("csophys");
        for (int i = 0; i < threadNums; i++) {
            expectStr.append("s");
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    csophys.append("s");
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        Assert.assertNotEquals(expectStr.toString(), csophys.toString());
    }
}
