package com.darsh.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darsh.demo.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);
    List<User> findAll();
}
