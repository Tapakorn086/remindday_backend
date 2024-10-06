package com.example.todoapp.repository;
import java.util.List;
//import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todoapp.model.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // ค้นหา Todo ทั้งหมดตาม title
    List<Todo> findByTitle(String title);

}