package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.TipoJob;

import org.junit.Before;
import org.junit.Test;

import control.TipoJobController;
import exception.JobException;

public class TypeServiceControllerTest {

	TipoJob job = new TipoJob();
	TipoJobController jobController = TipoJobController.getInstance();

	@Before
	public void setUp(){
		try {
			job.setNomeTipoJob("Corte");
			job.setPreco("15,00");
		} catch (JobException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getInstanceDeTipoJobControllerDeveRetornarInstanciaCorrente() {
		assertEquals(TipoJobController.getInstance(), jobController);
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
			assertTrue(jobController.change(job.getNomeTipoJob(),job));
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
			assertFalse(jobController.change(null,null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarBarbersDeBarberControllerDeveMostrarUmBarber() throws SQLException {
		ResultSet rs = jobController.mostrarTipoJobCadastrados(job);
		while(rs.next());
	}

	@Test
	public void pesquisarPorNomeDeTipoJobControllerDeveMostrarUmJob() throws SQLException {
		ResultSet rs = jobController.pesquisarPorNome(job);
		while(rs.next());
	}

}
