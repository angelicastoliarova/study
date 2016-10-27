package by.tc.st.dao;

import by.tc.st.bean.entity.User;
import by.tc.st.dao.exception.DAOException;

public interface UserDAO {

    User logination(String login, String password) throws DAOException;
    boolean registration(String login, String password) throws DAOException;

}