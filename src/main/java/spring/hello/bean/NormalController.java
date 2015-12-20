package spring.hello.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(params = "param", headers = "content-type:text/html", consumes = "applcation/*", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String params() {
        return "hello,params";
    }

    @RequestMapping("/html")
    public String htmlView() {
        return "/normalTest.html";
    }


    @RequestMapping("/requestParam")
    @ResponseBody
    public String requestParam(@RequestParam(value = "param1", defaultValue = "default") String param1) {
        return "hello,param=" + param1;
    }

    @RequestMapping("cookieValue")
    @ResponseBody
    public String cookieValue(@CookieValue("ticket") String ticket) {
        return "cookie:" + ticket;
    }

}
