package com.example.service;

import com.example.dto.RoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleService  {

    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id);
}
