package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.Report;

import org.junit.Before;
import org.junit.Test;

import control.ReportController;
import exception.ReportException;

public class ReportControllerTest {

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
		ReportController relatorioController = ReportController.getInstance();
		assertEquals(ReportController.getInstance(), relatorioController);
	}

	@Test
	public void procurarPorJobDeRelatorioControllerDeveMostrarUmRelatorio()
			throws SQLException {
		ReportController relatorioController = new ReportController();
		ResultSet rs = relatorioController.searchByJob(report);

		while (rs.next())
			;
	}

	@Test
	public void procurarPorDataDeRelatorioControllerDeveMostrarUmRelatorio()
			throws SQLException {
		ReportController relatorioController = new ReportController();
		ResultSet rs = relatorioController.searchByData(report);

		while (rs.next())
			;
	}

	@Test
	public void procurarPorBarberEJobDeRelatorioControllerDeveMostrarUmRelatorio()
			throws SQLException {
		ReportController relatorioController = new ReportController();
		ResultSet rs = relatorioController.searchByBarberEJob(report);

		while (rs.next())
			;
	}

	@Test
	public void procurarPorDataBarberEJobDeRelatorioControllerDeveMostrarUmRelatorio()
			throws SQLException {
		ReportController relatorioController = new ReportController();
		ResultSet rs = relatorioController.searchByDataBarberEJob(report);

		while (rs.next())
			;
	}

	@Test
	public void procurarPorDataEBarberDeRelatorioControllerDeveMostrarUmRelatorio()
			throws SQLException {
		ReportController relatorioController = new ReportController();
		ResultSet rs = relatorioController.searchByDataEBarber(report);

		while (rs.next())
			;
	}

	@Test
	public void procurarPorDataEJobDeRelatorioControllerDeveMostrarUmRelatorio()
			throws SQLException {
		ReportController relatorioController = new ReportController();
		ResultSet rs = relatorioController.searchByDataEJob(report);

		while (rs.next())
			;
	}

	@Test
	public void procurarPorBarberDeRelatorioControllerDeveMostrarUmRelatorio()
			throws SQLException {
		ReportController relatorioController = new ReportController();
		ResultSet rs = relatorioController.searchByBarber(report);

		while (rs.next())
			;
	}

}
