package com.example.todoapp.service;

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
}