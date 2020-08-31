package io.github.yehongzhi.springmvc.demo;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name DemoController
 * @date 2020-08-25 22:28
 **/
@org.springframework.stereotype.Controller("/demo/controller")
public class DemoController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //业务处理
        return null;
    }
}
