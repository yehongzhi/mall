package io.github.yehongzhi.springmvc.demo;

import io.github.yehongzhi.springmvc.exception.BaseException;
import io.github.yehongzhi.springmvc.exception.DefinedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name ExceptionController
 * @date 2020-08-30 15:09
 **/
@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/index")
    public String index(String msg) throws Exception {
        if ("null".equals(msg)) {
            //抛出空指针异常
            throw new NullPointerException();
        } else if ("defined".equals(msg)) {
            throw new DefinedException();
        }
        return "index";
    }

    @RequestMapping("/defined")
    public String defined(String msg) throws Exception {
        if ("defined".equals(msg)) {
            throw new DefinedException();
        }
        return "index";
    }

    @RequestMapping("/base")
    public String base(String msg) throws Exception {
        if ("base".equals(msg)) {
            throw new BaseException("测试抛出BaseException异常，欧耶！");
        }
        return "index";
    }
}
