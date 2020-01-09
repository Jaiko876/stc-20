package ru.stc20.molostvov.lesson15.daoImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.stc20.molostvov.lesson15.connectionManagerJDBCImpl.ConnectionManagerJDBCImp;
import ru.stc20.molostvov.lesson15.dao.UserDao;
import ru.stc20.molostvov.lesson15.dto.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    private static final String GET_USER_TEMPLATE = "SELECT * from lesson15.\"USER\" where id=? and name=?";
    private static final String ADD_NEW_USER_TEMPLATE = "INSERT into lesson15.\"USER\"" +
            "(name, birthday, city, email, description) values (?,?,?,?,?)";

    @Override
    public void addNewUser(User user) {
        try (Connection connection = ConnectionManagerJDBCImp.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(ADD_NEW_USER_TEMPLATE)) {
                statement.setString(1,user.getName());
                statement.setString(2,user.getBirthday());
                statement.setString(3,user.getCity());
                statement.setString(4,user.getEmail());
                statement.setString(5,user.getDescription());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            logger.error("Error", e);
        }
    }

    @Override
    public void addUsers(User[] users) {
        try (Connection connection = ConnectionManagerJDBCImp.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            Savepoint savepoint1 = connection.setSavepoint("Savepoint1");
            try (PreparedStatement statement = connection.prepareStatement(ADD_NEW_USER_TEMPLATE)) {
                for (User user: users) {
                    statement.setString(1,user.getName());
                    statement.setString(2,user.getBirthday());
                    statement.setString(3,user.getCity());
                    statement.setString(4,user.getEmail());
                    statement.setString(5,user.getDescription());
                    statement.addBatch();
                }
                statement.executeBatch();
                connection.commit();
            } catch (SQLException e) {
                logger.error("Error", e);
                connection.rollback(savepoint1);
            }
        } catch (SQLException e) {
            logger.error("Error", e);
        }

    }

    @Override
    public User getUser(Integer id, String name) {
        try(Connection connection = ConnectionManagerJDBCImp.getInstance().getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement(GET_USER_TEMPLATE)) {
                statement.setInt(1, id);
                statement.setString(2, name);
                try(ResultSet r = statement.executeQuery()) {
                    if (r.next()) {
                        User user = new User(r.getInt("id"),r.getString("name"),
                                r.getString("birthday"), r.getInt("login_ID"),
                                        r.getString("city"), r.getString("email"),
                                        r.getString("description"));
                        return user;
                    }
                }
            }
        } catch (SQLException e) {
            logger.error("Error", e);
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        // TODO: 02.01.2020 написать апдейт
    }

    @Override
    public void deleteUser(Integer id) {
        // TODO: 02.01.2020 написать удаление
    }
}
