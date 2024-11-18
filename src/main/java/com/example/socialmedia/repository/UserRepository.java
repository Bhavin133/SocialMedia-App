package com.example.socialmedia.repository;

import com.example.socialmedia.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private Map<Long, User> userMap = new HashMap<>();

    public User save(User user) {
        userMap.put(user.getUserId(), user);
        return user;
    }

    public User findById(Long userId) {
        return userMap.get(userId);
    }

    public Map<Long, User> getUserMap() {
        return userMap;
    }
}
