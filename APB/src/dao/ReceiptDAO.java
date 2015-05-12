/*
 * Package: DAO
 * Class: ReceiptDAO.java
 *
 * Description: This class is reponsible make a connection to Receipt to database through FactoryConnection
 * atributes and necessary methods to attribute them.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptDAO {

	// Stores the current instance of the class
	private static ReceiptDAO instance;

	// General class constructor
	private ReceiptDAO() {
	}

	/**
	 * @return The current instance if exists, or instantiate a new one if does
	 *         not and return it
	 */
	public static ReceiptDAO getInstance() {
		if (instance == null) {
			instance = new ReceiptDAO();
		} else {
			// Nothing to do - because the condition "if" is just used to check
			// the initial value of the variable
		}

		return instance;
	}

	/**
	 * Create a connection with DB
	 * 
	 * @return The connection established
	 * @throws SQLException
	 * @return - Return the connection with the database
	 */
	public Connection createConnectionWithDB() throws SQLException {
		FactoryConnection factoryConnectionInstance = FactoryConnection
				.getInstance();
		Connection connection = factoryConnectionInstance.getConnection();

		return connection;
	}

	/**
	 * Method used to search barber services
	 * 
	 * @param barberName
	 *            - Contains the barber name
	 * @param initialDate
	 *            - Receives the initial date
	 * @param finalDate
	 *            - Receives the final date
	 * @throws SQLException
	 * @return - Return the ResultSet of the selection of the search by a
	 *         service
	 */
	public ResultSet barberServicesSearch(String barber, String dataInicial,
			String dataFinal) throws SQLException {

		Connection connection = createConnectionWithDB();

		String sqlCodeToSelectFromGivenService = "SELECT * FROM servicoprestado WHERE data BETWEEN '"
				+ dataInicial
				+ "' AND '"
				+ dataFinal
				+ "' AND barbeiro = '"
				+ barber + "';";

		PreparedStatement preparedStatement = connection
				.prepareStatement(sqlCodeToSelectFromGivenService);

		ResultSet resultInstance = preparedStatement.executeQuery();

		return resultInstance;
	}

	/**
	 * Method used to execute some action on DB
	 * 
	 * @param message
	 *            - SQL code of action to be executed
	 * @throws SQLException
	 */
	public void updateQuery(String message) throws SQLException {
		Connection connection = createConnectionWithDB();

		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

}
