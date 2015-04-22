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

import dao.PhonebookDAO;
import model.Phonebook;

public class ContactController {

	private static ContactController instance;

	private ContactController() {
	}

	// this method include barber on the phonebook
	public boolean include(Phonebook phonebook) throws SQLException {
		if (phonebook == null) {
			return false;
		} else {
			PhonebookDAO.getInstance().insert(phonebook);
			return true;
		}
	}

	// this method change barber on the phonebook
	public boolean change(String name, Phonebook phonebook) throws SQLException {
		if (phonebook == null) {
			return false;
		} else {
			Phonebook phonebook_change = phonebook;
			PhonebookDAO.getInstance().change(name, phonebook_change,
					phonebook);
			return true;
		}
	}

	// this method exclude barber on the phonebook
	public boolean delete(Phonebook contact) throws SQLException {
		if (contact == null) {
			return false;
		} else {
			PhonebookDAO.getInstance().delete(contact);
			return true;
		}
	}

	// this method check if the instance is null case dont he set new phonebook
	public static ContactController getInstance() {
		if (instance == null) {
			instance = new ContactController();
			return instance;
		} else {
			return instance;
		}
	}

	// show results of contacts
	public ResultSet showContactsRegistered(Phonebook contact)
			throws SQLException {
		return PhonebookDAO.getInstance().mostrarContatosCadastrados(contact);
	}

	// show results by name
	public ResultSet searchByName(Phonebook contact) throws SQLException {
		return PhonebookDAO.getInstance().searchByNome(contact);
	}

	// show results by phone
	public ResultSet searchByPhonebook(Phonebook contact) throws SQLException {
		return PhonebookDAO.getInstance().searchByPhone(contact);
	}

}
