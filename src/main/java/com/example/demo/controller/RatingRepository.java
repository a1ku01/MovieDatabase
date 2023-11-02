package com.example.demo.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Integer> {


    @Query(value = "select round(avg(rating), 2) " +
            "from rating where catalogue_id = ?", nativeQuery = true)
    BigDecimal getAverageRating(Long movieId);

}