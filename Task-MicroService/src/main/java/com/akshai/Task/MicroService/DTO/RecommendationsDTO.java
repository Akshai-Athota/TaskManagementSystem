package com.akshai.Task.MicroService.DTO;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class RecommendationsDTO {
    private String recommendation;
    private String deadline;
    private String classification;
    private String aiPriority;
}
