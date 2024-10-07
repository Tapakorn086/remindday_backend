package com.example.todoapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.model.Group;
import com.example.todoapp.service.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    private final GroupService groupservice;

    @Autowired
    public GroupController(GroupService groupservice) {
        this.groupservice = groupservice;
    }

    @PostMapping("/createGroup")
    public Group saveGroupData(@RequestBody Group data) {
        return groupservice.createGroup(data);
    }

    // @GetMapping("/getGroup")
    // public User getGroupDataByuserId(@RequestBody User data) {
    //     return groupservice.findGroupByUserId(data.getId());
    // }
}
