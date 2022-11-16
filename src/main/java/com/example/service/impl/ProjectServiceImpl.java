package com.example.service.impl;

import com.example.dto.ProjectDTO;
import com.example.dto.UserDTO;
import com.example.entity.Project;
import com.example.entity.User;
import com.example.enums.Status;
import com.example.mapper.ProjectMapper;
import com.example.mapper.UserMapper;
import com.example.repository.ProjectRepository;
import com.example.service.ProjectService;
import com.example.service.TaskService;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final UserService userService;
    private final TaskService taskService;
    private final UserMapper userMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper, UserService userService, TaskService taskService, UserMapper userMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.userService = userService;
        this.taskService = taskService;
        this.userMapper = userMapper;
    }


    @Override
    public List<ProjectDTO> listAllProjects() {
        return projectRepository.findAll().stream().map(projectMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {
        return projectMapper.convertToDTO(projectRepository.findProjectByProjectCode(code));
    }

    @Override
    public void save(ProjectDTO projectDTO) {
        projectDTO.setProjectStatus(Status.OPEN);
        projectRepository.save( projectMapper.convertToProject(projectDTO));
    }

    @Override
    public void update(ProjectDTO projectDTO) {
        Long id = projectRepository.findProjectByProjectCode(projectDTO.getProjectCode()).getId();
        Status projectStatus = projectRepository.findProjectByProjectCode(projectDTO.getProjectCode()).getProjectStatus();
        Project convertToProject = projectMapper.convertToProject(projectDTO);
        convertToProject.setId(id);
        convertToProject.setProjectStatus(projectStatus);
        projectRepository.save(convertToProject);

    }

    @Override
    public void delete(String code) {
        Project project = projectRepository.findProjectByProjectCode(code);
        project.setIsDeleted(true);
        projectRepository.save(project);
    }

    @Override
    public void complete(String code) {
        Project project = projectRepository.findProjectByProjectCode(code);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);
    }

    @Override
    public List<ProjectDTO> listAllProjectDetails() {
        UserDTO currentUserDTO = userService.findByUserName("harold@manager.com");
        User user = userMapper.convertToUser(currentUserDTO);

        List<Project> list = projectRepository.findAllByAssignedManager(user);

        return list.stream().map(project -> {

            ProjectDTO obj = projectMapper.convertToDTO(project);

            obj.setUnfinishedTaskCounts(taskService.totalNonCompletedTask(project.getProjectCode()));
            obj.setCompleteTaskCounts(taskService.totalCompletedTask(project.getProjectCode()));


            return obj;



        }).collect(Collectors.toList());
    }
}
