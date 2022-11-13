package com.example.repository;

import com.example.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project,Long> {

    Project findProjectByProjectCode(String code);

}
