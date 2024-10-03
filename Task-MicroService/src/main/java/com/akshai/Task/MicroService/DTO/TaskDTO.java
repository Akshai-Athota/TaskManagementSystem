package com.akshai.Task.MicroService.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    @JsonIgnore
    private Long id;

    @Size(min = 3,max=100)
    @NotNull
    @NotBlank
    @NotEmpty
    private String title;
    private String description;
    private String priority;
    private String status;
    private String dueDate;
    @Null
    private RecommendationsDTO recommendationsDTO;
}
