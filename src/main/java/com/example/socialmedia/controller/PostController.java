package com.example.socialmedia.controller;

import com.example.socialmedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/like")
    public String likePost(@RequestParam Long userId, @RequestParam Long postId) {
        postService.likePost(userId, postId);
        return "Post Liked!!";
    }

    @PostMapping("/dislike")
    public String dislikePost(@RequestParam Long userId, @RequestParam Long postId) {
        postService.dislikePost(userId, postId);
        return "Post Disliked!!";
    }

    @GetMapping("/feed")
    public List<PostDTO> showFeed(@RequestParam Long userId) {
        // Fetch posts for the user
        List<PostDTO> posts = postService.getAllPostsForUser(userId);
        
        // Sort the posts as per the required criteria: followed users first, then posts sorted by timestamp
        return posts.stream()
                    .sorted((p1, p2) -> p2.getTimestamp().compareTo(p1.getTimestamp())) // Sort by timestamp descending
                    .collect(Collectors.toList());
    }
}
