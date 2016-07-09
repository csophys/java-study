package spring.bean;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
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


    @RequestMapping("/normal")
    public String normalDTO(TestDTO testDTO){
        return testDTO.toString();
    }

    @RequestMapping("/requestBody")
    public String requestBody(@RequestBody TestDTO testDTO){
        return testDTO.toString();
    }

}

@Data
class TestDTO{
    private String name;
    private String sex;

    @Override
    public String toString() {
        return "TestDTO{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

