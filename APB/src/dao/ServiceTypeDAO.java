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

	private static ServiceTypeDAO instance;

	private ServiceTypeDAO() {
	}
	//this method check if existence of type of service in data base
	public static ServiceTypeDAO getInstance() {
		if (instance == null)
			instance = new ServiceTypeDAO();
		return instance;
	}
	//this method include type of service provided
	public boolean insert(ServiceType typeJob) throws SQLException {
		if (typeJob == null)
			return false;

		this.updateQuery("INSERT INTO " + "typejob (name, preco) VALUES ("
				+ "\"" + typeJob.getNameServiceType() + "\", " + "\""
				+ typeJob.getPrice() + "\"); ");

		return true;
	}
	//this method change type of service provided
	public boolean change(String name, ServiceType typeJob_change,
			ServiceType typeJob) throws SQLException {
		if (typeJob_change == null || typeJob == null)
			return false;

		this.updateQuery("UPDATE typejob SET name = '"
				+ typeJob_change.getNameServiceType() + "', "
				+ "preco = '" + typeJob_change.getPrice() + "' WHERE"
				+ " name = '" + name + "';");

		return true;
	}
	//this method exclude type of service provided
	public boolean delete(ServiceType typeJob) throws SQLException {
		if (typeJob == null)
			return false;

		this.updateQuery("DELETE FROM typejob WHERE "
				+ "typeJob.name = \"" + typeJob.getNameServiceType()
				+ "\";");
		return true;
	}
	//this method make connection with database
	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	//this method show type of service registred
	public ResultSet mostrarTipoJobCadastrados(ServiceType job)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"SELECT * FROM typejob;");

		return rs;
	}
	//this method search by name type of service
	public ResultSet searchByNome(ServiceType job) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM typejob WHERE "
						+ "name = '" + job.getNameServiceType() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
