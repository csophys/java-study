package spring.hello.bean;

import org.springframework.context.annotation.*;

/**
 * Created by csophys on 15/12/10.
 */
@Profile("product")
@ComponentScan
//@Import({MessagePrinter.class})
//@ImportResource
@PropertySource("config.propertity")
@Configuration
public class ProductConfig {
    @Bean(name = {"messageServiceV1", "messageServiceV2"})
    public MessageService messageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return "hello spring 4.2.3-Release in Product Envrironment";
            }
        };
    }

}
