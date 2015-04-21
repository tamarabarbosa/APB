package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Barbeiro;

import org.junit.Before;
import org.junit.Test;

import control.BarbeiroController;
import exception.BarbeiroException;

public class BarberControllerTest {

	Barbeiro barber = new Barbeiro();

	@Before
	public void setUp() {
		try {
			barber.setNome("Alessandro");
			barber.setRg("418757896");
			barber.setTelefone("3389-9085");
			barber.setCpf("02919594150");
			barber.setCadeira("5");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	BarbeiroController barberController = BarbeiroController.getInstance();

	@Test
	public void getInstanceDeBarbeiroControlerDeveRetonarInstanciaCorrente() {
		assertEquals(BarbeiroController.getInstance(), barberController);
	}

	@Test
	public void inserirDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		try {
			assertTrue(barberController.inserir(barber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		try {
			assertTrue(barberController.delete(barber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		try {
			assertTrue(barberController.change(barber.getNome(), barber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void inserirBarbeiroNaoPodePassarBarbeiroNullo() {
		try {
			assertFalse(barberController.inserir(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteBarbeiroNaoPodePassarBarbeiroNullo() {
		try {
			assertFalse(barberController.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeBarbeiroNaoPodePassarBarbeiroNullo() {
		try {
			assertFalse(barberController.change(null, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void procurarPorBarbeiroControllerDeveMostrarUmBarbeiro() throws SQLException {
		ResultSet rs = barberController.pesquisar();
		while (rs.next());
	}

	@Test
	public void mostrarBarbeirosDeBarbeiroControllerDeveMostrarUmBarbeiro() throws SQLException {
		ResultSet rs = barberController.mostrarBarbeirosCadastrados(barber);
		while(rs.next());
	}

	@Test
	public void pesquisarPorNomeDeBarbeiroControllerDeveMostrarUmBarbeiro() throws SQLException {
		ResultSet rs = barberController.pesquisarPorNome(barber);
		while(rs.next());
	}
}
