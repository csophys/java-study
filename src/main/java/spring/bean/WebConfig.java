package spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Properties;

/**
 * Created by csophys on 15/12/15.
 */


/*
import 其他bean
*/
@Import({QAConfig.class, ProductConfig.class})
/*@ImportResource("classpath:application.xml")*/

/*
启用spring mvc配置
*/
@EnableWebMvc

/*
Component的子类，代表配置类
*/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Resource
    Environment environment;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setViewClass(org.springframework.web.servlet.view.freemarker.FreeMarkerView.class);
        freeMarkerViewResolver.setContentType("text/html;charset=UTF-8");
        freeMarkerViewResolver.setSuffix(".ftl");
        return freeMarkerViewResolver;
    }


    @Bean
    public FreeMarkerConfigurer configurerFreeMarker() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/resources/pages/");
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");
        freeMarkerConfigurer.setFreemarkerSettings(getSettings());
        return freeMarkerConfigurer;
    }


    private Properties getSettings() {
        Properties properties = new Properties();
        properties.put("locale", "zh_CN");
        return properties;
    }

    @PostConstruct
    private void init() {
        System.out.println(environment.getProperty("name"));
        for (String profile : environment.getActiveProfiles()) {
            System.out.println("current profile:" + profile);
        }

    }
}
