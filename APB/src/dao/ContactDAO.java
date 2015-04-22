/*
 * Package: DAO
 * Class: ContactDAO.java
 *
 * Description: This class is reponsible make a connection to Contact to database
 * atributes and necessary methods to attribute them.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Phonebook;
import dao.FactoryConnection;

public class ContactDAO {

	private static ContactDAO instance;

	private ContactDAO() {
	}

	public static ContactDAO getInstance() {
		if (instance == null)
			instance = new ContactDAO();
		return instance;
	}

	// this method include one schedule in the phonebook
	public boolean insert(Phonebook phonebook) throws SQLException {
		if (phonebook == null)
			return false;

		this.updateQuery("INSERT INTO "
				+ "phonebook (name, telefone, descricao) VALUES (" + "\""
				+ phonebook.getName() + "\", " + "\""
				+ phonebook.getPhoneNumber() + "\", " + "\""
				+ phonebook.getDescription() + "\"); ");
		return true;
	}

	// this method change data on the schedule
	public boolean change(String name, Phonebook phonebook_change,
			Phonebook phonebook) throws SQLException {
		if (phonebook == null || phonebook_change == null)
			return false;

		this.updateQuery("UPDATE phonebook SET " + "name = \""
				+ phonebook_change.getName() + "\", " + "telefone = \""
				+ phonebook_change.getPhoneNumber() + "\", " + "descricao = \""
				+ phonebook_change.getDescription() + "\"" + " WHERE "
				+ " phonebook.name = \"" + name + "\";");

		return true;
	}

	// this method exclude one event on the schedule
	public boolean delete(Phonebook contato) throws SQLException {
		if (contato == null)
			return false;

		this.updateQuery("DELETE FROM phonebook WHERE " + "phonebook.telefone = \""
				+ contato.getPhoneNumber() + "\";");
		return true;
	}

	// this method is responsible to make connection with the database
	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

	// this method shows contacts registred on the schedule
	public ResultSet mostrarContatosCadastrados(Phonebook contato)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"Select * from phonebook;");

		return rs;
	}

	// this method search by name in the schedule
	public ResultSet searchByNome(Phonebook contato) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM phonebook WHERE " + "name = '"
						+ contato.getName() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

	// this method search by phone in the schedule
	public ResultSet searchByTelefone(Phonebook contato)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM phonebook WHERE "
						+ "telefone = '" + contato.getPhoneNumber() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
