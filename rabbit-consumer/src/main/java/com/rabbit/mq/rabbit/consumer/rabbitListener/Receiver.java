package com.rabbit.mq.rabbit.consumer.rabbitListener;

import com.alibaba.fastjson.JSON;
import com.rabbit.mq.rabbit.consumer.constants.Constants;
import com.rabbit.mq.rabbit.consumer.entity.User;
import com.rabbit.mq.rabbit.consumer.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = Constants.queueName)
public class Receiver {

    @Autowired
    private UserService userService;

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
        User user = JSON.parseObject(message, User.class);
        userService.insertSelective(user);
        System.out.println("接收成功 ONE");
    }

    @RabbitHandler
    public void process(Map map) {
        System.out.println("Receiver : " + map.toString());
//        User user = JSON.parseObject(message, User.class);
//        userService.insertSelective(user);
        System.out.println("接收成功 ONE");
    }
}