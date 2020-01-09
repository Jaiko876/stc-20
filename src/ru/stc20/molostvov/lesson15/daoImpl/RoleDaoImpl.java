package ru.stc20.molostvov.lesson15.daoImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.stc20.molostvov.lesson15.connectionManagerJDBCImpl.ConnectionManagerJDBCImp;
import ru.stc20.molostvov.lesson15.dao.RoleDao;
import ru.stc20.molostvov.lesson15.dto.Role;
import ru.stc20.molostvov.lesson15.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleDaoImpl implements RoleDao {
    private static final Logger logger = LogManager.getLogger(RoleDaoImpl.class);


    private static final String SET_ROLE = "Insert INTO " +
            "lesson15.user_role(user_id, role_id) values (?,?)";

    @Override
    public void setRole(User user, Role role) {
        try (Connection connection = ConnectionManagerJDBCImp.getInstance().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SET_ROLE)) {
                statement.setInt(0, user.getId());
                statement.setInt(1, role.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            logger.error("Error", e);       }
    }

    @Override
    public void getRole (User user){
        // TODO: 06.01.2020 угу угу
    }
}
