package io.github.yehongzhi.springmvc.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name PayApplicationEvent
 * @date 2020-12-13 20:23
 **/
public class PayApplicationEvent extends ApplicationEvent {

    private String message;

    public PayApplicationEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
