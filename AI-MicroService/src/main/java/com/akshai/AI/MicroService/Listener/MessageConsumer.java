package com.akshai.AI.MicroService.Listener;

import com.akshai.AI.MicroService.DTO.RecommendationsDTO;
import com.akshai.AI.MicroService.Service.AIService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Value("${spring.rabbitmq.template.exchange}")
    private  String exchange;

    @Value("${spring.rabbitmq.template.routing-key}")
    private  String routingKey;

    private AIService aiService;
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "${spring.rabbitmq.listener.queue}")
    public void receiveDescription(String description){
        RecommendationsDTO recommendationsDTO=new RecommendationsDTO();
        recommendationsDTO.setRecommendation(aiService.getRecommendation(description));
        recommendationsDTO.setDeadline(aiService.getDeadLine(description));
        recommendationsDTO.setClassification(aiService.getClassification(description));
        recommendationsDTO.setAiPriority(aiService.getPriority(description));

        rabbitTemplate.convertAndSend(exchange,routingKey,recommendationsDTO);
    }
}
