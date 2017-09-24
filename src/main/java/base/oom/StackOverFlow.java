package base.oom;

/**
 * Created by csophys on 2017/6/5.
 */
public class StackOverFlow {

    private static int i;
    /**
     * 设置栈大小-Xss512K
     * @param args
     */
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        System.out.println(++i);
        test();
    }
}
