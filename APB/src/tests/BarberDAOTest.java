package tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Barbeiro;

import org.junit.Before;
import org.junit.Test;

import dao.BarbeiroDAO;
import dao.FactoryConnection;
import exception.BarbeiroException;

public class BarberDAOTest {

	Barbeiro barber = new Barbeiro();
	Barbeiro barber2 = new Barbeiro();
	@Before
	public void setUp() {
		try {
			barber.setNome("Alessandro");
			barber.setRg("418757896");
			barber.setTelefone("3389-9085");
			barber.setCpf("02919594150");
			barber.setCadeira("5");
			barber2.setNome("Luciano");
			barber2.setRg("418757896");
			barber2.setTelefone("3389-9085");
			barber2.setCpf("02919594150");
			barber2.setCadeira("5");

			BarbeiroDAO barberDao = BarbeiroDAO.getInstance();
			barberDao.insert(barber);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarbeiroException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	BarbeiroDAO barberDAO = BarbeiroDAO.getInstance();

	@Test
	public void getInstanceDeBarbeiroDAODeveRetonarInstanciaCorrente() {
		assertEquals(BarbeiroDAO.getInstance(), barberDAO);
	}

	@Test
	public void inserirDeBarbeiroDAODeveCadastrarUmBarbeiro() {
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
	public void deleteDeBarbeiroDAODeveEnviarUmBarbeiro() {
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
	public void changeDeBarbeiroDaoDeveAlterarUmBarbeiro() {
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
	public void inserirDeBarbeiroDAOPassandoUmBarbeiroNulo() {
		try {
			assertFalse(barberDAO.insert(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeBarbeiroDAOPassandoUmBarbeiroNulo() {
		try {
			assertFalse(barberDAO.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeBarbeiroDaoPassandoUmBarbeiroNulo() {
		try {
			assertFalse(barberDAO.change(barber.getNome(), null, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeBarbeiroDaoPassandoUmBarbeiroAlteradoNulo() {
		try {
			assertFalse(barberDAO.change(barber.getNome(), null, barber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pesquisarDeBarbeiroDAODeveMostrarUmBarbeiro() {
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
	public void mostrarBarbeirosCadastradosDeBarbeiroDAODeveMostrarBarbeiros() {
		try {
			ResultSet rs = barberDAO.mostrarBarbeirosCadastrados(barber);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pesquisarPorNomeDeBarbeiroDAODeveMostrarBarbeiros() {
		try {
			ResultSet rs = barberDAO.pesquisarPorNome(barber);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}