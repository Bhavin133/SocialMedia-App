package com.example.socialmedia.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Long userId;
    private String userName;
    private Set<Long> followers = new HashSet<>();

    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    // Getters and Setters
}
