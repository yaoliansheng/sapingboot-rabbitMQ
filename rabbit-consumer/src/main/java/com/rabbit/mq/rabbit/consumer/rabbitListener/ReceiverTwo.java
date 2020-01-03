package com.rabbit.mq.rabbit.consumer.rabbitListener;

import com.rabbit.mq.rabbit.consumer.constants.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = Constants.queueNameTwo)
public class ReceiverTwo {

    @RabbitHandler
    public void process(String message) {
        System.out.println("ReceiverTwo : " + message);
        System.out.println("接收成功 TWO");
    }


    @RabbitHandler
    public void process(Map map) {
        System.out.println("Receiver : " + map.toString());
//        User user = JSON.parseObject(message, User.class);
//        userService.insertSelective(user);
        System.out.println("接收成功 two map");
    }
}