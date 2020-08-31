package io.github.yehongzhi.springmvc.demo;

import io.github.yehongzhi.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name ModelAttributeController
 * @date 2020-08-29 22:58
 **/
@Controller
@RequestMapping("/modelAttribute")
public class ModelAttributeController {

    @ModelAttribute
    public void modelAttribute(Model model) {
        model.addAttribute("userName", "公众号：java技术爱好者");
    }

    @ModelAttribute("u")
    public User userAttribute() {
        return new User("1", "Java技术爱好者", 18);
    }

    @RequestMapping("/java")
    public String user1(@ModelAttribute("u") User user) {
        //拿到@ModelAttribute("u")方法返回的值，打印出来
        System.out.println("user:" + user);
        return "java";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }


    @RequestMapping("/jojo")
    @ModelAttribute("attributeName")
    public String jojo() {
        return "JOJO！我不做人了！";
    }
}
