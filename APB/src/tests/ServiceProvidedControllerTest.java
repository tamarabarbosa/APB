package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.ServicoPrestado;

import org.junit.Before;
import org.junit.Test;

import control.ServicoPrestadoController;
import exception.ServicoException;

public class ServiceProvidedControllerTest {
	ServicoPrestado servico = new ServicoPrestado();
	ServicoPrestadoController servicoController = ServicoPrestadoController.getInstance();

	@Before
	public void setUp() throws ServicoException, ParseException {
		servico.setNomeServico("Corte");
		servico.setNomeBarbeiro("Joao");
		servico.setPreco("125,23");
		servico.setData("20/12/2013");

	}

	@Test
	public void getInstanceDeServicoPrestadoControllerDeveRetornarInstanciaCorrente() {
		assertEquals(ServicoPrestadoController.getInstance(), servicoController);
	}

	@Test
	public void inserirDeServicoPrestadoControllerDeveEnviarUm() {
		try {
			assertTrue(servicoController.inserir(servico));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeServicoPrestadoControllerDeveEnviarUmaservicoprestado() {
		try {
			assertTrue(servicoController.delete(servico));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void inserirServicoPrestadoNaoPodePassarServicoPrestadoNullo() {
		try {
			assertFalse(servicoController.inserir(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteServicoPrestadoNaoPodePassarServicoPrestadoNullo() {
		try {
			assertFalse(servicoController.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarServicoPrestadoDeServicoPrestadoControllerDeveMostrarUmServico() throws SQLException {
		ResultSet rs = servicoController.mostrarServicosPrestadosCadastrados(servico);
		while(rs.next());
	}
}
