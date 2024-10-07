package com.example.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.model.User;
import com.example.todoapp.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
        private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User saveRegisterData(@RequestBody User data) {
        return userService.createUser(data);
    }
}
