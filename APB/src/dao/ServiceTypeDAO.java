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
		if (instance == null) {
			instance = new ServiceTypeDAO();
		} else {
			// Nothing to do - because the condition "if" is just used to check
			// the initial value of the variable
		}

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
		boolean serviceTypeInserted;
		if (typeJob == null) {
			serviceTypeInserted = false;
		} else {
			String sqlCodeToInsertServiceType = "INSERT INTO "
					+ "tiposervico (nome, preco) VALUES (" + "\""
					+ typeJob.getTempName() + "\", " + "\""
					+ typeJob.getNameServiceType() + "\"); ";

			this.updateQuery(sqlCodeToInsertServiceType);

			serviceTypeInserted = true;
		}
		return serviceTypeInserted;
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
	public boolean change(boolean existsNewServiceType, ServiceType typeJob_change,
			ServiceType typeJob) throws SQLException {
		boolean serviceTypeEdited;
		if (typeJob_change == null || typeJob == null) {
			serviceTypeEdited = false;
		} else {
			String sqlCodeToUpdateServiceType = "UPDATE tiposervico SET nome = '"
					+ typeJob.getNameServiceType()
					+ "', "
					+ "preco = '"
					+ typeJob_change.getPrice()
					+ "' WHERE"
					+ " nome = '"
					+ existsNewServiceType + "';";

			this.updateQuery(sqlCodeToUpdateServiceType);
			serviceTypeEdited = true;

		}

		return serviceTypeEdited;
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
		boolean serviceTypeDeleted;
		if (typeJob == null) {
			serviceTypeDeleted = false;
		} else {
			String sqlCodeToDeleteServiceType = "DELETE FROM tiposervico WHERE "
					+ "tipoServico.nome = \""
					+ typeJob.getNameServiceType()
					+ "\";";

			this.updateQuery(sqlCodeToDeleteServiceType);
			serviceTypeDeleted = true;
		}

		return serviceTypeDeleted;
	}

	/**
	 * Create a connection with DB
	 * 
	 * @return The connection established
	 * @throws SQLException
	 */
	public Connection createConnectionWithDB() throws SQLException {
		FactoryConnection factoryConnectionInstance = FactoryConnection
				.getInstance();
		Connection connection = factoryConnectionInstance.getConnection();

		return connection;
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
		Connection connection = createConnectionWithDB();

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
	public ResultSet displayRegisteredTypesOfService(ServiceType job)
			throws SQLException {
		Connection connection = createConnectionWithDB();

		ResultSet resultInstance = connection.createStatement().executeQuery(
				"SELECT * FROM tiposervico;");

		return resultInstance;
	}

	/**
	 * Method used to search by name
	 * 
	 * @param service
	 *            - Contains the services
	 * @throws SQLException
	 * @return - Return ResultSet of the search by name
	 */
	public ResultSet searchByName(ServiceType service) throws SQLException {
		Connection connection = createConnectionWithDB();

		java.sql.PreparedStatement preparedStatement;

		preparedStatement = connection
				.prepareStatement("SELECT * FROM tiposervico WHERE "
						+ "nome = '" + service.getNameServiceType() + "';");

		ResultSet resultInstance = preparedStatement.executeQuery();

		return resultInstance;
	}

}
