package com.example.demo.service;

import com.example.demo.model.database;
import com.example.demo.repository.DailyDetailRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyDetailService {

    private final DailyDetailRespository DailyDetailRespository;

    public ItemService(DailyDetailRespository DailyDetailRespository) {
        this.DailyDetailRespository = DailyDetailRespository;
    }

    public List<Item> getAllItems() {
        return DailyDetailRespository.findAll();
    }

    public Item saveItem(Item item) {
        return DailyDetailRespository.save(item);
    }
}
