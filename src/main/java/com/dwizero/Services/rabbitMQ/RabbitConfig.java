package com.dwizero.Services.rabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Qualifier("{声明的bean}")选择要注入的指定名称的bean
 */
@Configuration
public class RabbitConfig {

    /**
     * 队列配置
     * @return
     */
    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

    /**
     * 队列topic配置
     * @return
     */
    @Bean
    public Queue queueMessage() {
        return new Queue( "topic.message");
    }
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }
    @Bean
    Binding bindingExchangeMessage(@Qualifier("queueMessage" ) Queue queueMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
    }
    /**
     * 队列Fanout配置
     * @return
     */
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}
