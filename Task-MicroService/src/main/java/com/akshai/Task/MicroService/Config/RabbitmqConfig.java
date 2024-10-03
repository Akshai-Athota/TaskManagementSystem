package com.akshai.Task.MicroService.Config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Value("${spring.rabbitmq.template.exchange}")
    private  String exchange;

    @Value("${spring.rabbitmq.template.queue}")
    private  String senderQueue;

    @Value("${spring.rabbitmq.listener.queue}")
    private String receiverQueue;

    @Value("${spring.rabbitmq.template.routing-key}")
    private  String routingKey;

    @Bean
    public Queue senderQueue(){
        return new Queue(senderQueue,true);
    }

    @Bean
    public Queue receiverQueue(){
        return new Queue(receiverQueue,true);
    }

    @Bean
    public TopicExchange exchange(){
        return  new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(Queue senderQueue, TopicExchange exchange){
        return BindingBuilder.bind(senderQueue).to(exchange).with(routingKey);
    }

    @Bean
    public MessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
