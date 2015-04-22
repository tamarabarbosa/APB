package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			barber.setNome("Alessandro");
			barber.setRg("418757896");
			barber.setPhone("3389-9085");
			barber.setCpf("02919594150");
			barber.setCadeira("5");
			barber2.setNome("Luciano");
			barber2.setRg("418757896");
			barber2.setPhone("3389-9085");
			barber2.setCpf("02919594150");
			barber2.setCadeira("5");

			BarberDAO barberDao = BarberDAO.getInstance();
			barberDao.insert(barber);
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
	}

	@Test
	public void insertDeBarberDAODeveCadastrarUmBarber() {
		try {
			assertTrue(barberDAO.insert(barber));

			Connection connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery("SELECT name FROM barber WHERE "
					+ " name = \"" + barber.getNome() + "\";");
			rs.next();
			assertEquals("Alessandro", rs.getString("name"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = AssertionError.class)
	public void deleteDeBarberDAODeveEnviarUmBarber() {
		try {
			assertTrue(barberDAO.delete(barber));

			Connection connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery("SELECT name FROM barber WHERE "
					+ " name = \"" + barber.getNome() + "\";");
			rs.next();
			fail();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeBarberDaoDeveAlterarUmBarber() {
		try {
			assertTrue(barberDAO.change(barber.getNome(), barber, barber2));

			barberDAO.change(barber.getCpf(),barber2, barber);
			Connection connection = FactoryConnection.getInstance().getConnection();
			java.sql.PreparedStatement pst1 = connection.prepareStatement("SELECT name FROM barber WHERE "
							+ " name = \"" + barber.getNome() + "\";");

			ResultSet rs = pst1.executeQuery();

			while(rs.next())
				assertEquals("Alessandro", rs.getString("name"));

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertDeBarberDAOPassandoUmBarberNulo() {
		try {
			assertFalse(barberDAO.insert(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeBarberDAOPassandoUmBarberNulo() {
		try {
			assertFalse(barberDAO.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeBarberDaoPassandoUmBarberNulo() {
		try {
			assertFalse(barberDAO.change(barber.getNome(), null, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeBarberDaoPassandoUmBarberAlteradoNulo() {
		try {
			assertFalse(barberDAO.change(barber.getNome(), null, barber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pesquisarDeBarberDAODeveMostrarUmBarber() {
		try {
			ResultSet rs = barberDAO.pesquisar();

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarBarbersCadastradosDeBarberDAODeveMostrarBarbers() {
		try {
			ResultSet rs = barberDAO.mostrarBarbersCadastrados(barber);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void searchByNomeDeBarberDAODeveMostrarBarbers() {
		try {
			ResultSet rs = barberDAO.searchByNome(barber);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}