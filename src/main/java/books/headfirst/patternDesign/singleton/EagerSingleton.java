package books.headfirst.patternDesign.singleton;

/**
 * Created by csophys on 16/7/3.
 */
public class EagerSingleton implements Singleton{
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {

    }

    /**
     * 饿汉式创建单例模式
     * @return
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}
