package com.example.service.impl;

import com.example.dto.TaskDTO;
import com.example.entity.Task;
import com.example.enums.Status;
import com.example.mapper.TaskMapper;
import com.example.repository.TaskRepository;
import com.example.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }


    @Override
    public List<TaskDTO> listAllTasks() {
       return   taskRepository.findAll().stream().map(taskMapper::convertToTaskDTO).collect(Collectors.toList());
    }

    @Override
    public TaskDTO findById(Long id) {
       Optional<Task> optionalTaskask= taskRepository.findById(id);
       if(optionalTaskask.isPresent()){
      return taskMapper.convertToTaskDTO(optionalTaskask.get());
       }
       return null;
    }

    @Override
    public void save(TaskDTO taskDTO) {
        taskDTO.setAssignedDate(LocalDate.now());
        taskDTO.setTaskStatus(Status.OPEN);
        Task task = taskMapper.convertToTask(taskDTO);
        taskRepository.save(task);
    }

    @Override
    public void update(TaskDTO taskDTO) {
        Optional<Task> task = taskRepository.findById(taskDTO.getId());
        if(task.isPresent()){
            Task convertedTask=taskMapper.convertToTask(taskDTO);
            convertedTask.setId(task.get().getId());
            convertedTask.setAssignedDate(LocalDate.now());
           convertedTask.setTaskStatus(Status.OPEN);
            taskRepository.save(convertedTask);
        }

    }

    @Override
    public void delete(Long id) {
       Optional <Task> task= taskRepository.findById(id);
       if(task.isPresent()){
           task.get().setIsDeleted(true);
           taskRepository.save(task.get());
       }


    }

    @Override
    public int totalNonCompletedTask(String projectCode) {
       return taskRepository.totalNonCompletedTasks(projectCode);
    }

    @Override
    public int totalCompletedTask(String projectCode) {
        return taskRepository.totalCompletedTasks(projectCode);
    }
}
