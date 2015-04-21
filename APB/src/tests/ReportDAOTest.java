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
			report.setBarbeiro("Luciano");
			report.setDataFinal("09/09/2013");
			report.setDataInicial("01/01/2013");
			report.setTipoServico("corte");
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
				String nome = rs.getString("nome");
				assertEquals("Corte", nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorDataEServicoDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorDataEServico(report);
			
			while (rs.next()) {
				String nome = rs.getString("nome");
				assertEquals("Corte", nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorBArbeiroDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorBarbeiro(report);
			
			while(rs.next()) {
				String nome = rs.getString("nome");
				assertEquals("Corte", nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorBArbeiroEServicoDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorBarbeiroEServico(report);
			
			while(rs.next()) {
				String nome = rs.getString("nome");
				assertEquals("Corte", nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorServicoDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorServico(report);
			
			while (rs.next()) {
				String nome = rs.getString("nome");
				assertEquals("Corte", nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorDataEBArbeiroDAODeveMostrarUmRelatorio() {
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorDataEBarbeiro(report);
			
			while (rs.next()) {
				String nome = rs.getString("nome");
				assertEquals("Corte", nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void pesquisarPorDataBarbeiroEServicoDAODeveMostrarUmRelatorio(){
		try {
			RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
			ResultSet rs = relatorioDAO.pesquisarPorDataBarbeiroEServico(report);
			
			while (rs.next()) {
				String nome = rs.getString("nome");
				assertEquals("Corte", nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
