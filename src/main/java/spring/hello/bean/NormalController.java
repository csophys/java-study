package spring.hello.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by csophys on 15/12/19.
 */
@Controller
@RequestMapping("/normal")
public class NormalController {

    @RequestMapping(value = "/rest", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String normal() {
        return "hello";
    }

    @RequestMapping({"/rest/{path}/**/{pathReg:\\d+}", "/rest/another/{path}/{pathReg}"})
    @ResponseBody
    public String normalCustomize(@PathVariable String path, @PathVariable("pathReg") String pathReg) {
        return "hello," + path + "," + pathReg;
    }

    @RequestMapping("/html")
    public String htmlView() {
        return "normal";
    }

}
