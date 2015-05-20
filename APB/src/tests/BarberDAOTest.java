package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import model.Barber;

import org.junit.Before;
import org.junit.Test;

import dao.BarberDAO;
import dao.FactoryConnection;
import exception.BarberException;

public class BarberDAOTest {

	Barber barber = new Barber();
	Barber barber2 = new Barber();
	@Before
	public void setUp() {
		try {
			barber.setName("Alessandro");
			barber.setRg("418757896");
			barber.setName("3389-9085");
			barber.setCpf("02919594150");
			barber.setChair("5");
			barber2.setName("Luciano");
			barber2.setRg("418757896");
			barber2.setName("3389-9085");
			barber2.setCpf("02919594150");
			barber2.setChair("5");

			BarberDAO barberDao = BarberDAO.getInstance();
			barberDao.includeBarber(barber);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarberException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	BarberDAO barberDAO = BarberDAO.getInstance();

	@Test
	public void getInstanceDeBarberDAODeveRetonarInstanciaCorrente() {
		assertEquals(BarberDAO.getInstance(), barberDAO);
		
		Logger.getLogger("barber created");
	}
		
	@Test
	public void insertDeBarberDAODeveCadastrarUmBarber() {
		try {
			assertTrue(barberDAO.includeBarber(barber));

			Connection connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery("SELECT name FROM barber WHERE "
					+ " name = \"" + barber.getName() + "\";");
			rs.next();
			assertEquals("Alessandro", rs.getString("name"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Logger.getLogger("barber was cadastrate");
		
	}

	@Test (expected = AssertionError.class)
	public void deleteDeBarberDAODeveEnviarUmBarber() {
		try {
			assertTrue(barberDAO.deleteBarber(barber));

			Connection connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery("SELECT name FROM barber WHERE "
					+ " name = \"" + barber.getName() + "\";");
			rs.next();
			fail();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Logger.getLogger("barber was delete ");
	}
	

	@Test
	public void changeDeBarberDaoDeveAlterarUmBarber() {
		try {
			assertTrue(barberDAO.changeBarber(barber.getName(), barber, barber2));

			barberDAO.changeBarber(barber.getCpf(),barber2, barber);
			Connection connection = FactoryConnection.getInstance().getConnection();
			java.sql.PreparedStatement pst1 = connection.prepareStatement("SELECT name FROM barber WHERE "
							+ " name = \"" + barber.getName() + "\";");

			ResultSet rs = pst1.executeQuery();

			while(rs.next())
				assertEquals("Alessandro", rs.getString("name"));

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Logger.getLogger("barber changed");
	}

	@Test
	public void insertDeBarberDAOPassandoUmBarberNulo() {
		try {
			assertFalse(barberDAO.includeBarber(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Logger.getLogger("barber null is insert");
	}

	@Test
	public void deleteDeBarberDAOPassandoUmBarberNulo() {
		try {
			assertFalse(barberDAO.deleteBarber(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Logger.getLogger("delete barber null is right");
	}

	@Test
	public void changeDeBarberDaoPassandoUmBarberNulo() {
		try {
			assertFalse(barberDAO.changeBarber(barber.getName(), null, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Logger.getLogger("barber null is changed");
	}

	@Test
	public void changeDeBarberDaoPassandoUmBarberAlteradoNulo() {
		try {
			assertFalse(barberDAO.changeBarber(barber.getName(), null, barber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pesquisarDeBarberDAODeveMostrarUmBarber() {
		try {
			ResultSet rs = barberDAO.search();

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Logger.getLogger("barber is shows");
	}

	@Test
	public void mostrarBarbersCadastradosDeBarberDAODeveMostrarBarbers() {
		try {
			ResultSet rs = barberDAO.showRegisteredBarber(barber);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Logger.getLogger("show the barber registered");
	}

	@Test
	public void searchByNomeDeBarberDAODeveMostrarBarbers() {
		try {
			ResultSet rs = barberDAO.searchByName(barber);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Logger.getLogger("show the barber by name is right");
	}

}