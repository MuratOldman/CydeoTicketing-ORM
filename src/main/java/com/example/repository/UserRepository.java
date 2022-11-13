package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);
    @Transactional
    void deleteByUserName(String userName);

}
