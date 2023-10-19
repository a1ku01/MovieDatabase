package com.example.demo.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CatalogueRepository extends CrudRepository <Catalogue, Integer> {

    @Query(value = "select * from catalogue", nativeQuery = true)
    List<Catalogue> getAll();

}
