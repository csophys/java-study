package EmbedApplicationServer;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created by csophys on 15/6/7.
 */
public class TomcatEmbedTest {
    private final static String docBase = "/Users/csophys/developer/apache-tomcat-8.0.15/webapps/softPhoneTest";

    @Test
    public void startEmbedTomcat() throws Exception{
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);
        tomcat.setBaseDir(docBase);

        tomcat.addWebapp("/",docBase);
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        Logger.getLogger(TomcatEmbedTest.class.getName()).info("tomcat"+"已经启动");
    }
}
