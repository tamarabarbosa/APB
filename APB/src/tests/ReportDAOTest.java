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
			ResultSet rs = relatorioDAO.pesquisarPorData(report);

			while(rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorDataEJobDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorDataEJob(report);

			while (rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorBArbeiroDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorBarber(report);

			while(rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorBArbeiroEJobDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorBarberEJob(report);

			while(rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorJobDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorJob(report);

			while (rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorDataEBArbeiroDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorDataEBarber(report);

			while (rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorDataBarberEJobDAODeveMostrarUmRelatorio(){
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorDataBarberEJob(report);

			while (rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
