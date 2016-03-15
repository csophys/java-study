package spring.validate;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by csophys on 16/3/14.
 */
@RestController
public class ValidateController {

    @RequestMapping("/validate")
    public String hello(@Valid PersonForm personForm,BindingResult bindingResult){
        System.out.println(personForm);
        return personForm.toString();
    }
}
