package com.example.repository;

import com.example.entity.Role;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);

    void deleteByUserName(String userName);

    List<User> findAllByRoleDescriptionIgnoreCase(String description);

}
