package com.akshai.Task.MicroService.Model;

import com.akshai.Task.MicroService.DTO.RecommendationsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title",unique = true,nullable = false)
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="priority")
    private String priority;

    @Column(name="status")
    private String status;

    @Column(name="dueDate")
    private String dueDate;

    @Embedded
    private RecommendationsDTO recommendationsDTO;
}
