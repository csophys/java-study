package spring;

import org.springframework.util.ObjectUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spring.bean.WebConfig;
import spring.bean.WebSocketConfig;

/**
 * Created by csophys on 15/12/18.
 */
public class ServletDispatchIntialier extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{WebConfig.class, WebSocketConfig.class};
    }



/*
    spring 容器启动的时候配置信息
*/
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        Class<?>[] configClasses = getRootConfigClasses();
        if (!ObjectUtils.isEmpty(configClasses)) {
            AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
            rootAppContext.getEnvironment().setActiveProfiles("product");
            rootAppContext.register(configClasses);
            return rootAppContext;
        } else {
            return null;
        }
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }



    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
