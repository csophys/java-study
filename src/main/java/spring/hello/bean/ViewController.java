package spring.hello.bean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by csophys on 15/12/20.
 */
@Controller
@RequestMapping("/view")
@SessionAttributes("model")
public class ViewController {

    @RequestMapping("/html")
    public String simpleHtml() {
        return "/normalTest";
    }

    @RequestMapping("/jsp")
    public String simpleJsp() {
        return "/jsp";
    }

    @ModelAttribute

    public Model model(@RequestParam(value = "param", defaultValue = "param") String param) {
        return new Model(param, "女");
    }

    @RequestMapping(value = "/ftl")
    public String simpleFtl(@ModelAttribute("model") Model model, ModelMap modelMap) {
        model.setSex("男");
        modelMap.addAttribute("model1", new Model("csophys", "男"));
        return "/hello";
    }

}
