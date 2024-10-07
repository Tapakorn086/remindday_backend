package com.example.todoapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.repository.LoginRepository;
import com.example.todoapp.repository.UserRepository;
import com.example.todoapp.model.Login;
import com.example.todoapp.model.User;

@Service
public class UserService {

    private final UserRepository userRepository;
        private final LoginRepository loginRepository;


    @Autowired
    public UserService(UserRepository userRepository, LoginRepository loginRepository) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
    }

    public User createUser(User data) {
        Optional<Login> optionalLogin = loginRepository.findById(data.getLogin().getId());

        if (optionalLogin.isPresent()) {
            Login login = optionalLogin.get();
            data.setLogin(login);
        } else {
            throw new RuntimeException("Login ID not found: " + data.getLogin().getId());
        }
        return userRepository.save(data);
    }
}
