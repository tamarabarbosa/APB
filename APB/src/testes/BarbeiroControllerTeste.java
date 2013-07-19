package testes;

import static org.junit.Assert.*;
import java.sql.SQLException;
import model.Barbeiro;
import org.junit.Before;
import org.junit.Test;
import control.BarbeiroController;
import exception.BarbeiroException;

public class BarbeiroControllerTeste {

	Barbeiro barbeiro = new Barbeiro();

	@Before
	public void setUp() {
		try {
			barbeiro.setNome("Alessandro");
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
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getInstanceDeBarbeiroControlerDeveRetonarInstanciaCorrente() {
		BarbeiroController barbeiroController = BarbeiroController
				.getInstance();
		assertEquals(BarbeiroController.getInstance(), barbeiroController);
	}

	@Test
	public void inserirDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		BarbeiroController barbeiroController = BarbeiroController
				.getInstance();
		try {
			assertTrue(barbeiroController.inserir(barbeiro));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void excluirDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		BarbeiroController barbeiroController = BarbeiroController
				.getInstance();
		try {
			assertTrue(barbeiroController.excluir(barbeiro));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void alterarDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		BarbeiroController barbeiroController = BarbeiroController
				.getInstance();
		try {
			assertTrue(barbeiroController.alterar(barbeiro));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void inserirBarbeiroNãoPodePassarBarbeiroNullo(){
		BarbeiroController barbeiroController = BarbeiroController
				.getInstance();
		try {
			assertFalse(barbeiroController.inserir(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void excluirBarbeiroNãoPodePassarBarbeiroNullo(){
		BarbeiroController barbeiroController = BarbeiroController
				.getInstance();
		try {
			assertFalse(barbeiroController.excluir(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void alterarBarbeiroNãoPodePassarBarbeiroNullo(){
		BarbeiroController barbeiroController = BarbeiroController
				.getInstance();
		try {
			assertFalse(barbeiroController.alterar(null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
