package base.oom;

/**
 * Created by csophys on 2017/6/6.
 */
public class MultipleStackOverFlow {


    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
     * @param args
     */
    public static void main(String[] args) {
        int i =0;
        while (i<2000){
            System.out.println(++i);
            new Thread(new testThread()).start();
        }
    }

    static class testThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(200000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
