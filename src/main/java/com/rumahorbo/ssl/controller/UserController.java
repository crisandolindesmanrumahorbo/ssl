package com.rumahorbo.ssl.controller;

import com.rumahorbo.ssl.model.User;
import com.rumahorbo.ssl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/users")
    public int createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @GetMapping("/users")
    public ResponseEntity<User> getUserByName(@RequestParam String name) {
        User user = this.userRepository.findByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
