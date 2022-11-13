package com.example.mapper;

import com.example.dto.UserDTO;
import com.example.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO convertToUserDTO(User user){

        return modelMapper.map(user, UserDTO.class);
    }

    public User convertToUser(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }
}
