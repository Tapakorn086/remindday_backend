package com.example.todoapp.controller;

import java.util.List;
import java.util.Optional;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;
//import com.example.todoapp.service.GetTodoService;

@RestController
@RequestMapping("/api")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/addTodo")
    public Todo saveTodoData(@RequestBody Todo data) {
        return todoService.createTodo(data);
    }

    @GetMapping("/gettodo/{idDevice}")
    public ResponseEntity<List<Todo>> getTodoByIdDevice(@PathVariable String idDevice) {
        List<Todo> todo = todoService.getTodoByIdDevices(idDevice);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatetodo/{todoId}")
    public ResponseEntity<Todo> updateTodoStatus(
            @PathVariable Long todoId,
            @RequestBody UpdateTodoRequest request) {
        Todo updatedTodo = todoService.updateStatusByTodoId(todoId, request.getStatus(), request.getIdDevice());
        if (updatedTodo != null) {
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

class UpdateTodoRequest {
    private String status;
    private String idDevice;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(String idDevice) {
        this.idDevice = idDevice;
    }
}