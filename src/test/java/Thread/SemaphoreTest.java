package thread;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by csophys on 15/7/15.
 */
public class SemaphoreTest {

    Semaphore semaphore = new Semaphore(2);
    Executor executor = Executors.newCachedThreadPool();

    /**
     * 信号量Demo，
     * 注意：主线程如果结束后所有其附属的子线程也都会直接结束
     */
    @Test
    public void testSemaphore() {

        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println("线程" + Thread.currentThread().getName() + "开始获取信号量");
                        semaphore.acquire();
                        System.out.println("线程" + Thread.currentThread().getName() + "已经获取信号量!");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
