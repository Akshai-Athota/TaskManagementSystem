package com.akshai.Task.MicroService.Service;

import com.akshai.Task.MicroService.DTO.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO updateTaskById(Long id,TaskDTO taskDTO);
    TaskDTO getTaskById(Long id);
    void deleteTaskById(Long id);
    List<TaskDTO> getAllTasks();
}
