package com.example.socialmedia.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Post {
    private Long postId;
    private Long userId;
    private String content;
    private Date timestamp;
    private Set<Long> likes = new HashSet<>();
    private Set<Long> dislikes = new HashSet<>();

    public Post(Long postId, Long userId, String content, Date timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters and Setters
}
