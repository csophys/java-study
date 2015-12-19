package spring.hello.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by csophys on 15/12/15.
 */
@Import({QAConfig.class, ProductConfig.class})
@EnableWebMvc
@Configuration

public class WebConfig extends WebMvcConfigurerAdapter {

    @Resource
    Environment environment;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/").addResourceLocations("/resources/**");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @PostConstruct
    private void init() {
        System.out.println(environment.getProperty("name"));
        for (String profile : environment.getActiveProfiles()) {
            System.out.println("current profile:" + profile);
        }

    }
}
