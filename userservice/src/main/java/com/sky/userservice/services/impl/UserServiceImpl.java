package com.sky.userservice.services.impl;

import com.sky.userservice.entities.Rating;
import com.sky.userservice.entities.User;
import com.sky.userservice.exceptions.ResourceNotFoundExcetion;
import com.sky.userservice.repositories.UserRepository;
import com.sky.userservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger  logger= LoggerFactory.getLogger(UserServiceImpl.class);

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
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundExcetion("User with id is not found on server !! :"+ userId ));

        ArrayList<Rating> ratingforObject = restTemplate.getForObject("http://localhost:8091/ratings/users/"+user.getUserId(), ArrayList.class);
        logger.info("{} ",ratingforObject);
        user.setRatings(ratingforObject);
        return user;
    }
}
