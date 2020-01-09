package ru.stc20.molostvov.lesson15.connectionManagerJDBCImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.stc20.molostvov.lesson15.connectionManagerJDBC.ConnectionManagerJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJDBCImp implements ConnectionManagerJDBC {
    private static ConnectionManagerJDBC connectionManagerJDBC;
    private static final Logger logger = LogManager.getLogger(ConnectionManagerJDBCImp.class);

    private ConnectionManagerJDBCImp() {}

    private String user = "postgres";
    private String pass = "1234";

    public static  ConnectionManagerJDBC getInstance() {
        if (connectionManagerJDBC == null) {
            connectionManagerJDBC = new ConnectionManagerJDBCImp();
        }
        return connectionManagerJDBC;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/postgres", user, pass);
        } catch (SQLException e) {
            logger.error("Error", e);
        }
        return connection;
    }
}
