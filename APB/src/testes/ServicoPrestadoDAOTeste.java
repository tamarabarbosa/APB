package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.ServicoPrestado;

import org.junit.Before;
import org.junit.Test;

import dao.ServicoPrestadoDAO;
import exception.ServicoException;

public class ServicoPrestadoDAOTeste {

	ServicoPrestado servico = new ServicoPrestado();
	ServicoPrestado servico2 = new ServicoPrestado();
	@Before
	public void setUp() {
		try {
			servico.setNomeServico("Corte");
			servico.setNomeBarbeiro("Alessandro");
			servico.setData("2010/10/10");
			servico.setPreco("10,00");
			servico2.setNomeServico("Barba");
			servico2.setNomeBarbeiro("Luciano");
			servico2.setData("2001/01/01");
			servico2.setPreco("9,90");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ServicoException e) {
			e.printStackTrace();
		}
	}

	ServicoPrestadoDAO servicoDAO = ServicoPrestadoDAO.getInstance();
	
	@Test
	public void getInstanceDeServicoPrestadoDAODeveRetonarInstanciaCorrente() {
		assertEquals(ServicoPrestadoDAO.getInstance(), servicoDAO);
	}

	@Test
	public void inserirDeServicoPrestadoDAODeveCadastrarUmServicoPrestado() {
		try {
			assertTrue(servicoDAO.incluir(servico));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void excluirDeServicoPrestadoDAODeveEnviarUmServicoPrestado() {
		try {
			assertTrue(servicoDAO.excluir(servico));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void inserirDeServicoPrestadoDAOPassandoUmServicoNulo() {
		try {
			assertFalse(servicoDAO.incluir(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void excluirDeServicoPrestadoDAOPassandoUmServicoNulo() {
		try {
			assertFalse(servicoDAO.excluir(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
