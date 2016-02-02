package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.bean.MessagePrinter;
import spring.bean.MyBeanFactoryPostProcessBeforeRefresh;
import spring.bean.ProductConfig;
import spring.bean.QAConfig;

/**
 * Created by csophys on 15/12/6.
 */

public class Application {

    public static void main(String[] args) {
        startContext();
    }

    public static void startContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("product");
        context.register(QAConfig.class, ProductConfig.class);
        context.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessBeforeRefresh());
        context.refresh();

        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
    }

    public static void testForClj() {
        System.out.println("hello");
    }
}
