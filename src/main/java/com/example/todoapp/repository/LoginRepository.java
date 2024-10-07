package com.example.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todoapp.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByEmailAndPassword(String email, String password);

}