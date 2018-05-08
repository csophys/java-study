package books.headfirst.patternDesign.commond;

/**
 * Created by csophys on 2018/5/7.
 */
public class JDKCommandDemo {
    public static void main(String[] args) {
        //命令模式
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("hello world");
            }
        };

        Thread thread = new Thread(runnable);

        //传递命令对象，最终执行的是run方法
        thread.start();

        /**
         * runnable --> command
         * thread --> receive
         * this --> client
         */
    }
}
