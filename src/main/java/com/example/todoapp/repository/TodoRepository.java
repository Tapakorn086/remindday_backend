package com.example.todoapp.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoapp.model.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByIdDevice(String idDevice);
    Optional<Todo> findByIdAndIdDevice(Long id, String idDevice);

}