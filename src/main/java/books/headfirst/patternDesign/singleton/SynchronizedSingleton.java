package books.headfirst.patternDesign.singleton;

/**
 * Created by csophys on 16/7/3.
 */
public class SynchronizedSingleton implements Singleton{
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {

    }

    /**
     * 加同步修饰的单例模式,并发访问性能会降低
     * @return
     */
    public synchronized static SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
