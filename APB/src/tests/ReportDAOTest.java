package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.Report;

import org.junit.Before;
import org.junit.Test;

import dao.RelatorioDAO;

import exception.RelatorioException;

public class ReportDAOTest {

	Report report = new Report();

	@Before
	public void setUp() throws RelatorioException, ParseException {
		try {
			report.setBarber("Luciano");
			report.setDataFinal("09/09/2013");
			report.setDataInicial("01/01/2013");
			report.setTipoJob("corte");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getInstanceDeRelatorioDAODeveRetonarInstanciaCorrente() {
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		assertEquals(RelatorioDAO.getInstance(), relatorioDAO);
	}

	@Test
	public void procurarPorDataDeRelatorioDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.searchByData(report);

			while(rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void searchByDataEJobDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.searchByDataEJob(report);

			while (rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void searchByBArbeiroDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.searchByBarber(report);

			while(rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void searchByBArbeiroEJobDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.searchByBarberEJob(report);

			while(rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void searchByJobDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.searchByJob(report);

			while (rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void searchByDataEBArbeiroDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.searchByDataEBarber(report);

			while (rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void searchByDataBarberEJobDAODeveMostrarUmRelatorio(){
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.searchByDataBarberEJob(report);

			while (rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
