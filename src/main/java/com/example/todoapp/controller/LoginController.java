package com.example.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.model.Login;
import com.example.todoapp.service.LoginService;

@RestController
@RequestMapping("/api/register")
public class LoginController {

    private final LoginService loginservice;

    @Autowired
    public LoginController(LoginService loginservice) {
        this.loginservice = loginservice;
    }

    @PostMapping
    public Login saveRegisterData(@RequestBody Login data) {
        return loginservice.createRegister(data);
    }

}
