package com.yarik.kostya.storages;

import com.yarik.kostya.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class UserStorage {

    private long counterOfIds;
    private Map<Long, User> storage;

    public UserStorage() {
        this.counterOfIds = 0;
        this.storage = new HashMap<>();
    }

    private long getNextId() {
        return ++counterOfIds;
    }

    public void addUser(User user) {
        storage.put(getNextId(), user);
    }

    public Set getAllUsers() {
        return storage.entrySet();
    }

    public User getUserById(Long id) {
        return storage.get(id);
    }

    public void editUser(Long id, User editedUser) {
        storage.put(id, editedUser);
    }
}
