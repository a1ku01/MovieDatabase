package com.example.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class RatingController {

    private final RatingRepository ratingRepository;

   /*@GetMapping("movies/{movieId}/rating")
    public List<RatingDto> getAllRatings(@PathVariable String movieId) {
        return ratingRepository.getAll().stream()
                .map(RatingMapper.INSTANCE::toRatingDto)
                .toList();
    }*/
   @GetMapping("movies/{movieId}/rating")
   public BigDecimal getRatingSum(@PathVariable Long movieId) {
       return ratingRepository.getAverageRating(movieId);
   }

    @PostMapping("movies/{movieId}/rating")
    public RatingDto createRating(
            @PathVariable("movieId") Long catalogueId,
            @RequestBody @Valid CreateRatingDto createRatingDto
    ) {
        Rating rating = RatingMapper.INSTANCE.toRating(createRatingDto);
        rating.setCatalogueId(catalogueId);
        System.out.println(rating);
        Rating savedRating = ratingRepository.save(rating);
        System.out.println(savedRating);
        return RatingMapper.INSTANCE.toRatingDto(savedRating);
    }
}

