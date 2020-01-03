package com.rabbit.mq.rabbit.consumer.config;

import com.rabbit.mq.rabbit.consumer.constants.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue(Constants.queueName);
    }

    @Bean
    public Queue worldQueue() {
        return new Queue(Constants.queueNameTwo,true);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("TestDirectExchange");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(helloQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange twoDirectExchange() {
        return new DirectExchange("TwoDirectExchange");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirectTwo() {
        return BindingBuilder.bind(worldQueue()).to(twoDirectExchange()).with("RoutingKeyTwo");
    }
}