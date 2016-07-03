package books.headfirst.patternDesign.singleton;

/**
 * Created by csophys on 16/7/3.
 */
public class DoubleCheckSynchronizedSingleton implements Singleton{
    private volatile static DoubleCheckSynchronizedSingleton instance;

    private DoubleCheckSynchronizedSingleton() {

    }

    /**
     * 加同步修饰的单例模式,只有第一次创建对象才有同步问题,之后不存在.注意多个线程间的变量值同步问题.小概率的问题 volatile.
     * @return
     */
    public static DoubleCheckSynchronizedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSynchronizedSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckSynchronizedSingleton();
                }
            }

        }
        return instance;
    }
}
