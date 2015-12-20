package spring.hello.bean;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by csophys on 15/12/20.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {


    @RequestMapping("/simple")
    public Model simpleRest() {
        return new Model("csophys", "男");
    }

    @Data
    static class Model {
        private String name;

        private String sex;

        Model(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }
    }
}
