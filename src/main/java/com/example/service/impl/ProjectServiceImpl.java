package com.example.service.impl;

import com.example.dto.ProjectDTO;
import com.example.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Override
    public List<ProjectDTO> listAllProjects() {
        return null;
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {
        return null;
    }

    @Override
    public void save(ProjectDTO projectDTO) {

    }

    @Override
    public void update(ProjectDTO projectDTO) {

    }

    @Override
    public void delete(String code) {

    }
}
