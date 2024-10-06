package com.example.todoapp.controller;

import java.util.List;
import java.util.Optional;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    // API สำหรับดึงรายการ Todo ทั้งหมด
    @GetMapping("/gettodo")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();// GetTodoService
    }

    // API สำหรับดึงรายการ Todo โดย ID
    @GetMapping("/gettodo/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        // API สำหรับค้นหา Todo ตามชื่อเรื่อง
    @GetMapping("/gettodosByTitle")
    public List<Todo> getTodosByTitle(@RequestParam String title) {
        return todoService.getTodosByTitle(title);
        //GET /api/todosByTitle?title=ชื่อเรื่องที่ต้องการค้นหา
        // {
        //     "id": 1,
        //     "title": "Learn Java",
        //     "description": "Study Java programming.",
        //     "type": "Education",
        //     "importance": "High",
        //     "startDate": "2024-10-01",
        //     "startTime": "09:00",
        //     "notifyMinutesBefore": 30,
        //     "status": "Pending",
        //     "group": null,  // หรือมีข้อมูลของ Group ถ้ามีการเชื่อมโยง
        //     "user": null    // หรือมีข้อมูลของ User ถ้ามีการเชื่อมโยง
        // }
    }

}
