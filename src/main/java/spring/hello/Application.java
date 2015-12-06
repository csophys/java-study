package spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by csophys on 15/12/6.
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    public MessageService mockMessageService(){
        return new MessageService() {
            @Override
            public String getMessage() {
                return "hello spring 4.2.3-Release";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
    }
}
