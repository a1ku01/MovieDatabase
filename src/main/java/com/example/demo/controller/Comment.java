package com.example.demo.controller;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id")
    @SequenceGenerator(name="comment_id", sequenceName = "comment_id_seq", allocationSize=1)
    private Long id;
    private Long catalogueId;
    private String comment;

}
