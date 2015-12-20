package spring.hello.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by csophys on 15/12/20.
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/html")
    public String simpleHtml() {
        return "/normalTest";
    }

    @RequestMapping("/jsp")
    public String simpleJsp() {
        return "/jsp";
    }

    @RequestMapping("/ftl")
    public String simpleFtl() {
        return "/hello";
    }
}
