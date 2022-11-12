package com.example.service;


import com.example.dto.UserDTO;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService {
    List<UserDTO> listAllUsers();

   UserDTO findByUserName(String userName);

   void save(UserDTO userDTO);

   UserDTO update(UserDTO userDTO);

   void deleteByUserName(UserDTO userDTO);


}
