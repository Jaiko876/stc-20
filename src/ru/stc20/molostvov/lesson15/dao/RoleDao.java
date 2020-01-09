package ru.stc20.molostvov.lesson15.dao;

import ru.stc20.molostvov.lesson15.entity.Role;
import ru.stc20.molostvov.lesson15.entity.User;

public interface RoleDao {
    void setRole(User user, Role role);
    void getRole(User user);
}
