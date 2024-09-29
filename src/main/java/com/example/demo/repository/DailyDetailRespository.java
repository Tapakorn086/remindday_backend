package com.example.demo.repository;

import com.example.demo.model.database;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyDetailRespository extends JpaRepository<DailyDetail, Long> {
}
