package spring.hello.bean;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by csophys on 15/12/10.
 */
@Profile("product")
@ComponentScan(value = "spring.hello", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "spring.hello.bean.WebConfig"))
//@Import({MessagePrinter.class})
//@ImportResource
@PropertySource("classpath:config.propertity")
@Configuration
public class ProductConfig {
    @Resource
    ApplicationEventPublisher applicationEventPublisher;

    @Bean(name = {"messageServiceV1", "messageServiceV2"})
    @DependsOn(value = "messagePrinter")
    //@Scope("prototype")
    public MessageService messageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return "hello spring 4.2.3-Release in Product Envrironment";
            }

            @PostConstruct
            private void init() {
                System.out.println("message service OK");
            }
        };
    }


}
