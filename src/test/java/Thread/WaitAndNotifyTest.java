package thread;

import org.junit.Test;

/**
 * Created by csophys on 15/7/20.
 */
public class WaitAndNotifyTest {
    @Test
    public void testWaitAndNotfiy() {
        final Object a = new Object();
        Thread thread1 = new Thread(new MyTask("A",a));
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (a){
                    a.notify();
                }
            }
        });
        thread1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }

}

class MyTask implements Runnable {
    private String name;
    private Object o;

    public MyTask(String name, Object o) {
        this.name = name;
        this.o = o;
    }

    /**
     * Warinning:两个等待和释放线程执行会发生死锁
     */
    public void run() {
            System.out.println(name);
                synchronized (o){
                    try {
                        o.wait();
                        System.out.println(name+"已被唤醒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }

    }
