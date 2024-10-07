package com.example.todoapp.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private Integer age;
    private String gender;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login login;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "members")
    @JsonIgnore
    private Set<Group> groups = new HashSet<>();
    
    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
    public Set<Long> getGroupIds() {
        Set<Long> groupIds = new HashSet<>();
        for (Group group : groups) {
            groupIds.add(group.getId());
        }
        return groupIds;
    }
}
