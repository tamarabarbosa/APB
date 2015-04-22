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

	Phonebook contato = new Phonebook();

	@Before
	public void setUp() {
		try {
			contato.setNome("Corte");
			contato.setTelefone("3895-5698");
			contato.setDescricao("AAA");
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
			assertTrue(phonebookController.insert(contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void deleteDePhonebookControllerDeveEnviarUmaPhonebook() {
		try {
			assertTrue(phonebookController.delete(contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDePhonebookControllerDeveEnviarUmaPhonebookAlterada() {
		try {
			assertTrue(phonebookController.change(contato.getNome(),contato));
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
		ResultSet rs = phonebookController.mostrarContatosCadastrados(contato);
		while(rs.next());
	}

	@Test
	public void searchByNomeDePhonebookControllerDeveMostrarUmContato() throws SQLException {
		ResultSet rs = phonebookController.searchByNome(contato);
		while(rs.next());
	}

	@Test
	public void searchByTelefoneDePhonebookControllerDeveMostrarUmContato() throws SQLException {
		ResultSet rs = phonebookController.searchByTelefone(contato);
		while(rs.next());
	}

}
