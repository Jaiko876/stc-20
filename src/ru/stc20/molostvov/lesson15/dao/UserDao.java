package ru.stc20.molostvov.lesson15.dao;

import ru.stc20.molostvov.lesson15.dto.User;

public interface UserDao {
    void addNewUser(User user);
    void addUsers(User[] users);
    User getUser(Integer id, String name);
    void updateUser(User user);
    void deleteUser(Integer id);
}
