package io.github.yehongzhi.springmvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name HttpDemoController
 * @date 2020-08-25 22:45
 **/
@Controller("/http/controller")
public class HttpDemoController implements HttpRequestHandler{

    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //业务处理
    }
}
