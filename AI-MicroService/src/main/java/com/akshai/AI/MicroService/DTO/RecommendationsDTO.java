package com.akshai.AI.MicroService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationsDTO {
    private String recommendation;
    private String deadline;
    private String classification;
    private String aiPriority;
}
