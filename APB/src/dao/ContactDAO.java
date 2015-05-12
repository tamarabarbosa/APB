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

import model.Contact;
import model.Phonebook;
import dao.FactoryConnection;

public class ContactDAO {

	// Stores the current instance of the class
	private static ContactDAO instance;

	// Class constructor
	private ContactDAO() {
	}

	/**
	 * @return The current instance if exists, or instantiate a new one if does
	 *         not and return it
	 */
	public static ContactDAO getInstance() {
		if (instance == null) {
			instance = new ContactDAO();
		} else {
			// Nothing to do - because the condition "if" is just used to check
			// the initial value of the variable
		}

		return instance;
	}

	/**
	 * Method used to include data in the phonebook
	 * 
	 * @param phonebook
	 *            - Is going to receive the data
	 * @throws SQLException
	 * @return - Return the status of the insertion
	 */
	public boolean insert(Phonebook phonebook) throws SQLException {
		boolean dataToPhonebookInserted;

		if (phonebook == null) {
			dataToPhonebookInserted = false;
		} else {
			String sqlCodeToInsertContact = "INSERT INTO "
					+ "agenda (nome, telefone, descricao) VALUES (" + "\""
					+ phonebook.getName() + "\", " + "\""
					+ phonebook.getPhoneNumber() + "\", " + "\""
					+ phonebook.getDescription() + "\"); ";

			this.updateQuery(sqlCodeToInsertContact);
			dataToPhonebookInserted = true;
		}

		return dataToPhonebookInserted;
	}

	/**
	 * Method used to edit data in the phonebook
	 * 
	 * @param name
	 *            - Receives the name
	 * @param phonebookEdited
	 *            - Receives the editions
	 * @param phonebook
	 *            - Contains the phonebook data
	 * @throws SQLException
	 * @return - Return the status of the edition
	 */
	public boolean change(String name, Phonebook phonebook_change,
			Phonebook phonebook) throws SQLException {
		boolean dataToPhonebookEdited;

		if (phonebook == null || phonebook_change == null) {
			dataToPhonebookEdited = false;
		} else {
			String sqlCodeToUpdatePhonebook = "UPDATE agenda SET "
					+ "nome = \"" + phonebook_change.getName() + "\", "
					+ "telefone = \"" + phonebook_change.getPhoneNumber()
					+ "\", " + "descricao = \""
					+ phonebook_change.getDescription() + "\"" + " WHERE "
					+ " agenda.nome = \"" + name + "\";";

			this.updateQuery(sqlCodeToUpdatePhonebook);

			dataToPhonebookEdited = true;
		}

		return dataToPhonebookEdited;
	}

	// this method exclude one event on the schedule
	public boolean delete(Phonebook contact) throws SQLException {
		if (contact == null)
			return false;

		this.updateQuery("DELETE FROM phonebook WHERE "
				+ "phonebook.telefone = \"" + contact.getPhoneNumber() + "\";");
		return true;
	}

	/**
	 * Method used to delete data from the phonebook
	 * 
	 * @param contact
	 *            - Contact for delete
	 * @return
	 * @throws SQLException
	 * @return - Return the status of the exclusion
	 */
	public boolean updateQuery(String message) throws SQLException {
		boolean dataToPhonebookDeleted;
		if (message == null) {
			dataToPhonebookDeleted = false;
		} else {
			String sqlCodeToDeleteFromPhonebook = "DELETE FROM agenda WHERE "
					+ "agenda.telefone = \"" + Contact.getTempName() + "\";";

			this.updateQuery(sqlCodeToDeleteFromPhonebook);

			dataToPhonebookDeleted = true;
		}

		return dataToPhonebookDeleted;
	}

	/**
	 * Create a connection with DB
	 * 
	 * @return The connection established
	 * @throws SQLException
	 * @return - Return the connection with the database
	 */
	public Connection createConnectionWithDB() throws SQLException {
		FactoryConnection factoryConnectionInstance = FactoryConnection
				.getInstance();
		Connection connection = factoryConnectionInstance.getConnection();

		return connection;
	}

	/**
	 * Method that gives access to the registered contacts
	 * 
	 * @throws SQLException
	 * @return - Return the ResultSet of the selection of the data from
	 *         phonebook
	 */
	public ResultSet showRegisteredContacts(Contact contact)
			throws SQLException {
		Connection connection = createConnectionWithDB();

		ResultSet resultInstance = connection.createStatement().executeQuery(
				"Select * from agenda;");

		return resultInstance;
	}

	/**
	 * Method that gives access to the search by name
	 * 
	 * @param contact
	 *            - Contains the contact to be displayed
	 * @throws SQLException
	 * @return - Return ResultSet of the search by name
	 */
	public ResultSet searchByNome(Contact contact) throws SQLException {
		Connection connection = createConnectionWithDB();

		String sqlCodeToSelectThroughNameFromPhonebook = "SELECT * FROM agenda WHERE "
				+ "nome = '" + contact.getName() + "';";

		java.sql.PreparedStatement preparedStatement = connection
				.prepareStatement(sqlCodeToSelectThroughNameFromPhonebook);

		ResultSet resultInstance = preparedStatement.executeQuery();

		return resultInstance;
	}

	/**
	 * Method that gives access to the search by phone number
	 * 
	 * @param contact
	 *            - Contains the contact to be displayed
	 * @throws SQLException
	 * @return - Return ResultSet of the search by phone
	 */
	public ResultSet searchByPhone(Phonebook contact) throws SQLException {
		Connection connection = createConnectionWithDB();

		String sqlCodeToSelectThroughPhoneFromPhonebook = "SELECT * FROM agenda WHERE "
				+ "telefone = '" + contact.getPhoneNumber() + "';";

		java.sql.PreparedStatement preparedStatement = connection
				.prepareStatement(sqlCodeToSelectThroughPhoneFromPhonebook);

		ResultSet resultInstance = preparedStatement.executeQuery();

		return resultInstance;
	}

}
