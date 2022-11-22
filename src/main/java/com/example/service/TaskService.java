package com.example.service;

import com.example.dto.ProjectDTO;
import com.example.dto.TaskDTO;
import com.example.entity.User;
import com.example.enums.Status;

import java.util.List;

public interface TaskService {

    List<TaskDTO> listAllTasks();

    TaskDTO findById(Long id);

    void save(TaskDTO taskDTO);
    void update(TaskDTO taskDTO);
    void delete(Long id);

    int totalNonCompletedTask(String projectCode);
    int totalCompletedTask(String projectCode);

    void deleteByProject(ProjectDTO projectDTO);

    void completeByProject(ProjectDTO projectDTO);
    List<TaskDTO> listAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDTO task);

    List<TaskDTO> listAllTasksByStatus(Status status);

    List<TaskDTO> readAllByAssignedEmployee(User assignedEmployee);


}
