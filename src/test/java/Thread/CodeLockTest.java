package Thread;

import junit.framework.Assert;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by csophys on 15/7/14.
 */
public class CodeLockTest {
    static int i = 1;

    public static void getTargtValueWithoutSynchronized() throws InterruptedException {
        //output current value
        //System.out.println(i);
        Assert.assertTrue(i == 1);
        i++;
        //放大线程不安全的效果
        Thread.sleep(1);
        i--;
    }

    public static void getTargtValue() throws InterruptedException {
        //output current value
        System.out.println(i);
        Assert.assertTrue(i == 1);
        i++;
        //放大线程不安全的效果
        Thread.sleep(1);
        i--;
    }

    //修饰代码块
    /*{
        synchronized (this) {

        }
        synchronized (SynchronizedCodeTest.class){

        }
    }*/

    /**
     * 全局定义一把锁，默认未非公平锁，抢占锁不按照等待先后
     */
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void lockWithoutUnlock() {
        reentrantLock.lock();
        System.out.println(i);
    }

    public static void lockWithUnlock(){
        reentrantLock.lock();
        try {
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }

    }

    @Test
    public void testMultipleThreadInvokeWithoutSynchornized() {
        Executor executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        getTargtValueWithoutSynchronized();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    @Test
    public void testMultipleThreadInvoke() {
        Executor executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        getTargtValue();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Test
    public void testTryLockWithoutUnlock() {
        Executor executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    lockWithoutUnlock();
                }
            });
        }
    }

    @Test
    public void testTryLockWithUnlock() {
        Executor executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    lockWithUnlock();
                }
            });
        }
    }

    /*volatile  保存变量可见性，变量只会在主存中存在，不会在本地线程中保存副本。但是不会保证互斥功能。*/
}
