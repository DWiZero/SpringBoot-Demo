package com.dwizero.Services.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProductor
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send()
    {
        String context = "hi,message";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("hello",context);
    }

    public void sendTopicMessage() {
        String context = "hi, topic message";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void sendFanoutMessage() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }
}
