package spring.hello.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/rest/{path}/**/{pathReg:\\d+}")
    @ResponseBody
    public String normalCustomize(@PathVariable String path, @PathVariable("pathReg") String pathReg) {
        return "hello," + path + "," + pathReg;
    }

    @RequestMapping("/html")
    public String htmlView() {
        return "normal";
    }

}
