package io.github.yehongzhi.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name DefinedException
 * @date 2020-08-30 15:28
 **/
//HttpStatus枚举有所有的状态码，这里返回一个400的响应码
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DefinedException extends Exception{
}
