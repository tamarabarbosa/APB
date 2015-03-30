package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Barbeiro;

public class BarbeiroDAO {

	private static BarbeiroDAO instance;

	private BarbeiroDAO() {
	}
	//this method check the existence of the barber in the database
	public static BarbeiroDAO getInstance() {
		if (instance == null)
			instance = new BarbeiroDAO();
		return instance;
	}
	// include the new barber in the database
	public boolean incluir(Barbeiro barbeiro) throws SQLException {
		if (barbeiro == null)
			return false;

		this.updateQuery("INSERT INTO "
				+ "barbeiro (nome, cpf, rg, telefone, cadeira) VALUES (" + "\""
				+ barbeiro.getNome() + "\", " + "\"" + barbeiro.getCpf()
				+ "\", " + "\"" + barbeiro.getRg() + "\", " + "\""
				+ barbeiro.getTelefone() + "\", " + "\""
				+ barbeiro.getCadeira() + "\"); ");

		return true;
	}
	// update the barber in the database
	public boolean alterar(String nome, Barbeiro barbeiro_alterado,
			Barbeiro barbeiro) throws SQLException {
		if (barbeiro_alterado == null || barbeiro == null)
			return false;

		this.updateQuery("UPDATE barbeiro SET nome = '"
				+ barbeiro_alterado.getNome() + "', " + "cpf = '"
				+ barbeiro_alterado.getCpf() + "', " + "rg = '"
				+ barbeiro_alterado.getRg() + "', " + "telefone = '"
				+ barbeiro_alterado.getTelefone() + "', " + "cadeira = '"
				+ barbeiro_alterado.getCadeira() + "' WHERE" + " cpf = '"
				+ nome + "';");

		return true;
	}
	// exclude the new barber in the database
	public boolean excluir(Barbeiro barbeiro) throws SQLException {
		if (barbeiro == null)
			return false;

		this.updateQuery("DELETE FROM barbeiro WHERE " + "barbeiro.nome = \""
				+ barbeiro.getNome() + "\";");
		return true;
	}
	//search a barber in the database
	public ResultSet pesquisar() throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM barbeiro;");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method is responsible for connection with database
	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	//this method shows barbers in the database
	public ResultSet mostrarBarbeirosCadastrados(Barbeiro barbeiro)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"Select nome, cpf, rg, telefone, cadeira from barbeiro;");

		return rs;
	}
	//this method searches the barber by name
	public ResultSet pesquisarPorNome(Barbeiro barbeiro) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM barbeiro WHERE nome = '"
						+ barbeiro.getNome() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
