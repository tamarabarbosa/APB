package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Phonebook;

import org.junit.Test;

import dao.PhonebookDAO;

public class PhonebookDAOTest {

	Phonebook contact = new Phonebook();
	Phonebook contact2 = new Phonebook();
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
			assertTrue(phonebookDAO.change(contact.getNome(),contact, contact2));
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
			assertFalse(phonebookDAO.change(contact.getNome(),contact, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDePhonebookDAOPassandoUmPhonebookAleradoNulo() {
		try {
			assertFalse(phonebookDAO.change(contact.getNome(), null, contact));
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
