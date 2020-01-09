package ru.stc20.molostvov.lesson15.connectionManagerJDBC;

import java.sql.Connection;

public interface ConnectionManagerJDBC {
    Connection getConnection();
}
