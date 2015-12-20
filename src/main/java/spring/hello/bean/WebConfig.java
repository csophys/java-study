package spring.hello.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

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
        registry.addResourceHandler("/**").addResourceLocations("/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //registry.freeMarker().prefix("/resources/pages/").suffix(".ftl");
    }

    @Bean
    public FreeMarkerConfigurer configurerFreeMarker() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        return freeMarkerConfigurer;
    }

    @PostConstruct
    private void init() {
        System.out.println(environment.getProperty("name"));
        for (String profile : environment.getActiveProfiles()) {
            System.out.println("current profile:" + profile);
        }

    }
}
