package thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by csophys on 15/7/20.
 */
public class ExchangerTest {
    Exchanger exchanger = new Exchanger();
    @Test
    public void testExcanger(){
        Thread thread1 = new Thread(new Runnable() {
            List<String> list = new ArrayList<String>();
            public void run() {
                list.add("thread1");
                System.out.println(Thread.currentThread().getName()+"list交换前的值为:" + list);
                try {
                    list = (List<String>) exchanger.exchange(list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"list交换后的值为:"+list);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            List<String> list = new ArrayList<String>();
            public void run() {
                list.add("thread2");
                System.out.println(Thread.currentThread().getName()+"list交换前的值为:" + list);
                try {
                    list = (List<String>) exchanger.exchange(list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"list交换后的值为:"+list);
            }
        });
        thread1.start();
        thread2.start();
    }
}
