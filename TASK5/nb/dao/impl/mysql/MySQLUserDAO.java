package by.tc.nb.dao.impl.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import by.tc.nb.bean.entity.SQLUser;
import by.tc.nb.bean.entity.SQLUser;
import by.tc.nb.dao.UserDAO;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.dao.impl.pool.ConnectionPool;

public class MySQLUserDAO implements UserDAO {

	@Override
	public int logination(String login, String password) throws DAOException {
		String query;
		System.out.println("где я?");
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int userId = 0;
		query = "SELECT user_id FROM users WHERE login = '" + login + "' AND " + "password = '" + password + "';";
		try {
			con = ConnectionPool.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				userId = rs.getInt(1);
			}

		} catch (SQLException e) {
			throw new DAOException();
		} catch (InterruptedException e) {
			throw new DAOException();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con);
			} catch (SQLException e) {
			} catch (InterruptedException e) {
			}
		}

		return userId;

	}

	@Override
	public boolean registration(String login, String password) throws DAOException {

		Connection con = null;
		Statement st = null;
		try {

			con = ConnectionPool.getInstance().getConnection();
			System.out.println(con);
			st = con.createStatement();

			int result = st
					.executeUpdate("INSERT INTO user(login, password) VALUES('" + login + "','" + password + "');");

			System.out.println(result);
			if (result != 0) {
				System.out.println("хорошо");
				st.close();
				return true;
			} else
				System.out.println("плохо");
			st.close();
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		} catch (Exception e) {

		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			try {
				ConnectionPool.getInstance().returnConnection(con);
			} catch (SQLException e) {
			} catch (InterruptedException e) {
			}
		}
		return false;
	}

}
