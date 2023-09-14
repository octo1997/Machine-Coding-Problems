package com.manager;

import com.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static final UserManager instance = new UserManager();
    private UserManager(){}
    public static UserManager getInstance() {
        return instance;
    }

    private final Map<String, User> userMap = new HashMap();

    public void addUser(String id, String name, String email, String mob){
        synchronized (userMap){
            userMap.put(id, new User.UserBuilder().addId(id).addName(name).addEmail(email).addMob(mob).get());
        }

    }

    public User getUser(String userId){
        return userMap.get(userId);
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }
}
