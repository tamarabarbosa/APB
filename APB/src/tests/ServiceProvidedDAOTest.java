package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;

import model.JobPrestado;

import org.junit.Before;
import org.junit.Test;

import dao.JobPrestadoDAO;
import exception.JobException;

public class ServiceProvidedDAOTest {

	JobPrestado job = new JobPrestado();
	JobPrestado job2 = new JobPrestado();
	@Before
	public void setUp() {
		try {
			job.setNomeJob("Corte");
			job.setNomeBarber("Alessandro");
			job.setData("10/10/2010");
			job.setPreco("10,00");
			job2.setNomeJob("Barba");
			job2.setNomeBarber("Luciano");
			job2.setData("01/01/2010");
			job2.setPreco("9,90");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (JobException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	JobPrestadoDAO jobDAO = JobPrestadoDAO.getInstance();

	@Test
	public void getInstanceDeJobPrestadoDAODeveRetonarInstanciaCorrente() {
		assertEquals(JobPrestadoDAO.getInstance(), jobDAO);
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
