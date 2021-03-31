package io.github.yehongzhi.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name DemoInterceptor
 * @date 2020-08-30 00:12
 **/
public class DemoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //预处理，返回true则继续执行。如果需要登录校验，校验不通过返回false即可，通过则返回true。
//        System.out.println("执行preHandle()方法");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //后处理
//        System.out.println("执行postHandle()方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //在DispatcherServlet完全处理完请求后被调用
//        System.out.println("执行afterCompletion()方法");
    }
}
