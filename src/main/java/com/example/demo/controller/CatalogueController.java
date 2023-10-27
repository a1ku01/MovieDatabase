package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CatalogueController {

    private final CatalogueRepository catalogueRepository;

    @GetMapping(path = "/api/catalogue")
    public List <CatalogueDto>  getFullCatalogue() {
        return catalogueRepository.getAll().stream()
                .map(CatalogueMapper.INSTANCE::toCatalogueDto)
                .toList();
    }

}
