package com.example.demo.controller;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateCommentDto(

        @NotNull (message = "Error: comment box is empty")
        @NotBlank (message = "Error: comment box is empty")
        @NotEmpty (message = "Error: comment box is empty")
        String comment
) {
}
