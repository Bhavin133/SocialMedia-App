package com.example.socialmedia.service;

import com.example.socialmedia.model.Post;
import com.example.socialmedia.model.User;
import com.example.socialmedia.repository.PostRepository;
import com.example.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post uploadPost(Long userId, String content) {
        Long postId = (long) (postRepository.getPostMap().size() + 1);
        Post post = new Post(postId, userId, content, new Date());
        return postRepository.save(post);
    }

    public void likePost(Long userId, Long postId) {
        Post post = postRepository.findById(postId);
        if (post != null) {
            post.getLikes().add(userId);
            postRepository.save(post);
        }
    }

    public void dislikePost(Long userId, Long postId) {
        Post post = postRepository.findById(postId);
        if (post != null) {
            post.getDislikes().add(userId);
            postRepository.save(post);
        }
    }
}
