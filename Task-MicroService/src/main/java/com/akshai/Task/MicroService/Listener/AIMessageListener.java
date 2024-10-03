package com.akshai.Task.MicroService.Listener;

import com.akshai.Task.MicroService.DTO.RecommendationsDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class AIMessageListener {

    private RecommendationsDTO recommendationsDTO = new RecommendationsDTO();

    @RabbitListener(queues = "${spring.rabbitmq.listener.queue}")
    public void aiRecommendationListener(RecommendationsDTO recommendationsDTO){
        this.recommendationsDTO=recommendationsDTO;
    }

    public RecommendationsDTO getAISuggestions(){
        return this.recommendationsDTO;
    }
}
