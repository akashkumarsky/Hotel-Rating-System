package com.sky.ratings.service;

import com.sky.ratings.entities.Rating;

import java.util.List;

public interface RatingService {

    // create rating
    Rating create(Rating rating);


    //get all ratings
    List<Rating> getAllRatings();


    //get all rating by UserId
    List<Rating> getAllRatingByUserId(String userId);


    // get all rating by hotel
    List<Rating> getAllRatingByHotelId(String hotelId);

}
