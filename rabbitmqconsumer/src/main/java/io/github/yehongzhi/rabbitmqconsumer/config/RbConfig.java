package io.github.yehongzhi.rabbitmqconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RbConfig {

    @Value("${rabbitmq.topic}")
    public String topic;

    @Value("${rabbitmq.exchange}")
    public String exchange;

    @Value("${rabbitmq.routing}")
    public String routing;

    @Value("${rabbitmq.queue.durable}")
    public boolean queueDurable;
    @Value("${rabbitmq.queue.exclusive}")
    public boolean queueExclusive;
    @Value("${rabbitmq.queue.autoDelete}")
    public boolean queueAutoDelete;
    @Value("${rabbitmq.exchange.durable}")
    public boolean exchangeDurable;
    @Value("${rabbitmq.exchange.autoDelete}")
    public boolean exchangeAutoDelete;


    @Bean
    public Queue rabbitmqDemoDirectQueue() {
        /**
         * 1、name:    队列名称
         * 2、durable: 是否持久化
         * 3、exclusive: 是否独享、排外的。如果设置为true，定义为排他队列。则只有创建者可以使用此队列。也就是private私有的。
         * 4、autoDelete: 是否自动删除。也就是临时队列。当最后一个消费者断开连接后，会自动删除。
         * */
        return new Queue(topic, queueDurable, queueExclusive, queueAutoDelete);
    }

    @Bean
    public DirectExchange rabbitmqDemoDirectExchange() {
        //Direct交换机
        return new DirectExchange(exchange, exchangeDurable, exchangeAutoDelete);
    }

    @Bean
    public Binding bindDirect() {
        //链式写法，绑定交换机和队列，并设置匹配键
        return BindingBuilder
                //绑定队列
                .bind(rabbitmqDemoDirectQueue())
                //到交换机
                .to(rabbitmqDemoDirectExchange())
                //并设置匹配键
                .with(routing);
    }

}
