package com.example.todoapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.model.Login;
import com.example.todoapp.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginservice;

    @Autowired
    public LoginController(LoginService loginservice) {
        this.loginservice = loginservice;
    }

    @PostMapping("/registerlogin")
    public Login saveRegisterData(@RequestBody Login data) {
        return loginservice.createRegister(data);
    }

    @PostMapping("/sessionlogin")
    public ResponseEntity<Map<String, Object>> findLoginData(@RequestBody Login data) {
        Map<String, Object> response = loginservice.login(data.getEmail(), data.getPassword());
        
        if (response.containsKey("loginId")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}