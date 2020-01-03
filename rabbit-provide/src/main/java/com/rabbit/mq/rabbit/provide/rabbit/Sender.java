package com.rabbit.mq.rabbit.provide.rabbit;

import com.rabbit.mq.rabbit.provide.constants.Constants;
import org.apache.logging.log4j.util.StringMap;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 给指定队列发消息
     * @param message
     */
    public void send(String message) {
        this.rabbitTemplate.convertAndSend(Constants.queueName, message);
    }

    /**
     *
     * @param queueName 队列名称
     * @param message 信息
     */
    public void send(String queueName,String message) {
        this.rabbitTemplate.convertAndSend(queueName, message);
    }

    /**
     *
     * @param map 信息
     */
    public void send(Map map) {
        this.rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting",map);
    }

    /**
     *
     * @param directExchange 交易机名称
     * @param routingKey
     * @param map
     */
    public void send(String directExchange,String routingKey,Map map) {
        this.rabbitTemplate.convertAndSend(directExchange, routingKey,map);
    }


}