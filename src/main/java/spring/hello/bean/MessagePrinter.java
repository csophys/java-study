package spring.hello.bean;

import org.springframework.core.env.Environment;
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

    @Resource
    Environment environment;


    public void printMessage() {
        System.out.println("printMessage:" + messageService.getMessage());
        System.out.println("active profile:" + environment.getActiveProfiles());
        System.out.println("java home:" + environment.getProperty("JAVA_HOME"));
        System.out.println("name is:" + environment.getProperty("name"));
        System.out.println("day is:" + environment.getProperty("day"));
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
