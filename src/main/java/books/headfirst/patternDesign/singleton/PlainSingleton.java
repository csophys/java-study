package books.headfirst.patternDesign.singleton;

/**
 * Created by csophys on 16/7/3.
 */
public class PlainSingleton implements Singleton {
    private static PlainSingleton instance;

    private PlainSingleton() {

    }

    /**
     * 普通单例模式,当多线程并发访问的时候,可能会出现创建了多个实例
     * @return
     */
    public static PlainSingleton getInstance() {
        if (instance == null) {
            instance = new PlainSingleton();
        }
        return instance;
    }
}
