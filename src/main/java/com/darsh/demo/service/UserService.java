package com.darsh.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.darsh.demo.model.User;

@Service
public interface UserService {
	User findByUsername(String username);

    boolean checkUserExists(String username);

    boolean checkUsernameExists(String username);
    
    User createUser(User user);
    
    User saveUser (User user); 
    
    List<User> findUserList();

    void enableUser (String username);

    void disableUser (String username);
}
