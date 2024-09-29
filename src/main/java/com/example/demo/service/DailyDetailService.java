package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.DailyDetail;
import com.example.demo.repository.DailyDetailRepository;

@Service
public class DailyDetailService {

    private final DailyDetailRepository DailyDetailRepository;

    public DailyDetailService(DailyDetailRepository DailyDetailRepository) {
        this.DailyDetailRepository = DailyDetailRepository;
    }

    public List<DailyDetail> getAllDailyDetails() {
        return DailyDetailRepository.findAll();
    }

    public DailyDetail saveDailyDetail(DailyDetail DailyDetail) {
        return DailyDetailRepository.save(DailyDetail);
    }
}
