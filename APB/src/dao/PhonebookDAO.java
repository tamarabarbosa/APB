/*
 * Package: DAO
 * Class: PhonebookDAO.java
 *
 * Description: This class is reponsible make a connection to Phonebook to database
 * atributes and necessary methods to attribute them.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Phonebook;
import dao.FactoryConnection;

public class PhonebookDAO {

	private static PhonebookDAO instance;

	private PhonebookDAO() {
	}

	public static PhonebookDAO getInstance() {
		if (instance == null)
			instance = new PhonebookDAO();
		return instance;
	}

	public boolean insert(Phonebook phonebook) throws SQLException {
		if (phonebook == null)
			return false;

		this.updateQuery("INSERT INTO "
				+ "PhoneNumber (name, telefone, descricao) VALUES (" + "\""
				+ Phonebook.getName() + "\", " + "\""
				+ Phonebook.getPhoneNumber() + "\", " + "\""
				+ Phonebook.getDescription() + "\"); ");
		return true;
	}

	public boolean change(String name, Phonebook Phonebook_change,
			Phonebook Phonebook) throws SQLException {
		if (Phonebook == null || Phonebook_change == null)
			return false;

		this.updateQuery("UPDATE Phonebook SET " + "name = \""
				+ Phonebook_change.getName() + "\", " + "telefone = \""
				+ Phonebook_change.getPhoneNumber() + "\", "
				+ "descricao = \"" + Phonebook_change.getDescription() + "\""
				+ " WHERE " + " Phonebook.name = \"" + name + "\";");

		return true;
	}

	public boolean delete(Phonebook contato) throws SQLException {
		if (contato == null)
			return false;

		this.updateQuery("DELETE FROM Phonebook WHERE "
				+ "Phonebook.telefone = \"" + contato.getPhoneNumber() + "\";");
		return true;
	}

	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

	public ResultSet mostrarContatosCadastrados(Phonebook contato)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"Select * from Phonebook;");

		return rs;
	}

	public ResultSet searchByNome(Phonebook contato) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM Phonebook WHERE " + "name = '"
						+ contato.getName() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

	public ResultSet searchByTelefone(Phonebook contato)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM Phonebook WHERE "
						+ "telefone = '" + contato.getPhoneNumber() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
