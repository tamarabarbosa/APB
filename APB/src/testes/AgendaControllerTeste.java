package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.Agenda;

import org.junit.Before;
import org.junit.Test;

import view.AlterarContato;

import control.AgendaController;
import exception.BarbeiroException;

public class AgendaControllerTeste {

	Agenda agenda = new Agenda();

	@Before
	public void setUp() {
		try {
			agenda.setNome("Corte");
			agenda.setTelefone("3895-5698");
			agenda.setDescricao("AAA");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getInstanceDeAgendaControllerDeveRetornarInstanciaCorrente() {
		AgendaController agendaController = AgendaController.getInstance();
		assertEquals(AgendaController.getInstance(), agendaController);
	}

	@Test
	public void inserirDeAgendaControllerDeveEnviarUm() {
		AgendaController agendaController = AgendaController.getInstance();
		try {
			assertTrue(agendaController.incluir(agenda));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void excluirDeAgendaControllerDeveEnviarUmaAgenda() {
		AgendaController agendaController = AgendaController.getInstance();
		try {
			assertTrue(agendaController.excluir(agenda));
		} catch (SQLException e) {
		}

	}

	@Test
	public void alterarDeAgendaControllerDeveEnviarUmaAgenda() {
		AgendaController agendaController = AgendaController.getInstance();
		try {
			AlterarContato.setTelefoneAntigo("3895-5698");
			assertTrue(agendaController.alterar(agenda));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void inserirAgendaNãoPodePassarAgendaNullo() {
		AgendaController agendaController = AgendaController.getInstance();
		try {
			assertFalse(agendaController.incluir(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void excluirAgendaNãoPodePassarAgendaNullo() {
		AgendaController agendaController = AgendaController.getInstance();
		try {
			assertFalse(agendaController.excluir(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void alterarAgendaNãoPodePassarAgendaNullo() {
		AgendaController agendaController = AgendaController.getInstance();
		try {
			assertFalse(agendaController.alterar(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
