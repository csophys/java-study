package books.deep_analysis_java_web.classloader;

/**
 * Created by csophys on 16/5/8.
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) {
        //系统默认的加载器
        System.out.println(MyClassLoader.class.getClassLoader().getClass().getCanonicalName());
    }
}
