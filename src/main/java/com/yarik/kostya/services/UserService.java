package com.yarik.kostya.services;

import com.yarik.kostya.model.User;
import com.yarik.kostya.storages.UserStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserStorage userStorage;

    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void createUser(String name) {
        userStorage.addUser(new User(name));
    }

    public User getUserById(long id) {
        return userStorage.getUserById(id);
    }

    public Set getAllFullUsers() {
        return userStorage.getAllUsers();
    }
}
