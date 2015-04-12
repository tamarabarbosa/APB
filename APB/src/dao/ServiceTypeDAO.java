package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TipoServico;

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
	public boolean incluir(TipoServico tipoServico) throws SQLException {
		if (tipoServico == null)
			return false;

		this.updateQuery("INSERT INTO " + "tiposervico (nome, preco) VALUES ("
				+ "\"" + tipoServico.getNomeTipoServico() + "\", " + "\""
				+ tipoServico.getPreco() + "\"); ");

		return true;
	}
	//this method change type of service provided
	public boolean alterar(String nome, TipoServico tipoServico_alterado,
			TipoServico tipoServico) throws SQLException {
		if (tipoServico_alterado == null || tipoServico == null)
			return false;

		this.updateQuery("UPDATE tiposervico SET nome = '"
				+ tipoServico_alterado.getNomeTipoServico() + "', "
				+ "preco = '" + tipoServico_alterado.getPreco() + "' WHERE"
				+ " nome = '" + nome + "';");

		return true;
	}
	//this method exclude type of service provided
	public boolean excluir(TipoServico tipoServico) throws SQLException {
		if (tipoServico == null)
			return false;

		this.updateQuery("DELETE FROM tiposervico WHERE "
				+ "tipoServico.nome = \"" + tipoServico.getNomeTipoServico()
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
	public ResultSet mostrarTipoServicoCadastrados(TipoServico servico)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"SELECT * FROM tiposervico;");

		return rs;
	}
	//this method search by name type of service 
	public ResultSet pesquisarPorNome(TipoServico servico) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM tiposervico WHERE "
						+ "nome = '" + servico.getNomeTipoServico() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
