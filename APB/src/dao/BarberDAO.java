package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Barber;

public class BarberDAO {

	private static BarberDAO instance;

	private BarberDAO() {
	}

	// this method check the existence of the barber in the database
	public static BarberDAO getInstance() {
		if (instance == null)
			instance = new BarberDAO();
		return instance;
	}

	// include the new barber in the database
	public boolean incluir(Barber barber) throws SQLException {
		if (barber == null)
			return false;

		this.updateQuery("INSERT INTO "
				+ "barber (nome, cpf, rg, telefone, cadeira) VALUES (" + "\""
				+ barber.getName() + "\", " + "\"" + barber.getCpf()
				+ "\", " + "\"" + barber.getRg() + "\", " + "\""
				+ barber.getTelefone() + "\", " + "\""
				+ barber.getCadeira() + "\"); ");

		return true;
	}

	// update the barber in the database
	public boolean alterar(String nome, Barber barber_alterado,
			Barber barber) throws SQLException {
		if (barber_alterado == null || barber == null)
			return false;

		this.updateQuery("UPDATE barber SET nome = '"
				+ barber_alterado.getName() + "', " + "cpf = '"
				+ barber_alterado.getCpf() + "', " + "rg = '"
				+ barber_alterado.getRg() + "', " + "telefone = '"
				+ barber_alterado.getTelefone() + "', " + "cadeira = '"
				+ barber_alterado.getCadeira() + "' WHERE" + " cpf = '"
				+ nome + "';");

		return true;
	}

	// exclude the new barber in the database
	public boolean excluir(Barber barber) throws SQLException {
		if (barber == null)
			return false;

		this.updateQuery("DELETE FROM barber WHERE " + "barber.nome = \""
				+ barber.getName() + "\";");
		return true;
	}

	// search a barber in the database
	public ResultSet pesquisar() throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM barber;");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

	// this method is responsible for connection with database
	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

	// this method shows barbers in the database
	public ResultSet showRegisteredBarbers(Barber barber)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"Select nome, cpf, rg, telefone, cadeira from barber;");

		return rs;
	}

	// this method searches the barber by name
	public ResultSet pesquisarPorNome(Barber barber) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM barber WHERE nome = '"
						+ barber.getName() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
