package com.example.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.model.Login;
import com.example.todoapp.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginservice;

    @Autowired
    public LoginController(LoginService loginservice) {
        this.loginservice = loginservice;
    }

    @PostMapping("/register")
    public Login saveRegisterData(@RequestBody Login data) {
        return loginservice.createRegister(data);
    }

    @GetMapping("/login")
    public Login findLoginData(@RequestParam String email, @RequestParam String password) {
        return loginservice.findByEmailAndPassword(email, password);
    }

}
