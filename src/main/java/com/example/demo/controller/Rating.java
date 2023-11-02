package com.example.demo.controller;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_id")
    @SequenceGenerator(name="rating_id", sequenceName = "rating_id_seq", allocationSize=1)
    private Long id;
    private Long catalogueId;
    private Float rating ;

}