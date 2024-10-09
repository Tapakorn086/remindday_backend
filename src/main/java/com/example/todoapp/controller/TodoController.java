package com.example.todoapp.controller;

import java.time.LocalDate;
import java.util.List;

//import org.hibernate.mapping.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/gettodo")
    public ResponseEntity<List<Todo>> getTodoByDateAndDevice(
            @ModelAttribute TodoRequest request) {

        List<Todo> todos = todoService.getTodoByDateAndDevice(request.getStartDate(), request.getIdDevice());

        if (todos != null && !todos.isEmpty()) {
            return ResponseEntity.ok(todos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatetodo/{todoId}")
    public ResponseEntity<Todo> updateTodoStatus(
            @PathVariable Long todoId,
            @RequestBody TodoRequest request) {
        Todo updatedTodo = todoService.updateStatusByTodoId(todoId, request.getStatus(), request.getIdDevice());
        if (updatedTodo != null) {
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/todo/device/{idDevice}/status")
    public ResponseEntity<List<Todo>> updateTodoStatusByDevice(
            @PathVariable String idDevice,
            @RequestBody Todo statusRequest) {
        List<Todo> updatedTodos = todoService.updateStatusByDeviceId(idDevice, statusRequest.getStatus());
        if (updatedTodos != null && !updatedTodos.isEmpty()) {
            return ResponseEntity.ok(updatedTodos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   

}

class TodoRequest {

    private String status;
    private String idDevice;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}

