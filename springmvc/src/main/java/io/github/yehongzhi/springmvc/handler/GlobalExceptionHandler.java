package io.github.yehongzhi.springmvc.handler;

import io.github.yehongzhi.springmvc.exception.BaseException;
import io.github.yehongzhi.springmvc.exception.ErrorInfo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name GlobalExceptionHandler
 * @date 2020-08-30 15:57
 **/
//这里使用了RestControllerAdvice，是@ResponseBody和@ControllerAdvice的结合
//会把实体类转成JSON格式的提示返回，符合前后端分离的架构
@RestControllerAdvice
public class GlobalExceptionHandler {

    //这里自定义了一个BaseException，当抛出BaseException异常就会被此方法处理
    @ExceptionHandler(BaseException.class)
    public ErrorInfo errorHandler(HttpServletRequest req, BaseException e) throws Exception {
        ErrorInfo r = new ErrorInfo();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
