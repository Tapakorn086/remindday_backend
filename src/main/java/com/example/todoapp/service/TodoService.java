package com.example.todoapp.service;

//import org.apache.el.stream.Optional;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todoapp.repository.TodoRepository;
//import com.example.todoapp.model.Login;
import com.example.todoapp.model.Todo;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    // ฟังก์ชันสำหรับสร้าง Todo ใหม่
    public Todo createTodo(Todo data) {
        return todoRepository.save(data);
    }


        // ฟังก์ชันสำหรับดึงรายการทั้งหมด
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // ฟังก์ชันสำหรับดึงรายการ Todo โดย ID
    public Todo getTodoById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.orElse(null);
    }
      // ค้นหารายการ Todo โดยชื่อเรื่อง
      public List<Todo> getTodosByTitle(String title) {
        return todoRepository.findByTitle(title);
    }
}
