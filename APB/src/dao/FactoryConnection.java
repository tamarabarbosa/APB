package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
	static String statusConnection = "";

	private String local = "jdbc:mysql://localhost/apb";
	private String user = "root";
	private String password = "root";

	private static FactoryConnection instance;

	private FactoryConnection() {
	}
	//this method create the connection with the database
	public static FactoryConnection getInstance() {
		if (instance == null)
			instance = new FactoryConnection();
		return instance;
	}
	//this method make the connection with the database
	public Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(local, user, password);
		return connection;
	}

}
