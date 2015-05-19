package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Barber;

import org.junit.Before;
import org.junit.Test;

import control.BarberController;
import exception.BarberException;
import java.util.logging.Logger;

public class BarberControllerTest {

	Barber barber = new Barber();

	@Before
	public void setUp() {
		try {
			barber.setName("Alessandro");
			barber.setRg("418757896");
			barber.setPhoneNumber("3389-9085");
			barber.setCpf("02919594150");
			barber.setChair("5");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarberException e) {
			e.printStackTrace();
		}
	}

	BarberController barberController = BarberController.getInstance();

	@Test
	public void getInstanceDeBarberControlerDeveRetonarInstanciaCorrente() {
		assertEquals(BarberController.getInstance(), barberController);
	}

	@Test
	public void insertDeBarberControllerDeveEnviarUmBarber() {
		try {
			assertTrue(barberController.insert(barber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeBarberControllerDeveEnviarUmBarber() {
		try {
			assertTrue(barberController.delete(barber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeBarberControllerDeveEnviarUmBarber() {
		try {
			assertTrue(barberController.modifyBarber(barber.getName(), barber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertBarberNaoPodePassarBarberNullo() {
		try {
			assertFalse(barberController.insert(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteBarberNaoPodePassarBarberNullo() {
		try {
			assertFalse(barberController.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeBarberNaoPodePassarBarberNullo() {
		try {
			assertFalse(barberController.modifyBarber(null, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void procurarPorBarberControllerDeveMostrarUmBarber()
			throws SQLException {
		ResultSet rs = barberController.searchBarbers();
		while (rs.next())
			;
	}

	@Test
	public void mostrarBarbersDeBarberControllerDeveMostrarUmBarber()
			throws SQLException {
		ResultSet rs = barberController.showRegisteredBarbers(barber);
		while (rs.next())
			;
	}

	@Test
	public void searchByNomeDeBarberControllerDeveMostrarUmBarber()
			throws SQLException {
		ResultSet rs = barberController.searchBarberByName(barber);
		while (rs.next())
			;
	}
}
