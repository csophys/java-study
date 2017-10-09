package spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by csophys on 15/12/10.
 */

//profile 配置
@Profile("product")

//package scan。默认为当前包，可以通过exclude设置Filter
@ComponentScan({"spring.bean","spring.validate"})
//@ComponentScan(value = "spring.hello", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "spring.hello.bean.WebConfig"))

//@Import({MessagePrinter.class})
//@ImportResource("classpath:application.xml")

//导入其他配置文件
@PropertySource("classpath:config.propertity")

//lombok 语法糖
//@Log4j


@Configuration
public class ProductConfig {

    // spring内置的观察者模式
    @Resource
    ApplicationEventPublisher applicationEventPublisher;


    Logger logger = LoggerFactory.getLogger(ProductConfig.class);

    @Bean(name = {"messageServiceV1", "messageServiceV2"})
    //@Scope("prototype")
    public MessageService messageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return "hello spring 4.2.3-Release in Product Envrironment";
            }

            @PostConstruct
            private void init() {
                System.out.println("message service OK");
            }
        };
    }

    //BeanFactoryPostProcessor
    @Bean
    public BeanFactoryPostProcessor beanAnnotationPostProcess() {
        return new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                System.out.println("bean annotation bean factory post process");
            }
        };
    }

    //BeanDefinitionRegistryPostProcessor
    @Bean
    public BeanDefinitionRegistryPostProcessor beanAnnotationRegistryPostProcess() {
        return new BeanDefinitionRegistryPostProcessor() {
            @Override
            public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

            }

            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                System.out.println("bean registry annotation bean factory post process");
                logger.error("error do !!!!");
            }
        };
    }


    //BeanPostProcessor
    @Bean
    public BeanPostProcessor beanAnnotationPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("BeforePostProcess:" + beanName);
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("AfterPostProcess:" + beanName);
                return bean;
            }
        };
    }

}
