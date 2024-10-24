package com.sky.ratings.service.impl;

import com.sky.ratings.entities.Rating;
import com.sky.ratings.repositories.RatingRepository;
import com.sky.ratings.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
