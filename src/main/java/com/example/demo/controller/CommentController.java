package com.example.demo.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
// @RequestMapping = http://localhost:8080
// rakendus jookseb veebiserveris
// veebiserveri aadress on http://localhost:8080
// http://localhost:8080 - sellel aadressil asuvad kõik teenused
// VEEBISERVERI_AADRESS/@REQUESTMAPPING/@GETMAPPING
// VEEBISERVERI_AADRESS/@REQUESTMAPPING/@POSTMAPPING

// @RequestMapping("api") = http://localhost:8080/api
//      @GetMapping("comments") = http://localhost:8080/api/comments = loe ja tagasta kõik kommentaarid
//      @GetMapping("comments/{commentId}") = http://localhost:8080/api/comments/1
//      @PostMapping("comments") = http://localhost:8080/api/comments

// MovieController
    // @RequestMapping("api/movies")
        // @GetMapping = http://localhost:8080/api/movies - loe ja tagasta kõik filmid
        // @GetMapping("{uuid"}) = http://localhost:8080/api/movies/5 - loe ja tagasta movie id 5 andmed
// CommentController
    // @RequestMapping("api/movies/{movieId}")
        // @PostMapping("comments") = http://localhost:8080/api/movies/5/comments - kommentaari lisamise teenus
        // frondis - fetch("/api/movies/5/comments, POST, commenti sisu)

// Filmi leht = frontend rakendus = http://localhost:5173/movies
// frontendis on router (router/index.js)
//  "/" -> Home component
@RequestMapping("api")
public class CommentController {

    private final CommentRepository commentRepository;

    @GetMapping("movies/{movieId}/comments")
    public List <CommentDto>  getAllComments() {
        return commentRepository.getAll().stream()
                .map(CommentMapper.INSTANCE::toCommentDto)
                .toList();
    }

    @PostMapping("movies/{movieId}/comments")
        public CommentDto createComment(
                @PathVariable("movieId") Long catalogueId,
                @RequestBody @Valid CreateCommentDto createCommentDto
    ) {
        Comment comment = CommentMapper.INSTANCE.toComment(createCommentDto);
        comment.setCatalogueId(catalogueId);
        System.out.println(comment);
        // create / save new comment
        Comment savedComment = commentRepository.save(comment);
        // return dto object from new comment as json
        return CommentMapper.INSTANCE.toCommentDto(savedComment);
    }
}
