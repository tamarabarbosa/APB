/*
 * Package: DAO
 * Class: FactoryConnection.java
 *
 * Description: This class is make the configuration and connection with database
 * atributes and necessary methods to attribute them.
 */

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

	// this method create the connection with the database
	public static FactoryConnection getInstance() {
		if (instance == null) {
			instance = new FactoryConnection();
		} else {
			// Nothing to do
		}
		return instance;
	}

	// this method make the connection with the database
	public Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(local, user, password);
		return connection;
	}

}
