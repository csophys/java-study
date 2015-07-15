package Thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by csophys on 15/7/15.
 */
public class CountDownLatchAndCyclicBarrierTest {

    Executor executor = Executors.newFixedThreadPool(10);

    /**
     * countDownLatch用户计数，主线程会等countDownLatch的countValue回到0后继续执行。
     * 而子线程在countDownLatch.countDown后会继续往下执行
     */
    @Test
    public void testCountDownLatch() {
        final CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }


    /**
     * CyclicBarrier 会等所有的子线程都到达某一个屏障后（cyclicBarrier.await），才会执行屏障中的指定线程。在
     * 此之前所有子线程和主线程都会处于等待状态
     */
    @Test
    public void testCyclicBarrier() {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(11, new Runnable() {
            public void run() {
                System.out.println("所有子线程都已经到达屏障");
            }
        });

        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完成");
                }
            });
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行完成");
    }
}
