package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.TipoServico;

import org.junit.Before;
import org.junit.Test;

import view.AlterarContato;

import control.AgendaController;
import control.ServicoPrestadoController;
import control.TipoServicoController;
import exception.ServicoException;

public class TipoServicoControllerTeste {

	TipoServico tipoServico = new TipoServico();
	
	@Before
	public void setUp(){
		try {
			tipoServico.setNomeTipoServico("Corte");
			tipoServico.setPreco("15,00");
		} catch (ServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getInstanceDeTipoServicoControllerDeveRetornarInstanciaCorrente() {
		TipoServicoController tipoServicoController = TipoServicoController.getInstance();
		assertEquals(TipoServicoController.getInstance(), tipoServicoController);
	}

	@Test
	public void inserirDeTipoServicoControllerDeveEnviarUmTipoServico() {
		TipoServicoController tipoServicoController = TipoServicoController.getInstance();
		try {
			assertTrue(tipoServicoController.inserir(tipoServico));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void excluirDeTipoServicoControllerDeveRemoverUmTipoServico() {
		TipoServicoController tipoServicoController = TipoServicoController.getInstance();
		try {
			assertTrue(tipoServicoController.excluir(tipoServico));
		} catch (SQLException e) {
		}

	}

	@Test
	public void alterarDeTipoServicoControllerDeveAlterarUmTipoServico() {
		TipoServicoController tipoServicoController = TipoServicoController.getInstance();
		try {
			assertTrue(tipoServicoController.alterar(tipoServico));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void inserirTipoServicoNãoPodePassarTipoServicoNullo() {
		TipoServicoController tipoServicoController = TipoServicoController.getInstance();
		try {
			assertFalse(tipoServicoController.inserir(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void excluirTipoServicoNãoPodePassarTipoServicoNullo() {
		TipoServicoController tipoServicoController = TipoServicoController.getInstance();
		try {
			assertFalse(tipoServicoController.excluir(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void alterarTipoServicoNãoPodePassarTipoServicoNullo() {
		TipoServicoController tipoServicoController = TipoServicoController.getInstance();
		try {
			assertFalse(tipoServicoController.alterar(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
