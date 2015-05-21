package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Contact;
import model.Phonebook;

import org.junit.Before;
import org.junit.Test;

import control.ContactController;
import exception.BarberException;

public class PhonebookControllerTest {

	Contact contact = new Contact();

	@Before
	public void setUp() {
		try {
			contact.setName("Corte");
			contact.setPhoneNumber("3895-5698");
			contact.setDescription("AAA");
		} catch (BarberException e) {
			e.printStackTrace();
		}
	}

	ContactController phonebookController = ContactController.getInstance();

	@Test
	public void getInstanceDePhonebookControllerDeveRetornarInstanciaCorrente() {
		assertEquals(ContactController.getInstance(), phonebookController);
	}

	@Test
	public void insertDePhonebookControllerDeveEnviarUm() {
		try {
			assertTrue(phonebookController.include(contact));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void deleteDePhonebookControllerDeveEnviarUmaPhonebook() {
		try {
			assertTrue(phonebookController.delete(contact));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDePhonebookControllerDeveEnviarUmaPhonebookAlterada() {
		try {
			assertTrue(phonebookController.change(contact.getName(), contact));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertPhonebookNaoPodePassarPhonebookNullo() {
		try {
			assertFalse(phonebookController.include(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deletePhonebookNaoPodePassarPhonebookNullo() {
		try {
			assertFalse(phonebookController.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changePhonebookNaoPodePassarPhonebookNullo() {
		try {
			assertFalse(phonebookController.change(null, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarContatosDePhonebookControllerDeveMostrarUmContato()
			throws SQLException {
		ResultSet rs = phonebookController.showContactsRegistered(contact);
		while (rs.next())
			;
	}

	@Test
	public void searchByNomeDePhonebookControllerDeveMostrarUmContato()
			throws SQLException {
		ResultSet rs = phonebookController.searchByName(contact);
		while (rs.next())
			;
	}

	@Test
	public void searchByPhoneDePhonebookControllerDeveMostrarUmContato()
			throws SQLException {
		ResultSet rs = phonebookController.searchByPhonebook(contact);
		while (rs.next())
			;
	}

}
