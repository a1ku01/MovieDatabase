package com.example.demo.controller;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUseremail(String email);
}
