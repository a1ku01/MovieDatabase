package com.example.demo.controller;
import jakarta.persistence.Column;

public record UserDto (Long id,
                      String userNickname,
                      String userEmail,
                      String userPassword )


{

}
