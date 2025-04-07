package com.leonardburgos.spring_console_app.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, Object> usersMap = new HashMap<>();

    public Object addUser(String username, Object user) {
        return usersMap.put(username, user);
    }

    public Object getUser(String username) {
        return usersMap.get(username);
    }

}
