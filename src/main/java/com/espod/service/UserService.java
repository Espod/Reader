package com.espod.service;

import com.espod.entity.User;
import com.espod.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User findByUserID(String userID){
        return userRepository.findByUserID(userID);
    }
}
