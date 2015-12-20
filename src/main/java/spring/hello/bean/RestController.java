package spring.hello.bean;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by csophys on 15/12/20.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @RequestMapping("/simple")
    public spring.hello.bean.Model simpleRest() {
        return new Model("csophys", "男");
    }
}
