package com.akshai.AI.MicroService.Config;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    @Bean
    public OpenAiApi openAiApi(@Value("${spring.ai.openai.api-key}") String aiKey){
        return new OpenAiApi(aiKey);
    }

    @Bean
    public OpenAiChatOptions openAiChatOptions(){
        return  OpenAiChatOptions.builder()
                .withModel("gpt-3.5-turbo")
                .withMaxTokens(200)
                .withTemperature(0.4F)
                .build();
    }

    @Bean
    public OpenAiChatModel openAiChatModel(OpenAiApi openAiApi,OpenAiChatOptions openAiChatOptions){
        return new OpenAiChatModel(openAiApi,openAiChatOptions);
    }
}
