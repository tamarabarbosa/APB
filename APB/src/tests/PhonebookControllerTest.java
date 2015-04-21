package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Phonebook;

import org.junit.Before;
import org.junit.Test;

import control.AgendaController;
import exception.BarbeiroException;

public class PhonebookControllerTest {

	Phonebook contato = new Phonebook();

	@Before
	public void setUp() {
		try {
			contato.setNome("Corte");
			contato.setTelefone("3895-5698");
			contato.setDescricao("AAA");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	AgendaController agendaController = AgendaController.getInstance();

	@Test
	public void getInstanceDeAgendaControllerDeveRetornarInstanciaCorrente() {
		assertEquals(AgendaController.getInstance(), agendaController);
	}

	@Test
	public void inserirDeAgendaControllerDeveEnviarUm() {
		try {
			assertTrue(agendaController.insert(contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void deleteDeAgendaControllerDeveEnviarUmaAgenda() {
		try {
			assertTrue(agendaController.delete(contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeAgendaControllerDeveEnviarUmaAgendaAlterada() {
		try {
			assertTrue(agendaController.change(contato.getNome(),contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void inserirAgendaNaoPodePassarAgendaNullo() {
		try {
			assertFalse(agendaController.insert(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteAgendaNaoPodePassarAgendaNullo() {
		try {
			assertFalse(agendaController.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeAgendaNaoPodePassarAgendaNullo() {
		try {
			assertFalse(agendaController.change(null,null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarContatosDeAgendaControllerDeveMostrarUmContato() throws SQLException {
		ResultSet rs = agendaController.mostrarContatosCadastrados(contato);
		while(rs.next());
	}

	@Test
	public void pesquisarPorNomeDeAgendaControllerDeveMostrarUmContato() throws SQLException {
		ResultSet rs = agendaController.pesquisarPorNome(contato);
		while(rs.next());
	}

	@Test
	public void pesquisarPorTelefoneDeAgendaControllerDeveMostrarUmContato() throws SQLException {
		ResultSet rs = agendaController.pesquisarPorTelefone(contato);
		while(rs.next());
	}

}
