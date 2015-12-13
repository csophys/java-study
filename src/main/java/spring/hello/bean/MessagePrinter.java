package spring.hello.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by csophys on 15/12/6.
 */
@Component
public class MessagePrinter {

    @Resource(name = "messageServiceV2")
    MessageService messageService;


    public void printMessage() {
        System.out.println(messageService.getMessage());
    }

    @PostConstruct
    private void init() {
        System.out.println("message Printer Ok");
    }

    @PreDestroy
    private void destory() {
        System.out.println("message Printer destroy");
    }
}
