package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.DoneService;

import org.junit.Before;
import org.junit.Test;

import control.DoneServiceController;
import exception.ServiceException;

public class ServiceProvidedControllerTest {
	DoneService job = new DoneService();
	DoneServiceController jobController = DoneServiceController.getInstance();

	@Before
	public void setUp() throws ServiceException, ParseException {
		job.setServiceName("Corte");
		job.setBarberName("Joao");
		job.setPrice("125,23");
		job.setDate("20/12/2013");

	}

	@Test
	public void getInstanceDeJobPrestadoControllerDeveRetornarInstanciaCorrente() {
		assertEquals(DoneServiceController.getInstance(), jobController);
	}

	@Test
	public void insertDeJobPrestadoControllerDeveEnviarUm() {
		try {
			assertTrue(jobController.insert(job));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeJobPrestadoControllerDeveEnviarUmajobprestado() {
		try {
			assertTrue(jobController.delete(job));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertJobPrestadoNaoPodePassarJobPrestadoNullo() {
		try {
			assertFalse(jobController.insert(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteJobPrestadoNaoPodePassarJobPrestadoNullo() {
		try {
			assertFalse(jobController.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarJobPrestadoDeJobPrestadoControllerDeveMostrarUmJob()
			throws SQLException {
		ResultSet rs = jobController.mostrarJobsPrestadosCadastrados(job);
		while (rs.next())
			;
	}
}
