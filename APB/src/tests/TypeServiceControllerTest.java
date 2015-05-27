package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ServiceType;

import org.junit.Before;
import org.junit.Test;

import control.ServiceTypeController;
import exception.ServiceException;

public class TypeServiceControllerTest {

	ServiceType job = new ServiceType();
	ServiceTypeController jobController = ServiceTypeController.getInstance();

	@Before
	public void setUp() {
		try {
			job.setNomeTipoJob("Corte");
			job.setPreco("15,00");
		} catch (JobException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getInstanceDeTipoJobControllerDeveRetornarInstanciaCorrente() {
		assertEquals(ServiceTypeController.getInstance(), jobController);
	}

	@Test
	public void insertDeTipoJobControllerDeveEnviarUmTipoJob() {
		try {
			assertTrue(jobController.insert(job));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeTipoJobControllerDeveRemoverUmTipoJob() {
		try {
			assertTrue(jobController.delete(job));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeTipoJobControllerDeveAlterarUmTipoJob() {
		try {
			assertTrue(jobController.change(job.getNomeTipoJob(), job));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertTipoJobNaoPodePassarTipoJobNullo() {
		try {
			assertFalse(jobController.insert(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteTipoJobNaoPodePassarTipoJobNullo() {
		try {
			assertFalse(jobController.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeTipoJobNaoPodePassarTipoJobNullo() {
		try {
			assertFalse(jobController.change(null, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarBarbersDeBarberControllerDeveMostrarUmBarber()
			throws SQLException {
		ResultSet rs = jobController.mostrarTipoJobCadastrados(job);
		while (rs.next())
			;
	}

	@Test
	public void searchByNomeDeTipoJobControllerDeveMostrarUmJob()
			throws SQLException {
		ResultSet rs = jobController.searchByNome(job);
		while (rs.next())
			;
	}

}
