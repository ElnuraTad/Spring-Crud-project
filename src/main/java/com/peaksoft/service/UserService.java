package com.peaksoft.service;

import com.peaksoft.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    User getById(Integer id);

    void updateUser(User user, int id);

    void deleteUser(int id);

    User get(int id);
}
