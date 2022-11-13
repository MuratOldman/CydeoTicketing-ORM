package com.example.service.impl;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
      return   userRepository.findAll().stream().map(userMapper::convertToUserDTO).collect(Collectors.toList());

    }

    @Override
    public UserDTO findByUserName(String userName) {
        return userMapper.convertToUserDTO(userRepository.findByUserName(userName));
    }

    @Override
    public void save(UserDTO userDTO) {
         userRepository.save( userMapper.convertToUser(userDTO));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {

        Long id = userRepository.findByUserName(userDTO.getUserName()).getId();
        User updatedUser= userMapper.convertToUser(userDTO);
        updatedUser.setId(id);
        userRepository.save(updatedUser);
        return userMapper.convertToUserDTO(updatedUser) ;
    }

    @Override
    public void deleteByUserName(String userName) {
        userRepository.deleteByUserName(userName);
    }

    @Override
    public void delete(String userName) {
        // I am not trying to delete anything
        // I just need to change flag and keep data in database
        User user = userRepository.findByUserName(userName);
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> listAllByRole(String role) {
        List<User> list = userRepository.findAllByRoleDescriptionIgnoreCase(role);
      return   list.stream().map(userMapper::convertToUserDTO).collect(Collectors.toList());
    }
}
