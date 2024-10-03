package com.akshai.AI.MicroService.Service.Impl;

import com.akshai.AI.MicroService.Service.AIService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AIServiceImpl implements AIService {

    private OpenAiChatModel openAiChatModel;

    @Override
    public String getRecommendation(String desc) {
        ChatResponse response=openAiChatModel.call(new Prompt("Provide task optimizations for: " + desc));
        return response.getResult().toString();
    }

    @Override
    public String getPriority(String desc) {
        ChatResponse response=openAiChatModel.call(new Prompt("Prioritize the following task: " + desc));
        return response.getResult().toString();
    }

    @Override
    public String getDeadLine(String desc) {
        ChatResponse response=openAiChatModel.call(new Prompt("Suggest a reasonable deadline for this task: " + desc));
        return response.getResult().toString();
    }

    @Override
    public String getClassification(String desc) {
        ChatResponse response=openAiChatModel.call(new Prompt("Classify the task based on the description: " + desc));
        return response.getResult().toString();
    }
}
