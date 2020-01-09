package ru.stc20.molostvov.lesson15.dao;

import ru.stc20.molostvov.lesson15.dto.Role;
import ru.stc20.molostvov.lesson15.dto.User;

public interface RoleDao {
    void setRole(User user, Role role);
    void getRole(User user);
}
