package spring.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.hello.bean.MessagePrinter;
import spring.hello.bean.ProductConfig;
import spring.hello.bean.QAConfig;

/**
 * Created by csophys on 15/12/6.
 */

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("product");
        context.register(QAConfig.class, ProductConfig.class);
        context.refresh();

        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
    }
}
