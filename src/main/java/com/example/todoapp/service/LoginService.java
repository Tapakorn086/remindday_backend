package com.example.todoapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.repository.LoginRepository;
import com.example.todoapp.model.Login;
import com.example.todoapp.model.User;
import com.example.todoapp.repository.UserRepository;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final UserRepository userRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository, UserRepository userRepository) {
        this.loginRepository = loginRepository;
        this.userRepository = userRepository;
    }

    public Login createRegister(Login data) {
        return loginRepository.save(data);
    }

    public Map<String, Object> login(String email, String password) {
        Login loginData = loginRepository.findByEmailAndPassword(email, password);
        Map<String, Object> response = new HashMap<>();

        if (loginData != null) {
            User userData = userRepository.findByLoginId(loginData.getId());
            response.put("loginId", loginData.getId());

            if (userData != null) {
                response.put("userId", userData.getId());
                response.put("hasInfo", true); 
            } else {
                response.put("hasInfo", false); 
            }
        } else {
            response.put("error", "Invalid credentials");
        }

        return response;
    }
}
