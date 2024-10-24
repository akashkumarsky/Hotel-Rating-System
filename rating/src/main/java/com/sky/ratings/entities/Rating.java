package com.sky.ratings.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_rating")
public class Rating {
    @Id
    private String ratingId;
    private String hotelId;
    private String userId;
    private int rating;
    private String feedback;


}
