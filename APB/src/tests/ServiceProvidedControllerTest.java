package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.JobPrestado;

import org.junit.Before;
import org.junit.Test;

import control.JobPrestadoController;
import exception.JobException;

public class ServiceProvidedControllerTest {
	JobPrestado job = new JobPrestado();
	JobPrestadoController jobController = JobPrestadoController.getInstance();

	@Before
	public void setUp() throws JobException, ParseException {
		job.setNomeJob("Corte");
		job.setNomeBarber("Joao");
		job.setPreco("125,23");
		job.setData("20/12/2013");

	}

	@Test
	public void getInstanceDeJobPrestadoControllerDeveRetornarInstanciaCorrente() {
		assertEquals(JobPrestadoController.getInstance(), jobController);
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
	public void mostrarJobPrestadoDeJobPrestadoControllerDeveMostrarUmJob() throws SQLException {
		ResultSet rs = jobController.mostrarJobsPrestadosCadastrados(job);
		while(rs.next());
	}
}
