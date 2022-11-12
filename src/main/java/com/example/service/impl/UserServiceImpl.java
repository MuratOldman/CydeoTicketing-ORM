package com.example.service.impl;

import com.example.dto.UserDTO;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDTO> listAllUsers() {
        return null;
    }

    @Override
    public UserDTO findByUserName(String userName) {
        return null;
    }

    @Override
    public void save(UserDTO userDTO) {

    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteByUserName(UserDTO userDTO) {

    }
}
