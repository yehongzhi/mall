package io.github.yehongzhi.springmvc.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name PayListener
 * @date 2020-12-13 20:28
 **/
@Component
public class PayListener implements ApplicationListener<PayApplicationEvent> {

    @Override
    public void onApplicationEvent(PayApplicationEvent event) {
        String message = event.getMessage();
        System.out.println("监听到PayApplicationEvent事件，消息为：" + message);
    }
}
