package com.DWiZero.Services.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class RabbitMQConsumer
{
    @RabbitListener(queues = "hello")
    public void receiveTest(String message)
    {
        System.out.println("hello :" + message);
    }

    @RabbitListener(queues = "topic.message")
    public void receiveTopicMessage(String message)
    {
        System.out.println("topic.message :" + message);
    }

    @RabbitListener(queues = "fanout.A")
    public void receiveFanoutA(String message)
    {
        System.out.println("FanoutA :" + message);
    }

    @RabbitListener(queues = "fanout.B")
    public void receiveFanoutB(String message)
    {
        System.out.println("FanoutB :" + message);
    }

    @RabbitListener(queues = "fanout.C")
    public void receiveFanoutC(String message)
    {
        System.out.println("FanoutC :" + message);
    }
}
