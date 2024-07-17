package com.blog.DAO;

import com.blog.model.User;

import java.util.List;

public interface UserDAO {
    int addUser(User user);
    User getUser(int userId);
    User getUserByEmail(String email);
    void updateUser(User user);
    void deleteUser(int userId);
    List<User> getAllUsers();
}
