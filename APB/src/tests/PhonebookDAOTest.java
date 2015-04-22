package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Phonebook;

import org.junit.Test;

import dao.PhonebookDAO;

public class PhonebookDAOTest {

	Phonebook contato = new Phonebook();
	Phonebook contato2 = new Phonebook();
	PhonebookDAO phonebookDAO = PhonebookDAO.getInstance();

	@Test
	public void getInstanceDePhonebookDAODeveRetonarInstanciaCorrente() {
		assertEquals(PhonebookDAO.getInstance(), phonebookDAO);
	}

	@Test
	public void insertDePhonebookDAODeveCadastrarUmContato() {
		try {
			assertTrue(phonebookDAO.insert(contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDePhonebookDAODeveEnviarUmPhonebook() {
		try {
			assertTrue(phonebookDAO.delete(contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDePhonebookDAODeveEnviarUmContato() {
		try {
			assertTrue(phonebookDAO.change(contato.getNome(),contato, contato2));
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
			assertFalse(phonebookDAO.change(contato.getNome(),contato, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDePhonebookDAOPassandoUmPhonebookAleradoNulo() {
		try {
			assertFalse(phonebookDAO.change(contato.getNome(), null, contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarContatosPhonebookDAODeveMostrarContato() {
		try {
			ResultSet rs = phonebookDAO.mostrarContatosCadastrados(contato);

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
			ResultSet rs = phonebookDAO.searchByNome(contato);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void searchByTelefoneDeBarberDAODeveMostrarBarbers() {
		try {
			ResultSet rs = phonebookDAO.searchByTelefone(contato);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
