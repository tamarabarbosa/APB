package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.Report;

import org.junit.Before;
import org.junit.Test;

import dao.ReportDAO;

import exception.ReportException;

public class ReportDAOTest {

	Report report = new Report();

	@Before
	public void setUp() throws ReportException, ParseException {
		try {
			report.setBarber("Luciano");
			report.setEndDate("09/09/2013");
			report.setInitialDate("01/01/2013");
			report.setServiceType("corte");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getInstanceDeRelatorioDAODeveRetonarInstanciaCorrente() {
		ReportDAO relatorioDAO = ReportDAO.getInstance();
		assertEquals(ReportDAO.getInstance(), relatorioDAO);
	}

	@Test
	public void procurarPorDataDeRelatorioDAODeveMostrarUmRelatorio() {
		try {
			ReportDAO relatorioDAO = ReportDAO.getInstance();
			ResultSet rs = relatorioDAO.searchByData(report);

			while (rs.next()) {
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
			ReportDAO relatorioDAO = ReportDAO.getInstance();
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
			ReportDAO relatorioDAO = ReportDAO.getInstance();
			ResultSet rs = relatorioDAO.searchByBarber(report);

			while (rs.next()) {
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
			ReportDAO relatorioDAO = ReportDAO.getInstance();
			ResultSet rs = relatorioDAO.searchByBarberEJob(report);

			while (rs.next()) {
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
			ReportDAO relatorioDAO = ReportDAO.getInstance();
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
			ReportDAO relatorioDAO = ReportDAO.getInstance();
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
	public void searchByDataBarberEJobDAODeveMostrarUmRelatorio() {
		try {
			ReportDAO relatorioDAO = ReportDAO.getInstance();
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
