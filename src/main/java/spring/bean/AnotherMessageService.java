package spring.bean;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by csophys on 15/12/14.
 */
@Service
//@DependsOn("messageServiceV2")
public class AnotherMessageService {

    @PostConstruct
    private void init() {
        System.out.println("another Message Service OK");
    }
}
