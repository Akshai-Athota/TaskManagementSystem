package com.akshai.Task.MicroService.Mapper;

import com.akshai.Task.MicroService.DTO.TaskDTO;
import com.akshai.Task.MicroService.Model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
     Task toEntity(TaskDTO taskDTO);
     TaskDTO toDTO(Task task);
}
