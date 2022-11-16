package com.example.service;

import com.example.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> listAllTasks();

    TaskDTO findById(Long id);

    void save(TaskDTO taskDTO);
    void update(TaskDTO taskDTO);
    void delete(Long id);

    int totalNonCompletedTask(String projectCode);
    int totalCompletedTask(String projectCode);

}
