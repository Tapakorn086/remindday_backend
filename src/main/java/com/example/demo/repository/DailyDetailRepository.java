package com.example.demo.repository;

import com.example.demo.model.DailyDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyDetailRepository extends JpaRepository<DailyDetail, Long> {
}
