package com.example.demo.controller;
import jakarta.persistence.*;
import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userdata")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String usernickname;
    @Column(nullable = false, unique = true)
    private String useremail;
    @Column(nullable = false)
    private String userpassword;
}
