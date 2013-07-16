package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.ServicoPrestado;

import org.junit.Before;
import org.junit.Test;

import view.AlterarContato;

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

	@Test
	public void getInstanceDeServicoPrestadoControllerDeveRetornarInstanciaCorrente() {
		ServicoPrestadoController servicoprestadoController = ServicoPrestadoController
				.getInstance();
		assertEquals(ServicoPrestadoController.getInstance(),
				servicoprestadoController);
	}

	@Test
	public void inserirDeServicoPrestadoControllerDeveEnviarUm() {
		ServicoPrestadoController servicoprestadoController = ServicoPrestadoController
				.getInstance();
		try {
			assertTrue(servicoprestadoController.inserir(servico));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void excluirDeServicoPrestadoControllerDeveEnviarUmaservicoprestado() {
		ServicoPrestadoController servicoprestadoController = ServicoPrestadoController
				.getInstance();
		try {
			assertTrue(servicoprestadoController.excluir(servico));
		} catch (SQLException e) {
		}

	}

	@Test
	public void inserirServicoPrestadoNãoPodePassarServicoPrestadoNullo() {
		ServicoPrestadoController servicoprestadoController = ServicoPrestadoController
				.getInstance();
		try {
			assertFalse(servicoprestadoController.inserir(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void excluirServicoPrestadoNãoPodePassarServicoPrestadoNullo() {
		ServicoPrestadoController servicoprestadoController = ServicoPrestadoController
				.getInstance();
		try {
			assertFalse(servicoprestadoController.excluir(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
