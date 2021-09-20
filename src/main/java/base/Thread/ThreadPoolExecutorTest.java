package base.Thread;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by csophys on 15/7/12.
 */
public class ThreadPoolExecutorTest {
    private static ThreadPoolExecutor threadPoolExecutor;

    private static BlockingQueue blockingQueue;
    public static CountDownLatch countDownLatch;

    @BeforeClass
    public static void setBeforeClass() {
        blockingQueue = new ArrayBlockingQueue(2);
        threadPoolExecutor = new ThreadPoolExecutor(2, 3, 10, TimeUnit.MINUTES, blockingQueue, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("拒绝!");
            }
        });
        countDownLatch = new CountDownLatch(6);
    }

    /**
     * 测试下拒绝策略执行。
     * Q：核心线程池还没有满，新来的任务怎么执行的？
     * A：会直接让核心线程池执行当前任务。
     * Q：阻塞队列满了，最大线程池还没有满，新的任务怎么执行？
     * A：阻塞队列满了，但是线程池的线程数量小于maxPoolExecutor，此时增加新的任务，会立即执行新的任务，而不会从队列中取任务
     * Q：worker执行完任务后，怎么执行新的任务？
     * A: worker执行的时候会在runWorker中进入一个while循环，在while循环中会执行传入的task，或者去阻塞队列take任务，如果没有任务，则会在take上进行阻塞。
     * Q：扩展的worder什么时候会销毁？
     * A: 首先是一个自旋，当allowCoreThreadTimeout(运行空闲核心线程超时) 或 wc>corePoolSize(当前线程数量大于核心线程数量) 时，timed会标识为true，表示需要进行超时判断。当wc（当前工作者数量）大于 最大线程数 或 空闲线程的空闲时间大于keepAliveTime（timed && timeout），以及wc>1或（workQueue）任务队列为空时，会进入compareAndDecrementWorkerCount方法，对wc的值减1。
     * 当compareAndDecrementWorkerCount方法返回true时，则getTask方法会返回null，终止getTask方法的自旋。这时候回到runWorker方法，就会进入到processWorkerExit方法，进行销毁worker。
     */
    @Test
    public void testExecuteThrowThreadPool() {
        System.out.println("观察控制台输出的值是否有序");
        threadPoolExecutor.execute(new Task(5));
        threadPoolExecutor.execute(new Task(14));
        threadPoolExecutor.execute(new Task(6));
        threadPoolExecutor.execute(new Task(19));
        threadPoolExecutor.execute(new Task(20));
        threadPoolExecutor.execute(new Task(10));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Runnable, Comparable<Task> {
    private int value = 0;

    public Task(int value) {
        this.value = value;
    }

    public void run() {
        System.out.println(value);
        try {
            Thread.sleep(1000);
            ThreadPoolExecutorTest.countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value++;
    }


    /**
     * 实现compareTo()方法。它接收其他事件作为参数，并且比较当前事件与参数的优先级。
     * 如果当前事件的优先级更大，则返回-1，如果这两个优先级相等，则返回0，如果当前事件的优先级更小，则返回1。
     * 注意，这与大多数Comparator.compareTo()的实现是相反的。
     */
    public int compareTo(Task task) {
        return this.value - task.value;
    }
}
