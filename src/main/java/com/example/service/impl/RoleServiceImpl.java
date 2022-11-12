package com.example.service.impl;

import com.example.dto.RoleDTO;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        return null;
    }

    @Override
    public RoleDTO findById(Long id) {
        return null;
    }
}
