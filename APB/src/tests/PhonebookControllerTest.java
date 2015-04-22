package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Phonebook;

import org.junit.Before;
import org.junit.Test;

import control.PhonebookController;
import exception.BarberException;

public class PhonebookControllerTest {

	Phonebook contact = new Phonebook();

	@Before
	public void setUp() {
		try {
			contact.setNome("Corte");
			contact.setPhone("3895-5698");
			contact.setDescricao("AAA");
		} catch (BarberException e) {
			e.printStackTrace();
		}
	}

	PhonebookController phonebookController = PhonebookController.getInstance();

	@Test
	public void getInstanceDePhonebookControllerDeveRetornarInstanciaCorrente() {
		assertEquals(PhonebookController.getInstance(), phonebookController);
	}

	@Test
	public void insertDePhonebookControllerDeveEnviarUm() {
		try {
			assertTrue(phonebookController.insert(contact));
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
			assertTrue(phonebookController.change(contact.getNome(),contact));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertPhonebookNaoPodePassarPhonebookNullo() {
		try {
			assertFalse(phonebookController.insert(null));
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
			assertFalse(phonebookController.change(null,null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarContatosDePhonebookControllerDeveMostrarUmContato() throws SQLException {
		ResultSet rs = phonebookController.mostrarContatosCadastrados(contact);
		while(rs.next());
	}

	@Test
	public void searchByNomeDePhonebookControllerDeveMostrarUmContato() throws SQLException {
		ResultSet rs = phonebookController.searchByNome(contact);
		while(rs.next());
	}

	@Test
	public void searchByPhoneDePhonebookControllerDeveMostrarUmContato() throws SQLException {
		ResultSet rs = phonebookController.searchByPhone(contact);
		while(rs.next());
	}

}
