package by.tc.nb.dao;

import by.tc.nb.dao.exception.DAOException;

public interface UserDAO {
	int logination(String login, String password) throws DAOException;
	public boolean registration(String login, String password) throws DAOException;
}
