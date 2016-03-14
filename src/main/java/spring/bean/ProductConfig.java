package spring.bean;

import lombok.extern.log4j.Log4j;
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
@Profile("product")
@ComponentScan(value = "spring.hello", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "spring.hello.bean.WebConfig"))
//@Import({MessagePrinter.class})
/*@ImportResource("classpath:application.xml")*/
@PropertySource("classpath:config.propertity")
@Configuration
@Log4j
public class ProductConfig {
    @Resource
    ApplicationEventPublisher applicationEventPublisher;

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

    @Bean
    public BeanFactoryPostProcessor beanAnnotationPostProcess() {
        return new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                System.out.println("bean annotation bean factory post process");
            }
        };
    }

    @Bean
    public BeanDefinitionRegistryPostProcessor beanAnnotationRegistryPostProcess() {
        return new BeanDefinitionRegistryPostProcessor() {
            @Override
            public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

            }

            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                System.out.println("bean registry annotation bean factory post process");
            }
        };
    }


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
