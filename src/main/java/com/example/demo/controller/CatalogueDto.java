package com.example.demo.controller;

public record CatalogueDto (String name,
                            Integer year,
                            String genre,
                            String description,
                            String director,
                            String actors
) {
}
