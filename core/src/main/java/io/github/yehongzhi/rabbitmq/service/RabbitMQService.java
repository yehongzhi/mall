package io.github.yehongzhi.rabbitmq.service;

import java.util.Map;

/**
 * @author Ye Hongzhi 公众号：java技术爱好者
 * @name RabbitMQService
 * @date 2020-07-21 23:32
 **/
public interface RabbitMQService {

    String sendMsg(String msg) throws Exception;

    String sendMsgByFanoutExchange(String msg) throws Exception;

    String sendMsgByTopicExchange(String msg, String routingKey) throws Exception;

    String sendMsgByHeadersExchange(String msg, Map<String, Object> map) throws Exception;
}
