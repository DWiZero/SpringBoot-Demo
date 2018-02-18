package com.dwizero.Services.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQClient
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message)
    {
        rabbitTemplate.convertAndSend("test",message);
    }

    @RabbitListener(queues = "test")
    public void receive(String message)
    {
        System.out.println("receive :"+message);
    }
}
