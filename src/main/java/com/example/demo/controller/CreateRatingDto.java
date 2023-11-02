package com.example.demo.controller;

public record CreateRatingDto (
        Integer id,
        Integer catalogueId,
        Float rating
) {

}
