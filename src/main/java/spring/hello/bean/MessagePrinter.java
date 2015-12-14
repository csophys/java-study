package spring.hello.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import spring.hello.event.MessageProduceEvent;

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

    @Resource
    ApplicationContext applicationContext;

    @Resource
    ApplicationEventPublisher applicationEventPublisher;



    public void printMessage() {
        System.out.println("当前的messageService为："+messageService);
        System.out.println("printMessage:" + messageService.getMessage());
        System.out.println("当前的messageService为："+applicationContext.getBean(MessageService.class));
        System.out.println("active profile:" + environment.getActiveProfiles()[0]);
        System.out.println("java home:" + environment.getProperty("JAVA_HOME"));
        System.out.println("name is:" + environment.getProperty("name"));
        System.out.println("day is:" + environment.getProperty("day"));
        applicationEventPublisher.publishEvent(new MessageProduceEvent("hello event in message"));
    }


    @Bean
    public ApplicationListener<MessageProduceEvent> getMessageProductEventA() {
        return new ApplicationListener<MessageProduceEvent>() {
            @Override
            public void onApplicationEvent(MessageProduceEvent event) {
                System.out.println("messageProduct event captured in A");
            }
        };
    }

    @Bean
    public ApplicationListener<MessageProduceEvent> getMessageProductEventB() {
        return new ApplicationListener<MessageProduceEvent>() {
            @Override
            public void onApplicationEvent(MessageProduceEvent event) {
                System.out.println("messageProduct event captured in B");
            }
        };
    }

    @EventListener
    public void getContextRefreshEventByAnnotation(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("contextRefreshedEvent event capture in Annotation method." + contextRefreshedEvent);
    }

    @EventListener
    @Order(6)
    public void getMessageProductByAnnotationC(MessageProduceEvent messageProduceEvent) {
        System.out.println("messageProduct event capture in Annotation method C." + messageProduceEvent);
    }

    @EventListener
    @Order(5)
    public void getMessageProductByAnnotationD(MessageProduceEvent messageProduceEvent) {
        System.out.println("messageProduct event capture in Annotation method D." + messageProduceEvent);
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
