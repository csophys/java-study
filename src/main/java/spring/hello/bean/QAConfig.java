package spring.hello.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by csophys on 15/12/10.
 */
@Profile("dev")
@ComponentScan
@Configuration
public class QAConfig {

    @Bean
    public MessageService messageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return "hello spring 4.2.3-Release in QA Envrironment";
            }
        };
    }

}
