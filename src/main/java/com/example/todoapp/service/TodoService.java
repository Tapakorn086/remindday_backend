package com.example.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.model.Todo;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public Todo createTodo(Todo data) {
        return todoRepository.save(data);
    }

    public List<Todo> getTodoByIdDevices(String idDevice) {
        return todoRepository.findAllByIdDevice(idDevice);
   
    }
}
