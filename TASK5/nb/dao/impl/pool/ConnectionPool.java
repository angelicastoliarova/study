package by.tc.nb.dao.impl.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
	private static final ConnectionPool instance = new ConnectionPool();

	private BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(5);

	private ConnectionPool() {

		Connection con = null;

		try {
			java.sql.DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Регистрация драйвера прошла успешно");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {

			for (int i = 1; i <= pool.remainingCapacity(); i++) {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notebook?useSSL=false", "root",
						"74nwCAD2ANGELica79");
				pool.add(con);
				System.out.println("Соединение установлено");
			}

		}

		catch (SQLException e) {
			System.out.println("Соединение не установлено");
			e.printStackTrace();
		}

	}

	public Connection getConnection() throws InterruptedException {
		return pool.take();
	}

	public void returnConnection(Connection connection) throws SQLException, InterruptedException {
		if (connection == null) {
			return;
		}
		connection.setAutoCommit(true);
		connection.setReadOnly(true);

		pool.put(connection);
	}

	public void closePool() {

		for (Connection con : pool) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}

	}

	public static ConnectionPool getInstance() {
		return instance;
	}

}
