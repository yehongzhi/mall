package io.github.yehongzhi.rabbitmqconsumer.service.impl;


import io.github.yehongzhi.rabbitmqconsumer.service.IRbSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RbSendServiceImpl implements IRbSendService {
    private static final Logger log = LoggerFactory.getLogger(RbSendServiceImpl.class);
    @Value("${rabbitmq.topic}")
    public String TOPIC;

    @Value("${rabbitmq.exchange}")
    public String EXCHANGE;

    @Value("${rabbitmq.routing}")
    public String ROUTING;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String msg) {
        try {
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING, msg);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
