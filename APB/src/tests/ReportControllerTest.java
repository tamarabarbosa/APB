package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.Report;

import org.junit.Before;
import org.junit.Test;

import control.RelatorioController;
import exception.RelatorioException;

public class ReportControllerTest {

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
		RelatorioController relatorioController = RelatorioController.getInstance();
		assertEquals(RelatorioController.getInstance(), relatorioController);
	}

	@Test
	public void procurarPorJobDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.searchByJob(report);

		while(rs.next());
	}

	@Test
	public void procurarPorDataDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.searchByData(report);

		while(rs.next());
	}

	@Test
	public void procurarPorBarberEJobDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.searchByBarberEJob(report);

		while(rs.next());
	}

	@Test
	public void procurarPorDataBarberEJobDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.searchByDataBarberEJob(report);

		while(rs.next());
	}

	@Test
	public void procurarPorDataEBarberDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.searchByDataEBarber(report);

		while(rs.next());
	}

	@Test
	public void procurarPorDataEJobDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.searchByDataEJob(report);

		while(rs.next());
	}

	@Test
	public void procurarPorBarberDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.searchByBarber(report);

		while(rs.next());
	}

}
