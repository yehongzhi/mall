package io.github.yehongzhi.springmvc.demo;

import org.springframework.stereotype.Controller;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name ServletDemoController
 * @date 2020-08-25 22:49
 **/
@Controller("/servlet/controller")
public class ServletDemoController implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
