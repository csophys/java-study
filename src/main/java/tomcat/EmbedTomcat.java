package tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.Before;
import org.junit.Test;
import util.HttpUtil;

import javax.servlet.ServletException;

/**
 * Created by csophys on 16/5/2.
 */
//FIXME: embedTomcat error
public class EmbedTomcat {

    private static Tomcat tomcat;
    private static final String CURRENT_MODULE_NAME = "java-study";
    private static final int SERVER_PORT = 9999;

    @Before
    public void setUp() throws InterruptedException {
        //启动tomcat线程
        if (tomcat != null) {
            return;
        } else {
            deployEmbedTomcat();
            synchronized (this) {
                this.wait();
            }
        }
    }

    private void deployEmbedTomcat() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doDeployEmbedTomcat();
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (LifecycleException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void doDeployEmbedTomcat() throws ServletException, LifecycleException {
        //FIXME:embed tomcat error
        String webappDirLocation =  "src/main/webapp/";
        tomcat = new Tomcat();
        tomcat.setPort(SERVER_PORT);

        String docBase = "/Users/csophys/developer/apache-tomcat-8.0.15/webapps/softPhoneTest";
        tomcat.setBaseDir(docBase);
        tomcat.addWebapp("/",docBase);

/*
        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        //tomcat lib dir，不清楚什么意思
        File additionWebInfClasses = new File(CURRENT_MODULE_NAME + "/target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);
*/
        tomcat.start();
        synchronized (this) {
            this.notify();
        }
        tomcat.getServer().await();
    }


    @Test
    public void send404Error() throws Exception {
        HttpUtil.get("http://localhost:" + SERVER_PORT + "/send");
    }
}
