package ru.dsolo.dao;

import ru.dsolo.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(long id);
    List<User> getUserList(int count);
    void deleteUser(long id);
    void addUser(User user);
    void updateUser(User user);
}
