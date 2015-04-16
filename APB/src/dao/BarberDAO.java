/*
 * Package: DAO
 * Class: BarberDAO.java
 *
 * Description: This class is reponsible make a connection to BarberDao to database
 * atributes and necessary methods to attribute them.
 */

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
				+ barber.getName() + "\", " + "\"" + barber.getCpf() + "\", "
				+ "\"" + barber.getRg() + "\", " + "\""
				+ barber.getPhoneNumber() + "\", " + "\"" + barber.getChair()
				+ "\"); ");

		return true;
	}

	// update the barber in the database
	public boolean alterar(String nome, Barber barber_change, Barber barber)
			throws SQLException {
		if (barber_change == null || barber == null)
			return false;

		this.updateQuery("UPDATE barber SET nome = '" + barber_change.getName()
				+ "', " + "cpf = '" + barber_change.getCpf() + "', " + "rg = '"
				+ barber_change.getRg() + "', " + "telefone = '"
				+ barber_change.getPhoneNumber() + "', " + "cadeira = '"
				+ barber_change.getChair() + "' WHERE" + " cpf = '" + nome
				+ "';");

		return true;
	}

	// exclude the new barber in the database
	public boolean delete(Barber barber) throws SQLException {
		if (barber == null)
			return false;

		this.updateQuery("DELETE FROM barber WHERE " + "barber.nome = \""
				+ barber.getName() + "\";");
		return true;
	}

	// search a barber in the database
	public ResultSet search() throws SQLException {
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
	public ResultSet showRegisteredBarbers(Barber barber) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"Select nome, cpf, rg, telefone, cadeira from barber;");

		return rs;
	}

	// this method searches the barber by name
	public ResultSet searchByName(Barber barber) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM barber WHERE nome = '"
						+ barber.getName() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
