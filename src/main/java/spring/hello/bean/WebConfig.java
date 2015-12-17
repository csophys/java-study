package spring.hello.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by csophys on 15/12/15.
 */
@Import({QAConfig.class, ProductConfig.class})
@EnableWebMvc
@Configuration
public class WebConfig {

    @Resource
    Environment environment;

    @PostConstruct
    private void init() {
        System.out.println(environment.getProperty("name"));
//        System.out.println(environment.getActiveProfiles()[0]);
    }
}
