package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.TipoJob;

import org.junit.Test;

import dao.TipoJobDAO;

public class TypeServiceDAOTest {

	TipoJob tipojob = new TipoJob();
	TipoJob tipojob2 = new TipoJob();
	TipoJobDAO jobDAO = TipoJobDAO.getInstance();

	@Test
	public void getInstanceDeTipoJobDAODeveRetonarInstanciaCorrente() {
		assertEquals(TipoJobDAO.getInstance(), jobDAO);
	}

	@Test
	public void insertDeTipoJobDAODeveCadastrarUmTipoJob() {
		try {
			assertTrue(jobDAO.insert(tipojob));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeTipoJobDAODeveEnviarUmTipoJob() {
		try {
			assertTrue(jobDAO.delete(tipojob));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeTipoJobDAODeveEnviarUmTipoJob() {
		try {
			assertTrue(jobDAO.change(tipojob.getNomeTipoJob(),tipojob, tipojob2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertDeTipoJobDAOPassandoUmJobNulo() {
		try {
			assertFalse(jobDAO.insert(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteDeTipoJobDAOPassandoUmJobNulo() {
		try {
			assertFalse(jobDAO.delete(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeTipoJobDAOPassandoUmJobNulo() {
		try {
			assertFalse(jobDAO.change(tipojob.getNomeTipoJob(), tipojob, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeDeTipoJobDAOPassandoUmJobAlteradoNulo() {
		try {
			assertFalse(jobDAO.change(tipojob.getNomeTipoJob(), null, tipojob));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mostrarJobsDeTipoJobDAODeveMostrarJob() {
		try {
			ResultSet rs = jobDAO.mostrarTipoJobCadastrados(tipojob);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void pesquisarPorNomeDeTipoJobDAODeveMostrarJob() {
		try {
			ResultSet rs = jobDAO.pesquisarPorNome(tipojob);

			while (rs.next()) {
				String name = rs.getString("name");
				assertNotNull(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
