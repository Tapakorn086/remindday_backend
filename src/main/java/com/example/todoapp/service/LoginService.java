package com.example.todoapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.repository.LoginRepository;
import com.example.todoapp.model.Login;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Login createRegister(Login data) {
        return loginRepository.save(data);
    }

    public Map<String, Object> login(String email, String password) {
        Login user = loginRepository.findByEmailAndPassword(email, password);
        Map<String, Object> response = new HashMap<>();

        if (user != null) {
            response.put("loginId", user.getId());
        } else {
            response.put("error", "Invalid credentials");
        }

        return response;
    }
}
    