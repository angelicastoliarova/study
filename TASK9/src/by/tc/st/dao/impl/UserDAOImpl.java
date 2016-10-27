package by.tc.st.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.tc.st.bean.entity.User;
import by.tc.st.dao.UserDAO;
import by.tc.st.dao.exception.DAOException;
import by.tc.st.dao.pool.ConnectionPool;

public class UserDAOImpl implements UserDAO{

    @Override
    public User logination(String login, String password) throws DAOException {
        User user = null;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            try(Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT id, login,role FROM USERS WHERE login='"
                        + login + "' AND password='" + password + "';");

                if(resultSet.next()) {
                    user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                }

            }
        } catch (InterruptedException | SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                ConnectionPool.getInstance().returnConnection(connection);
            } catch (SQLException | InterruptedException e) {
                throw new DAOException(e.getMessage());
            }
        }
        return user;
    }

    @Override
    public boolean registration(String login, String password) throws DAOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            try(Statement statement = connection.createStatement()) {
                int result = statement.executeUpdate("INSERT INTO USERS(login,password) VALUES('"
                        + login +"', '" + password +"');");
                return (result != 0)? true : false;
            }
        } catch (InterruptedException | SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                ConnectionPool.getInstance().returnConnection(connection);
            } catch (SQLException | InterruptedException e) {
                throw new DAOException(e.getMessage());
            }
        }
    }
}