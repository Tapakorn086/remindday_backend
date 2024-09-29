package com.example.demo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.DailyDetail;
import com.example.demo.service.DailyDetailService;

@RestController
@RequestMapping("/api/DailyDetails")
public class DailyDetailController {

    private final DailyDetailService DailyDetailService;

    public DailyDetailController(DailyDetailService DailyDetailService) {
        this.DailyDetailService = DailyDetailService;
    }

    @GetMapping
    public List<DailyDetail> getAllDailyDetails() {
        return DailyDetailService.getAllDailyDetails();
    }

    @PostMapping
    public DailyDetail saveDailyDetail(@RequestBody DailyDetail DailyDetail) {
        return DailyDetailService.saveDailyDetail(DailyDetail);
    }
}
