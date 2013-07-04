package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.Barbeiro;

import org.junit.Before;
import org.junit.Test;

import control.BarbeiroController;

import dao.BarbeiroDAO;

import exception.BarbeiroException;

public class BarbeiroDAOTeste {

	Barbeiro barbeiro = new Barbeiro();
	Barbeiro barbeiro2 = new Barbeiro();
	@Before
	public void setUp() {
		try {
			barbeiro.setNome("Alessandro");
			barbeiro2.setNome("Luciano");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

		try {
			barbeiro.setRg("418757896");
			barbeiro.setTelefone("3389-9085");
			barbeiro.setCpf("02919594150");
			barbeiro.setCadeira("5");
			barbeiro2.setRg("418757896");
			barbeiro2.setTelefone("3389-9085");
			barbeiro2.setCpf("02919594150");
			barbeiro2.setCadeira("5");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getInstanceDeBarbeiroDAODeveRetonarInstanciaCorrente() {
		BarbeiroDAO barbeiroDAO = BarbeiroDAO.getInstance();
		assertEquals(BarbeiroDAO.getInstance(), barbeiroDAO);
	}

	@Test
	public void inserirDeBarbeiroDAODeveCadastrarUmBarbeiro() {
		BarbeiroDAO barbeiroDAO = BarbeiroDAO.getInstance();
		try {
			assertTrue(barbeiroDAO.incluir(barbeiro));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void excluirDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		BarbeiroDAO barbeiroDAO = BarbeiroDAO.getInstance();
		try {
			assertTrue(barbeiroDAO.excluir(barbeiro));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void alterarDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		BarbeiroDAO barbeiroDAO = BarbeiroDAO.getInstance();
		try {
			assertTrue(barbeiroDAO.alterar(barbeiro, barbeiro2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}