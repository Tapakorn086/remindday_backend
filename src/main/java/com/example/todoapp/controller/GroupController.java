package com.example.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/getGroupByUserId/{userId}")
    public ResponseEntity<List<Group>> getGroupDataByUserId(@PathVariable Long userId) {
        List<Group> groups = groupservice.findGroupsByUserId(userId);
        return ResponseEntity.ok(groups);
    }
    @PostMapping("/joinGroup")
    public ResponseEntity<?> joinGroup(@RequestBody JoinGroupRequest request) {
        try {
            groupservice.joinGroup(request.getReferralCode(), request.getUserId());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to join group: " + e.getMessage());
        }
    }
}

class JoinGroupRequest {
    private String referralCode;
    private Long userId;

    // Getters and setters

    public String getReferralCode(){
        return referralCode;
    }

    public Long getUserId() {
        return userId;
    }
}