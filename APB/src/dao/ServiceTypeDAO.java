/*
 * Package: DAO
 * Class: ServiceTypeDAO.java
 *
 * Description: This class is reponsible make a connection to ServiceTypeDAO to database and indicating the type of service done.
 * atributes and necessary methods to attribute them.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ServiceType;

public class ServiceTypeDAO {

	// Stores the current instance of the class
	private static ServiceTypeDAO instance;

	// General class constructor
	private ServiceTypeDAO() {
	}

	/**
	 * @return The current instance, if exists, or instantiate a new one if does
	 *         not and return it
	 */
	public static ServiceTypeDAO getInstance() {
		if (instance == null)
			instance = new ServiceTypeDAO();
		return instance;
	}

	/**
	 * Method used to include a service type
	 * 
	 * @param addServiceType
	 *            - Includes the type of the service
	 * @throws SQLException
	 * @return - Return the status of the insertion
	 */
	public boolean insert(ServiceType typeJob) throws SQLException {
		if (typeJob == null)
			return false;

		this.updateQuery("INSERT INTO " + "typejob (name, preco) VALUES ("
				+ "\"" + typeJob.getNameServiceType() + "\", " + "\""
				+ typeJob.getPrice() + "\"); ");

		return true;
	}

	/**
	 * Method used to edit a service type
	 * 
	 * @param serviceTypeName
	 *            - Receives the name of the type of service
	 * @param editedServiceType
	 *            - Gets the edited service type
	 * @param editServiceType
	 *            - Edits the service type
	 * @throws SQLException
	 * @return - Return the status of the edition
	 */
	public boolean change(String name, ServiceType typeJob_change,
			ServiceType typeJob) throws SQLException {
		if (typeJob_change == null || typeJob == null)
			return false;

		this.updateQuery("UPDATE typejob SET name = '"
				+ typeJob_change.getNameServiceType() + "', " + "preco = '"
				+ typeJob_change.getPrice() + "' WHERE" + " name = '" + name
				+ "';");

		return true;
	}

	/**
	 * Method used to delete a service type
	 * 
	 * @param deleteServiceType
	 *            - Deletes the service type
	 * @throws SQLException
	 * @return - Return the status of the exclusion
	 */
	public boolean delete(ServiceType typeJob) throws SQLException {
		if (typeJob == null)
			return false;

		this.updateQuery("DELETE FROM typejob WHERE " + "typeJob.name = \""
				+ typeJob.getNameServiceType() + "\";");
		return true;
	}

	/**
	 * Method used to execute some action on DB
	 * 
	 * @param message
	 *            - SQL code of action to be executed
	 * @throws SQLException
	 * @return - Return the connection with the database
	 */
	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

	/**
	 * Method used to display the registered service types
	 * 
	 * @param service
	 *            - Contains the services
	 * @throws SQLException
	 * @return - Return the ResultSet of the selection of the all data from
	 *         services type
	 */
	public ResultSet mostrarTipoJobCadastrados(ServiceType job)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"SELECT * FROM typejob;");

		return rs;
	}

	/**
	 * Method used to search by name
	 * 
	 * @param service
	 *            - Contains the services
	 * @throws SQLException
	 * @return - Return ResultSet of the search by name
	 */
	public ResultSet searchByNome(ServiceType job) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM typejob WHERE " + "name = '"
						+ job.getNameServiceType() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
