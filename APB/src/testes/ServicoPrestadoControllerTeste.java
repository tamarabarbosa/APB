package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.ServicoPrestado;

import org.junit.Before;
import org.junit.Test;

import control.ServicoPrestadoController;
import exception.ServicoException;

public class ServicoPrestadoControllerTeste {
	ServicoPrestado servico = new ServicoPrestado();
	ServicoPrestadoController servicoController = ServicoPrestadoController
			.getInstance();

	@Before
	public void setUp() throws ServicoException {
		servico.setNomeServico("Corte");
		servico.setNomeBarbeiro("Joao");
		servico.setPreco("125,23");
		servico.setData("20/12/13");

	}

	ServicoPrestadoController servicoprestadoController = ServicoPrestadoController.getInstance();
	
	@Test
	public void getInstanceDeServicoPrestadoControllerDeveRetornarInstanciaCorrente() {
		assertEquals(ServicoPrestadoController.getInstance(), servicoprestadoController);
	}

	@Test
	public void inserirDeServicoPrestadoControllerDeveEnviarUm() {
		try {
			assertTrue(servicoprestadoController.inserir(servico));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void excluirDeServicoPrestadoControllerDeveEnviarUmaservicoprestado() {
		try {
			assertTrue(servicoprestadoController.excluir(servico));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void inserirServicoPrestadoNãoPodePassarServicoPrestadoNullo() {
		try {
			assertFalse(servicoprestadoController.inserir(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void excluirServicoPrestadoNãoPodePassarServicoPrestadoNullo() {
		try {
			assertFalse(servicoprestadoController.excluir(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
