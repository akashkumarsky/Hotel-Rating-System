package com.sky.userservice.services.impl;

import com.sky.userservice.entities.User;
import com.sky.userservice.exceptions.ResourceNotFoundExcetion;
import com.sky.userservice.repositories.UserRepository;
import com.sky.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundExcetion("User with id is not found on server !! :"+ userId ));
    }
}
