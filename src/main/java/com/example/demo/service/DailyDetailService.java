package com.example.demo.service;

import java.util.List;
import java.util.Arrays; 

import org.springframework.stereotype.Service;

import com.example.demo.model.DailyDetail;
import com.example.demo.repository.DailyDetailRepository;

@Service
public class DailyDetailService {

    private final DailyDetailRepository dailyDetailRepository;

    public DailyDetailService(DailyDetailRepository DailyDetailRepository) {
        this.dailyDetailRepository = DailyDetailRepository;
    }

    public List<DailyDetail> getAllDailyDetails() {
        return dailyDetailRepository.findAll();
    }

    public DailyDetail saveDailyDetail(DailyDetail DailyDetail) {
        return dailyDetailRepository.save(DailyDetail);
    }

    public void mockData() {
        saveDailyDetail(new DailyDetail("Mock Title 1", "Mock Description 1"));
        saveDailyDetail(new DailyDetail("Mock Title 2", "Mock Description 2"));
        saveDailyDetail(new DailyDetail("Mock Title 3", "Mock Description 3"));
    }

}