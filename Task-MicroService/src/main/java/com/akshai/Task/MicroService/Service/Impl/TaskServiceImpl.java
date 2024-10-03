package com.akshai.Task.MicroService.Service.Impl;

import com.akshai.Task.MicroService.DTO.RecommendationsDTO;
import com.akshai.Task.MicroService.DTO.TaskDTO;
import com.akshai.Task.MicroService.Listener.AIMessageListener;
import com.akshai.Task.MicroService.Mapper.TaskMapper;
import com.akshai.Task.MicroService.Model.Task;
import com.akshai.Task.MicroService.Repository.TaskRepository;
import com.akshai.Task.MicroService.Service.TaskService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Value("${spring.rabbitmq.template.exchange}")
    private  String exchange;

    @Value("${spring.rabbitmq.template.routing-key}")
    private  String routingKey;


    private  TaskRepository taskRepository;
    private TaskMapper taskMapper;
    private RabbitTemplate rabbitTemplate;
    private AIMessageListener aiMessageListener;

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);

        rabbitTemplate.convertAndSend(taskDTO.getDescription());

        RecommendationsDTO recommendationsDTO = aiMessageListener.getAISuggestions();
        task.setRecommendationsDTO(recommendationsDTO);

        return taskMapper.toDTO(taskRepository.save(task));
    }

    @Override
    public TaskDTO updateTaskById(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("no task found"));
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());

        rabbitTemplate.convertAndSend(exchange,routingKey,taskDTO.getDescription());

        RecommendationsDTO recommendationsDTO = aiMessageListener.getAISuggestions();
        task.setRecommendationsDTO(recommendationsDTO);

        return taskMapper.toDTO(taskRepository.save(task));
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        return taskMapper.toDTO(taskRepository.findById(id)
                .orElseThrow(()->new RuntimeException("no task fund")));
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toDTO).collect(Collectors.toList());
    }
}
