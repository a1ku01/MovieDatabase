package com.example.demo.controller;

import org.hibernate.annotations.Comments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    @Query(value = "select * from comments", nativeQuery = true)
    List<Comment> getAll();
}
