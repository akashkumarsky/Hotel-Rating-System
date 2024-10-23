package com.sky.hotelService.services;

import com.sky.hotelService.entites.Hotel;

import java.util.List;

public interface HotelService {

    // crate
    Hotel create(Hotel hotel);

    // get all
    List<Hotel> getall();



    // get single
    Hotel get (String id);


}
