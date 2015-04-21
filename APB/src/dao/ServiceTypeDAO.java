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
	public boolean insert(ServiceType tipoServico) throws SQLException {
		if (tipoServico == null)
			return false;

		this.updateQuery("INSERT INTO " + "tiposervico (nome, preco) VALUES ("
				+ "\"" + tipoServico.getNameServiceType() + "\", " + "\""
				+ tipoServico.getPrice() + "\"); ");

		return true;
	}
	//this method change type of service provided
	public boolean change(String nome, ServiceType tipoServico_alterado,
			ServiceType tipoServico) throws SQLException {
		if (tipoServico_alterado == null || tipoServico == null)
			return false;

		this.updateQuery("UPDATE tiposervico SET nome = '"
				+ tipoServico_alterado.getNameServiceType() + "', "
				+ "preco = '" + tipoServico_alterado.getPrice() + "' WHERE"
				+ " nome = '" + nome + "';");

		return true;
	}
	//this method exclude type of service provided
	public boolean excluir(ServiceType tipoServico) throws SQLException {
		if (tipoServico == null)
			return false;

		this.updateQuery("DELETE FROM tiposervico WHERE "
				+ "tipoServico.nome = \"" + tipoServico.getNameServiceType()
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
	public ResultSet mostrarTipoServicoCadastrados(ServiceType servico)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"SELECT * FROM tiposervico;");

		return rs;
	}
	//this method search by name type of service
	public ResultSet pesquisarPorNome(ServiceType servico) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM tiposervico WHERE "
						+ "nome = '" + servico.getNameServiceType() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
