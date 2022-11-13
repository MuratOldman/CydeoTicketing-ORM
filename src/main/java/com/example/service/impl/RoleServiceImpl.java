package com.example.service.impl;

import com.example.dto.RoleDTO;
import com.example.entity.Role;
import com.example.mapper.RoleMapper;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        return roleRepository.findAll().stream().map(roleMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {
     return   roleMapper.convertToDTO(roleRepository.findById(id).get());
    }
}
