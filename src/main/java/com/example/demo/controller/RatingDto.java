package com.example.demo.controller;

public record RatingDto (
        Integer id,
        Integer catalogueId,
        Float rating
) {

}
