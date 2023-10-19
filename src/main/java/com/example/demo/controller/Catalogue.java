package com.example.demo.controller;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Catalogue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogue_id")
    @SequenceGenerator(name="catalogue_id", sequenceName = "catalogue_id_seq", allocationSize=1)
    private Integer id;
    private String name;
    private Integer year;
    private String genre;
    private String description;
    private String director;
    private String actors;



}
