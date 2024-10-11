package com.example.todoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todoapp.model.Group;
import com.example.todoapp.model.Todo;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    boolean existsByReferralCode(String referralCode);
    Group findByReferralCode(String referralCode);
    List<Group> findByMembersId(Long userId);


}