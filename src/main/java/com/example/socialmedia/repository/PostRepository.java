package com.example.socialmedia.repository;

import com.example.socialmedia.model.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository {

    private Map<Long, Post> postMap = new HashMap<>();

    public Post save(Post post) {
        postMap.put(post.getPostId(), post);
        return post;
    }

    public Post findById(Long postId) {
        return postMap.get(postId);
    }

    public Map<Long, Post> getPostMap() {
        return postMap;
    }
}
