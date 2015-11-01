package thread;

import junit.framework.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by csophys on 15/7/11.
 *
 * @author csophys
 */
public class SingleThreadAndThreadPoolExecuteCompare {

    @Test
    public void TestSimpleTask() {
        long 简单任务 = 10000000l;
        //普通计算方式
        long start = System.currentTimeMillis();
        单线程计算方式(简单任务);
        long end = System.currentTimeMillis();
        long 单线程计算花费时长 = end - start;

        //多线程计算方式
        start = System.currentTimeMillis();
        int 多线程数目 = 10;
        多线程计算方式(简单任务, 多线程数目);
        end = System.currentTimeMillis();
        long 多线程计算花费时长 = end - start;

        System.out.println("多线程计算花费时长(ms):" + 多线程计算花费时长);
        System.out.println("单线程计算花费时长(ms):" + 单线程计算花费时长);
        Assert.assertTrue(多线程计算花费时长 > 单线程计算花费时长);
    }

    @Test
    public void TestComplexTask(){
        long 复杂任务 = 1000000000l;
        //普通计算方式
        long start = System.currentTimeMillis();
        单线程计算方式(复杂任务);
        long end = System.currentTimeMillis();
        long 单线程计算花费时长 = end - start;

        //多线程计算方式
        start = System.currentTimeMillis();
        int 多线程数目 = 10;
        多线程计算方式(复杂任务, 多线程数目);
        end = System.currentTimeMillis();
        long 多线程计算花费时长 = end - start;

        System.out.println("多线程计算花费时长(ms):" + 多线程计算花费时长);
        System.out.println("单线程计算花费时长(ms):" + 单线程计算花费时长);
        Assert.assertTrue(多线程计算花费时长 < 单线程计算花费时长);

    }

    //如果同时运行的线程比较多，那线程执行一个具体任务t所化的时间会比用单一线程执行任务t所化的时间多很多

    private void 多线程计算方式(long targetValue, int segmentNum) {
        Executor executor = Executors.newFixedThreadPool(segmentNum);
        CountDownLatch countDownLatch = new CountDownLatch(segmentNum);
        for (int i = 0; i < segmentNum; i++) {
            executor.execute(new Task(countDownLatch, targetValue / segmentNum));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void 单线程计算方式(long targetValue) {
        doComputer(targetValue);
    }

    public static void doComputer(long targetValue) {

        System.out.println(Thread.currentThread() + "开始计算，targetValue=" + targetValue);
        long start = System.currentTimeMillis();
        while (targetValue > 0) {
            targetValue--;
        }
        System.out.println(Thread.currentThread() + "计算完成,花费时长(ms)=" + (System.currentTimeMillis() - start));

    }



    private class Task implements Runnable {
        CountDownLatch countDownLatch;
        long targetValue;

        public Task(CountDownLatch countDownLatch, long targeValue) {
            this.countDownLatch = countDownLatch;
            this.targetValue = targeValue;
        }

        public void run() {
            doComputer(targetValue);
            countDownLatch.countDown();
        }
    }
}
