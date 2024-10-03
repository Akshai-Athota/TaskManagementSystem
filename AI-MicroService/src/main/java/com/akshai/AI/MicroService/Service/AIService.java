package com.akshai.AI.MicroService.Service;

public interface AIService {
    String getRecommendation(String desc);
    String getPriority(String desc);
    String getDeadLine(String desc);
    String getClassification(String dec);
}
