package com.example.socialmedia.dto;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class PostDTO {
    private Long postId;
    private Long userId;
    private String content;
    private Date timestamp;

    public PostDTO(Long postId, Long userId, String content, Date timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters and Setters

    public String getRelativeTime() {
        Instant postInstant = timestamp.toInstant();
        Instant now = Instant.now();
        Duration duration = Duration.between(postInstant, now);

        long seconds = duration.getSeconds();
        if (seconds < 60) {
            return seconds + "s ago";
        } else if (seconds < 3600) {
            long minutes = seconds / 60;
            return minutes + "m ago";
        } else if (seconds < 86400) {
            long hours = seconds / 3600;
            return hours + " hr ago";
        } else {
            long days = seconds / 86400;
            return days + "d ago";
        }
    }
}
