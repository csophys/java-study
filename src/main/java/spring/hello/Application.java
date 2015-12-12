package spring.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by csophys on 15/12/6.
 */

@ComponentScan
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("product");
        context.register(Application.class,QAConfig.class, ProductConfig.class);
        context.refresh();

        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
    }
}
