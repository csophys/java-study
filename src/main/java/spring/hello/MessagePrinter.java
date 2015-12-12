package spring.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by csophys on 15/12/6.
 */
@Component
public class MessagePrinter {

    @Autowired
    MessageService messageService;


    public void printMessage() {
        System.out.println(messageService.getMessage());
    }
}
