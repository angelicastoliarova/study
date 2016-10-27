package by.tc.st.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.tc.st.bean.entity.Qui;
import by.tc.st.dao.TestDAO;
import by.tc.st.dao.exception.DAOException;
import by.tc.st.dao.pool.ConnectionPool;

public class TestDAOImpl implements TestDAO {

	@Override
	public List<Qui> findQuiByTest(int id) throws DAOException {
		Connection connection = null;
		List<Qui> resultList = new ArrayList<>();
		System.out.println("номер теста" + id);
		try {
			ResultSet resultSet = null;
			connection = ConnectionPool.getInstance().getConnection();
			try (Statement statement = connection.createStatement()) {

				resultSet = statement.executeQuery(
						"SELECT Quetion,  IdTest, IdCorrectAnswer FROM QUETIONS WHERE idTest='" + id + "';");

				while (resultSet.next()) {
					resultList.add(new Qui(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3)));
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
		return resultList;
	}

	@Override
	public List<Qui> findForAddingTest(int subject, int numberOfTest, int quantityOfQuis) throws DAOException {
		Connection connection = null;
		List<Qui> resultList = new ArrayList<>();

		try {
			ResultSet resultSet = null;
			connection = ConnectionPool.getInstance().getConnection();
			try (Statement statement = connection.createStatement()) {
				System.out.println("количество вопросов" + quantityOfQuis);
				resultSet = statement.executeQuery(
						"SELECT Quetion, IdTest, IdCorrectAnswer FROM QUETIONS WHERE IdSubject=" + subject + ";");

				while (resultSet.next()) {
					// for (int a = 0; a <= quantityOfQuis; a++) {
					resultList.add(new Qui(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3)));

					try (Statement statement2 = connection.createStatement()) {
						int result = statement2.executeUpdate(
								"UPDATE QUETIONS set IdTest =" + numberOfTest + " WHERE IdSubject=" + subject);
						// }
					}

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
		return resultList;
	}

	@Override
	public void addQui(Qui qui) throws DAOException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			System.out.println(qui.getData());
			try (Statement statement = connection.createStatement()) {

				connection.setAutoCommit(false);
				int idanswer = 0;

				// String SQL = "INSERT INTO Answers (Answer,idAnswer) " +
				// "VALUES( '" + qui.getAnswer() + "', '"
				// + idanswer + "')";

				String SQL = "INSERT INTO allanswers (answer) " + "VALUES( '" + qui.getAnswer() + "')";

				statement.addBatch(SQL);

				String SQL2 = "INSERT INTO allanswers (answer) " + "VALUES( '" + qui.getincorrectanswer() + "')";
				statement.addBatch(SQL2);
				int[] count = statement.executeBatch();
				connection.commit();
				ResultSet resultSet = null;

				try (Statement statement2 = connection.createStatement()) {

					resultSet = statement2
							.executeQuery("SELECT idanswer FROM allanswers WHERE Answer='" + qui.getAnswer() + "';");
					while (resultSet.next()) {
						idanswer = resultSet.getInt(1);
					}
				}

				// resultSet = statement.executeQuery("SELECT idanswer FROM
				// allanswers WHERE Answer='" +qui.getAnswer()+ "';");
				// idanswer=resultSet.getInt(1);

				// statement.addBatch(SQL);
				System.out.println(idanswer);
				String SQL3 = "INSERT INTO QUETIONS (Quetion,IdSubject,IdCorrectAnswer) " + "VALUES( '" + qui.getData()
						+ "', '" + qui.getSubject() + "', '" + idanswer + "')";
				statement.addBatch(SQL3);
				int[] count2 = statement.executeBatch();
				connection.commit();

				/*
				 * int result1 = statement.
				 * executeUpdate("INSERT INTO Answers( Answer) VALUES('" +
				 * qui.getAnswer() + "');");
				 */

				// int result = statement.executeUpdate("INSERT INTO QUETIONS(
				// Quetion,IdSubject,IdCorrectAnswer) VALUES('"
				// + qui.getData() + "', '" + qui.getSubject()+ "', '" + count

				// + "');");
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
