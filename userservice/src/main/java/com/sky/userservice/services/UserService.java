package com.sky.userservice.services;

import com.sky.userservice.entities.User;

import java.util.List;

public interface UserService {

    //create user
    User saveUser(User user);

    //get all user
    List<User> getAllUser();


    //get single user of given id
    User getUser(String userId);

    //delete


    //update

}
