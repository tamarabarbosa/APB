package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Phonebook;

import org.junit.Test;

import dao.AgendaDAO;

public class PhonebookDAOTest {

	Phonebook contato = new Phonebook();
	Phonebook contato2 = new Phonebook();
	AgendaDAO agendaDAO = AgendaDAO.getInstance();

	@Test
	public void getInstanceDeAgendaDAODeveRetonarInstanciaCorrente() {
		assertEquals(AgendaDAO.getInstance(), agendaDAO);
	}

	@Test
	public void inserirDeAgendaDAODeveCadastrarUmContato() {
		try {
			assertTrue(agendaDAO.insert(contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeAgendaDAODeveEnviarUmAgenda() {
		try {
			assertTrue(agendaDAO.delete(contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeAgendaDAODeveEnviarUmContato() {
		try {
			assertTrue(agendaDAO.change(contato.getNome(),contato, contato2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void inserirDeAgendaDAOPassandoUmContatoNulo() {
		try {
			assertFalse(agendaDAO.insert(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeAgendaDAOPassandoUmContatoNulo() {
		try {
			assertFalse(agendaDAO.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeAgendaDAOPassandoUmContatoNulo() {
		try {
			assertFalse(agendaDAO.change(contato.getNome(),contato, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeAgendaDAOPassandoUmAgendaAleradoNulo() {
		try {
			assertFalse(agendaDAO.change(contato.getNome(), null, contato));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarContatosAgendaDAODeveMostrarContato() {
		try {
			ResultSet rs = agendaDAO.mostrarContatosCadastrados(contato);

			while (rs.next()) {
				String nome = rs.getString("nome");
				assertNotNull(nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pesquisaPorNomeDeAgendaDAODeveMostrarContato() {
		try {
			ResultSet rs = agendaDAO.pesquisarPorNome(contato);

			while (rs.next()) {
				String nome = rs.getString("nome");
				assertNotNull(nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pesquisarPorTelefoneDeBarbeiroDAODeveMostrarBarbeiros() {
		try {
			ResultSet rs = agendaDAO.pesquisarPorTelefone(contato);

			while (rs.next()) {
				String nome = rs.getString("nome");
				assertNotNull(nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
