package books.headfirst.patternDesign.singleton;

import org.junit.Assert;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by csophys on 16/7/3.
 */
public class SingletonTest {

    public static void multilpleGetInstance(final String o) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(100);

        //闭锁判断线程是否全部完成
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        //线程安全的set
        final Set<Singleton> singletonSet = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    if (PlainSingleton.class.getCanonicalName().contains(o)) {
                        singletonSet.add(PlainSingleton.getInstance());
                    } else if (SynchronizedSingleton.class.getCanonicalName().contains(o)) {
                        singletonSet.add(SynchronizedSingleton.getInstance());
                    } else if (EagerSingleton.class.getCanonicalName().contains(o)) {
                        singletonSet.add(EagerSingleton.getInstance());
                    } else if (DoubleCheckSynchronizedSingleton.class.getCanonicalName().contains(o)) {
                        singletonSet.add(DoubleCheckSynchronizedSingleton.getInstance());
                    }

                    countDownLatch.countDown();
                }
            });

        }
        countDownLatch.await();
        System.out.println(singletonSet.size());
        for (Singleton singleton : singletonSet) {
            System.out.println(singleton);
        }
        Assert.assertTrue(singletonSet.size() == 1);
    }
}