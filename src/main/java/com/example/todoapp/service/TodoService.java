package com.example.todoapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public List<Todo> getTodoByDateAndDevice(LocalDate startDate, String idDevice) {
        return todoRepository.findByIdDeviceAndStartDateGreaterThanEqual(idDevice, startDate);
    }
    public Todo updateStatusByTodoId(Long id, String status, String idDevice) {
        Optional<Todo> todoOptional = todoRepository.findByIdAndIdDevice(id, idDevice);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setStatus(status);
            return todoRepository.save(todo);
        }
        return null;
    }

    public List<Todo> updateStatusByDeviceId(String idDevice, String status) {
        List<Todo> todos = todoRepository.findByIdDevice(idDevice);
        for (Todo todo : todos) {
            todo.setStatus(status);
        }
        return todoRepository.saveAll(todos);
    }
    
    
}
