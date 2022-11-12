package com.example.mapper;

import com.example.dto.RoleDTO;
import com.example.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // convert to DTO
    public RoleDTO convertToDTO(Role role){
        return modelMapper.map(role,RoleDTO.class);
    }


    // convert to entity
    public Role convertToEntity(RoleDTO roleDTO){
        return modelMapper.map(roleDTO,Role.class);
    }
}
