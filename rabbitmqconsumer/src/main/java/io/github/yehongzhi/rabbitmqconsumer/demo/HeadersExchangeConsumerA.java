package io.github.yehongzhi.rabbitmqconsumer.demo;

import io.github.yehongzhi.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name HeadersExchangeConsumerA
 * @date 2020-07-24 23:03
 **/
@Component
public class HeadersExchangeConsumerA {

    @RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_A))
    public void process(Message message) throws Exception {
        MessageProperties messageProperties = message.getMessageProperties();
        String contentType = messageProperties.getContentType();
        System.out.println("队列[" + RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_A + "]收到消息：" + new String(message.getBody(), contentType));
    }
}
