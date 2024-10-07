package com.example.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todoapp.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    boolean existsByReferralCode(String referralCode);
}