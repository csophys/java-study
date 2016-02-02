package spring.bean;

import org.springframework.context.annotation.*;

/**
 * Created by csophys on 15/12/10.
 */
@Profile("dev")
@ComponentScan(value = "spring.hello", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "spring.hello.bean.WebConfig"))
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
