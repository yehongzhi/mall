package io.github.yehongzhi.rabbitmqconsumer.demo;

import io.github.yehongzhi.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name TopicExchangeConsumerA
 * @date 2020-07-24 00:58
 **/
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_B))
public class TopicExchangeConsumerB {

    @RabbitHandler
    public void process(Map<String, Object> map) {
        System.out.println("队列[" + RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_B+ "]收到消息：" + map.toString());
    }
}
