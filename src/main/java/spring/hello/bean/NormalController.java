package spring.hello.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by csophys on 15/12/19.
 */
@Controller
@RequestMapping("/normal")
public class NormalController {

    @RequestMapping("/rest")
    @ResponseBody
    public String normal() {
        return "hello";
    }

    @RequestMapping("/html")
    public String htmlView(){
        return "normal";
    }

}
