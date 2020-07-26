package io.github.yehongzhi.rabbitmqconsumer.demo;

import io.github.yehongzhi.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name RabbitDemoConsumer
 * @date 2020-07-21 23:42
 **/
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC))
public class RabbitDemoConsumer {

    @RabbitHandler
    public void process(Map map) {
        System.out.println("消费者RabbitDemoConsumer从RabbitMQ服务端消费消息：" + map.toString());
    }
}
