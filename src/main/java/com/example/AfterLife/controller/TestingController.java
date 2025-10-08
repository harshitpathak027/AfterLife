package com.example.AfterLife.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.AfterLife.model.User;
import com.example.AfterLife.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;


@RestController
public class TestingController {
    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String testEndpoint() {
        return "Testing endpoint";
    }
    public static class RegisterRequest {
        public String username;
        public String password;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.username);
        user.setPassword(request.password);
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
    @GetMapping("/login")
    public String login(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.username);
        user.setPassword(request.password);
        userService.loginUser(user);
        return "Login successful";
    }
}
