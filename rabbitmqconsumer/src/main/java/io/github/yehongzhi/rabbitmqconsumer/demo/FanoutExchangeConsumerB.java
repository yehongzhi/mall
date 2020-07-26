package io.github.yehongzhi.rabbitmqconsumer.demo;

import io.github.yehongzhi.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name FanoutExchangeConsumerB
 * @date 2020-07-23 23:47
 **/
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_B))
public class FanoutExchangeConsumerB {

    @RabbitHandler
    public void process(Map<String, Object> map) {
        System.out.println("队列B收到消息：" + map.toString());
    }
}
