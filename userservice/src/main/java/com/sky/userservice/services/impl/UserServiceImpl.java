package com.sky.userservice.services.impl;

import com.sky.userservice.entities.Hotel;
import com.sky.userservice.entities.Rating;
import com.sky.userservice.entities.User;
import com.sky.userservice.exceptions.ResourceNotFoundExcetion;
import com.sky.userservice.repositories.UserRepository;
import com.sky.userservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


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

        Rating[] ratingforObject = restTemplate.getForObject("http://localhost:8091/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{} ",ratingforObject);

        List<Rating> ratings = Arrays.stream(ratingforObject).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8090/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();

            logger.info("response status code: {} ",forEntity.getStatusCode());

            rating.setHotel(hotel);
            return rating;

        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
