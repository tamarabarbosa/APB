package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Contact;

import org.junit.Test;

import dao.PhonebookDAO;

public class PhonebookDAOTest {

	Contact contact = new Contact();
	Contact contact2 = new Contact();
	PhonebookDAO phonebookDAO = PhonebookDAO.getInstance();

	@Test
	public void getInstanceDePhonebookDAODeveRetonarInstanciaCorrente() {
		assertEquals(PhonebookDAO.getInstance(), phonebookDAO);
	}

	@Test
	public void insertDePhonebookDAODeveCadastrarUmContato() {
		try {
			assertTrue(phonebookDAO.insert(contact));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDePhonebookDAODeveEnviarUmPhonebook() {
		try {
			assertTrue(phonebookDAO.delete(contact));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDePhonebookDAODeveEnviarUmContato() {
		try {
			assertTrue(phonebookDAO
					.change(contact.getName(), contact, contact2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertDePhonebookDAOPassandoUmContatoNulo() {
		try {
			assertFalse(phonebookDAO.insert(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDePhonebookDAOPassandoUmContatoNulo() {
		try {
			assertFalse(phonebookDAO.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDePhonebookDAOPassandoUmContatoNulo() {
		try {
			assertFalse(phonebookDAO.change(contact.getName(), contact, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDePhonebookDAOPassandoUmPhonebookAleradoNulo() {
		try {
			assertFalse(phonebookDAO.change(contact.getName(), null, contact));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarContatosPhonebookDAODeveMostrarContato() {
		try {
			ResultSet rs = phonebookDAO.mostrarContatosCadastrados(contact);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pesquisaPorNomeDePhonebookDAODeveMostrarContato() {
		try {
			ResultSet rs = phonebookDAO.searchByNome(contact);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void searchByPhoneDeBarberDAODeveMostrarBarbers() {
		try {
			ResultSet rs = phonebookDAO.searchByPhone(contact);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
