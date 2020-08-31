package io.github.yehongzhi.springmvc.demo;

import io.github.yehongzhi.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name ViewController
 * @date 2020-08-29 21:40
 **/
@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        return "hello";
    }

    @RequestMapping("/userList")
    @ResponseBody
    public List<User> userList() throws Exception {
        List<User> list = new ArrayList<>();
        list.add(new User("1","姚大秋",18));
        list.add(new User("2","李星星",18));
        list.add(new User("3","冬敏",18));
        return list;
    }
}
