package thread;

import org.junit.Test;

/**
 * Created by csophys on 15/7/19.
 */
public class TestJoin {

    /**
     *join 能够使得两个线程顺序执行，比如A，B两个线程同时在执行，在B线程中执行A.join()后B会等到A线程执行结束后才会执行
     */
    @Test
   public  void testStartMultipleThread(){
       Thread thread1 = new MyThread();
       Thread thread2 = new MyThread();

       thread1.start();
       thread2.start();
    }

    @Test
    public void testJoin(){
        final Thread thread1;
        Thread thread2;

        thread1 = new Thread(new Runnable() {
            public void run(){
                for(int i=1;i<100;i++){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });


        thread2 = new Thread(new Runnable() {
            public void run(){
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=1;i<100;i++){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });


        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private class MyThread extends Thread{

        public void run(){
            for(int i=0 ;i<10;i++){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
