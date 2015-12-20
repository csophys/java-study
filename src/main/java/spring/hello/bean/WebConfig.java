package spring.hello.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by csophys on 15/12/15.
 */
@Import({QAConfig.class, ProductConfig.class})
@ImportResource("classpath:application.xml")
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
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        /*registry.jsp("/resources/pages/",".jsp");
        registry.jsp("/",".html");*/
        //registry.freeMarker();
    }

/*
    @Bean
    public FreeMarkerConfigurer configurerFreeMarker() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/resources/pages/");
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");
        return freeMarkerConfigurer;
    }
*/

    @PostConstruct
    private void init() {
        System.out.println(environment.getProperty("name"));
        for (String profile : environment.getActiveProfiles()) {
            System.out.println("current profile:" + profile);
        }

    }
}
