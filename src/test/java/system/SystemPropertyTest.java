package system;

import org.junit.Test;

/**
 * Created by csophys on 15/6/7.
 */
public class SystemPropertyTest {

    @Test
    public void getSystemProperty(){
        System.out.println(System.getenv());
        System.out.println("path:"+System.getenv("PATH"));
        System.out.println(System.getProperties());
        System.out.println("class:"+System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
