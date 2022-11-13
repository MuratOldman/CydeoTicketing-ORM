package com.example.mapper;

import com.example.dto.ProjectDTO;
import com.example.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    private final ModelMapper modelMapper;

    public ProjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProjectDTO convertToDTO(Project project){
        return modelMapper.map(project,ProjectDTO.class);
    }

    public Project convertToProject(ProjectDTO projectDTO){
        return modelMapper.map(projectDTO,Project.class);
    }
}
