package com.rumahorbo.ssl.repository;

import com.rumahorbo.ssl.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public int save(User user) {
        this.userList.add(user);
        return userList.indexOf(user);
    }

    public User findByName(String name) {
        return this.userList.stream()
                .filter(user -> name.equals(user.name()))
                .findFirst()
                .orElse(null);
    }
}
