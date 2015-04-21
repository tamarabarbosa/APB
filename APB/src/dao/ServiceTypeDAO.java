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
	public boolean insert(ServiceType tipoJob) throws SQLException {
		if (tipoJob == null)
			return false;

		this.updateQuery("INSERT INTO " + "tipojob (name, preco) VALUES ("
				+ "\"" + tipoJob.getNameServiceType() + "\", " + "\""
				+ tipoJob.getPrice() + "\"); ");

		return true;
	}
	//this method change type of service provided
	public boolean change(String name, ServiceType tipoJob_alterado,
			ServiceType tipoJob) throws SQLException {
		if (tipoJob_alterado == null || tipoJob == null)
			return false;

		this.updateQuery("UPDATE tipojob SET name = '"
				+ tipoJob_alterado.getNameServiceType() + "', "
				+ "preco = '" + tipoJob_alterado.getPrice() + "' WHERE"
				+ " name = '" + name + "';");

		return true;
	}
	//this method exclude type of service provided
	public boolean delete(ServiceType tipoJob) throws SQLException {
		if (tipoJob == null)
			return false;

		this.updateQuery("DELETE FROM tipojob WHERE "
				+ "tipoJob.name = \"" + tipoJob.getNameServiceType()
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
				"SELECT * FROM tipojob;");

		return rs;
	}
	//this method search by name type of service
	public ResultSet pesquisarPorNome(ServiceType job) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM tipojob WHERE "
						+ "name = '" + job.getNameServiceType() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
