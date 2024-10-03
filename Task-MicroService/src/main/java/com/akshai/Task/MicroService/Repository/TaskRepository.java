package com.akshai.Task.MicroService.Repository;

import com.akshai.Task.MicroService.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
