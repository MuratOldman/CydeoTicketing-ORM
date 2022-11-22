package com.example.service.impl;

import com.example.dto.ProjectDTO;
import com.example.dto.TaskDTO;
import com.example.entity.Task;
import com.example.entity.User;
import com.example.enums.Status;
import com.example.mapper.ProjectMapper;
import com.example.mapper.TaskMapper;
import com.example.repository.TaskRepository;
import com.example.repository.UserRepository;
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
    private final ProjectMapper projectMapper;

    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, ProjectMapper projectMapper, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.projectMapper = projectMapper;
        this.userRepository = userRepository;
    }


    @Override
    public List<TaskDTO> listAllTasks() {
       return   taskRepository.findAll().stream().map(taskMapper::convertToTaskDTO).collect(Collectors.toList());
    }

    @Override
    public TaskDTO findById(Long id) {
       Optional<Task> optionalTask= taskRepository.findById(id);
       if(optionalTask.isPresent()){
      return taskMapper.convertToTaskDTO(optionalTask.get());
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

    @Override
    public void deleteByProject(ProjectDTO projectDTO) {
        List<TaskDTO> list =listAllByProject(projectDTO);
        list.forEach(taskDTO -> delete(taskDTO.getId()));
    }

    private List<TaskDTO> listAllByProject(ProjectDTO projectDTO) {
        List<Task>list=taskRepository.findAllByProject(projectMapper.convertToProject(projectDTO));
        return list.stream().map(taskMapper::convertToTaskDTO).collect(Collectors.toList());
    }

    @Override
    public void completeByProject(ProjectDTO projectDTO) {
        List<TaskDTO>list=listAllByProject(projectDTO);
        list.forEach(taskDTO -> {
            taskDTO.setTaskStatus(Status.COMPLETE);
            update(taskDTO);
        });

    }

    @Override
    public List<TaskDTO> listAllTasksByStatusIsNot(Status status) {
        User loggedInUser = userRepository.findByUserName("john@employee.com");
        List<Task> list = taskRepository.findAllByTaskStatusIsNotAndAssignedEmployee(status, loggedInUser);
        return list.stream().map(taskMapper::convertToTaskDTO).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(TaskDTO dto) {

        Optional<Task> task = taskRepository.findById(dto.getId());

        if (task.isPresent()) {
            task.get().setTaskStatus(dto.getTaskStatus());
            taskRepository.save(task.get());
        }

    }

    @Override
    public List<TaskDTO> listAllTasksByStatus(Status status) {
        User loggedInUser = userRepository.findByUserName("john@employee.com");
        List<Task> list = taskRepository.findAllByTaskStatusAndAssignedEmployee(status, loggedInUser);
        return list.stream().map(taskMapper::convertToTaskDTO).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> readAllByAssignedEmployee(User assignedEmployee) {
        List<Task> list = taskRepository.findAllByAssignedEmployee(assignedEmployee);
        return list.stream().map(taskMapper::convertToTaskDTO).collect(Collectors.toList());
    }





}
