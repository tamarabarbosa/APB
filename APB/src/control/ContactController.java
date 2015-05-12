/*
 * Package: Controller
 * Class: ContactController.java
 *
 * Description: This class is reponsible to make a registre of barber in the phonebook
 * atributes and necessary methods to attribute them.
 */

package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ContactDAO;
import dao.PhonebookDAO;
import model.Contact;
import model.Phonebook;

public class ContactController {

	// Stores the current instance of the class
	private static ContactController instance;

	// Class constructor
	private ContactController() {
	}

	/**
	 * Include a new contact on the database
	 * 
	 * @param contact
	 *            - Contact to be included
	 * @return true if the inclusion was made right or false if it does not.
	 * @throws SQLException
	 */
	public boolean include(Contact phonebook) throws SQLException {
		boolean returnMethodincludeContact;
		if (phonebook == null) {
			returnMethodincludeContact = false;
		} else {
			PhonebookDAO phonebookDAOInstance = PhonebookDAO.getInstance();
			phonebookDAOInstance.insert(phonebook);

			returnMethodincludeContact = true;
		}
		return returnMethodincludeContact;
	}

	/**
	 * Change a contact on the database
	 * 
	 * @param contactToChangeName
	 *            - Name of the contact that will be replaced
	 * @param newContact
	 *            - New contact to replace the old one
	 * @return true if the changes was made right or false if it does not.
	 * @throws SQLException
	 */
	public boolean change(String name, Contact phonebook) throws SQLException {
		boolean returnMethodchangeContact;
		if (phonebook == null) {
			returnMethodchangeContact = false;
		} else {
			Contact phonebookChange = phonebook;
			PhonebookDAO editPhonebookDataInstance = PhonebookDAO.getInstance();
			editPhonebookDataInstance.change(name, phonebookChange,
					phonebookChange);

			returnMethodchangeContact = true;
		}
		return returnMethodchangeContact;
	}

	/**
	 * Remove a contact from database
	 * 
	 * @param contactToBeRemoved
	 *            - The contact to be deleted
	 * @return true if the exclusion was made right or false if it does not.
	 * @throws SQLException
	 */
	public boolean delete(Phonebook contact) throws SQLException {
		boolean returnMethodremoveContact;
		if (contact == null) {
			returnMethodremoveContact = false;
		} else {
			PhonebookDAO deletePhonebookDataInstance = PhonebookDAO
					.getInstance();
			deletePhonebookDataInstance.delete(contact);

			returnMethodremoveContact = true;
		}

		return returnMethodremoveContact;
	}

	/**
	 * @return The current instance if it exists or instantiate a new one if
	 *         does not
	 */
	public static ContactController getInstance() {
		if (instance == null) {
			instance = new ContactController();
		} else {
			// Nothing to do because if 'instance' is not null, there is an
			// active instance
		}

		return instance;
	}

	/**
	 * Provides access to the registered contacts on the database
	 * 
	 * @return a ResultSet object with all contacts registered on the database
	 * @throws SQLException
	 */
	public ResultSet showContactsRegistered(Phonebook contact)
			throws SQLException {
		return PhonebookDAO.getInstance().mostrarContatosCadastrados(contact);
	}

	/**
	 * Search for a contact by it's name
	 * 
	 * @param contact
	 *            - Contact to be searched
	 * @return a ResultSet object with all contacts with the given contact name
	 * @throws SQLException
	 */
	public ResultSet searchByName(Contact contact) throws SQLException {
		ContactDAO contactDAOInstance = ContactDAO.getInstance();
		ResultSet searchByNameResult = contactDAOInstance.searchByNome(contact);

		return searchByNameResult;
	}

	/**
	 * Search for a contact by it's phone number
	 * 
	 * @param contact
	 *            - Contact to be searched
	 * @return a ResultSet object with all contacts with the given contact phone
	 *         number
	 * @throws SQLException
	 */
	public ResultSet searchByPhonebook(Contact contact) throws SQLException {
		PhonebookDAO contactDAOInstance = PhonebookDAO.getInstance();
		ResultSet searchPhoneResult = contactDAOInstance.searchByPhone(contact);

		return searchPhoneResult;
	}

}
