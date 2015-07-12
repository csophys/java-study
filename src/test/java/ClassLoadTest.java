import org.junit.Test;

/**
 * Created by csophys on 15/6/7.
 */
public class ClassLoadTest {

    @Test
    public void loadClassWithThisClassLoader() throws Exception {

        /**
         * 如果class 已经被加载过了，就返回加载的对象，一个类只能被加载一次
         */
        Class<?> loadClass = this.getClass().getClassLoader().loadClass("ClassLoadTest");
        System.out.println(loadClass);

        Class<?> superclass = this.getClass().getClassLoader().loadClass("java.util.Date");
        System.out.println(superclass);

    }

    @Test
    public void testGetClassPath() {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(this.getClass().getClassLoader().getResource(""));
    }

    @Test
    public void testInstanceOfClass(){
        Integer integer = new Integer(6);
        System.out.println(integer instanceof Object);
    }

    @Test
    public void  testGetClassName(){
        System.out.println(this.getClass().getClassLoader().getClass().getCanonicalName());
        System.out.println(this.getClass().getClassLoader().getParent().getClass().getCanonicalName());
        System.out.println(hashCode() + "父类：" + super.hashCode());
        System.out.println(this.getClass().hashCode());
    }
}
