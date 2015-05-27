package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;

import model.DoneService;

import org.junit.Before;
import org.junit.Test;

import dao.DoneServiceDAO;
import exception.ServiceException;

public class ServiceProvidedDAOTest {

	DoneService job = new DoneService();
	DoneService job2 = new DoneService();

	@Before
	public void setUp() {
		try {
			job.setServiceName("Corte");
			job.setServiceName("Alessandro");
			job.setDate("10/10/2010");
			job.setPrice("10,00");
			job2.setServiceName("Barba");
			job2.setServiceName("Luciano");
			job2.setDate("01/01/2010");
			job2.setPrice("9,90");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	DoneServiceDAO jobDAO = DoneServiceDAO.getInstance();

	@Test
	public void getInstanceDeJobPrestadoDAODeveRetonarInstanciaCorrente() {
		assertEquals(DoneServiceDAO.getInstance(), jobDAO);
	}

	@Test
	public void insertDeJobPrestadoDAODeveCadastrarUmJobPrestado() {
		try {
			assertTrue(jobDAO.insert(job));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void deleteDeJobPrestadoDAODeveEnviarUmJobPrestado() {
		try {
			assertTrue(jobDAO.delete(job));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertDeJobPrestadoDAOPassandoUmJobNulo() {
		try {
			assertFalse(jobDAO.insert(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeJobPrestadoDAOPassandoUmJobNulo() {
		try {
			assertFalse(jobDAO.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
