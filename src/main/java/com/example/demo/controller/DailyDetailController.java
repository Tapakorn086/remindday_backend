package com.example.demo.controller;

import com.example.demo.model.database;
import com.example.demo.service.DailyDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class DailyDetailController {

    private final DailyDetailService DailyDetailService;

    public DailyDetailController(DailyDetailService DailyDetailService) {
        this.DailyDetailService = DailyDetailService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return DailyDetailService.getAllItems();
    }

    @PostMapping
    public Item saveItem(@RequestBody Item item) {
        return DailyDetailService.saveItem(item);
    }
}
