package spring.validate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by csophys on 16/3/14.
 */
@RestController
public class ValidateController {

    @RequestMapping("/validate")
    public String hello(PersonForm personForm){
        System.out.println(personForm);
        return personForm.toString();
    }
}
