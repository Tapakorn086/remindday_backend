package com.example.todoapp.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.repository.GroupRepository;
import com.example.todoapp.model.Group;
import com.example.todoapp.model.User;
import com.example.todoapp.repository.UserRepository;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Group createGroup(Group data) {
        if (!userRepository.existsById(data.getOwnerId())) {
            throw new RuntimeException("User with ID " + data.getOwnerId() + " does not exist.");
        }
        String referralCode = generateUniqueReferralCode();
        data.setReferralCode(referralCode);
        User owner = userRepository.findById(data.getOwnerId()).orElseThrow(() -> new RuntimeException("Owner not found"));
        Set<User> members = new HashSet<>();
        members.add(owner);
        data.setMembers(members);
        groupRepository.save(data);
        return data;
    }

    private String generateUniqueReferralCode() {
        String referralCode;
        do {
            referralCode = generateRandomNumberString(6);
        } while (isReferralCodeExists(referralCode));
        return referralCode;
    }

    private String generateRandomNumberString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private boolean isReferralCodeExists(String referralCode) {
        return groupRepository.existsByReferralCode(referralCode);
    }

}
