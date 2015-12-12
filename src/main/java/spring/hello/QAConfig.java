package spring.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by csophys on 15/12/10.
 */
@Profile("devs")
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
