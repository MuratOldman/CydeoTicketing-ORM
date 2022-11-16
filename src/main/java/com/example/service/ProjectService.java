package com.example.service;

import com.example.dto.ProjectDTO;
import com.example.entity.Project;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> listAllProjects();
    ProjectDTO getByProjectCode(String code);
    void save(ProjectDTO projectDTO);
    void update(ProjectDTO projectDTO);
    void delete(String code);
    void complete(String code);

    List<ProjectDTO> listAllProjectDetails();
}
