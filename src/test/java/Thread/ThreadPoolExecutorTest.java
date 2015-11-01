package thread;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by csophys on 15/7/12.
 */
public class ThreadPoolExecutorTest {
    private static ThreadPoolExecutor threadPoolExecutor;

    private static BlockingQueue blockingQueue;

    @BeforeClass
    public static void setBeforeClass() {
        //优先队列
        blockingQueue = new PriorityBlockingQueue();
        threadPoolExecutor = new ThreadPoolExecutor(1, 100, 10, TimeUnit.MINUTES, blockingQueue);
    }


    @Test
    public void testExecuteThrowThreadPool() {
        System.out.println("观察控制台输出的值是否有序");
        threadPoolExecutor.execute(new Task(5));
        threadPoolExecutor.execute(new Task(14));
        threadPoolExecutor.execute(new Task(6));
        threadPoolExecutor.execute(new Task(19));
        threadPoolExecutor.execute(new Task(20));
        threadPoolExecutor.execute(new Task(10));
    }
}

class Task implements Runnable, Comparable<Task> {
    private int value = 0;

    public Task(int value) {
        this.value = value;
    }

    public void run() {
        System.out.println(value);
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
