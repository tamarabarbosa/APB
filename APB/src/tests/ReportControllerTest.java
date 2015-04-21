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
		RelatorioController relatorioController = RelatorioController.getInstance();
		assertEquals(RelatorioController.getInstance(), relatorioController);
	}
	
	@Test
	public void procurarPorServicoDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorServico(report);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorDataDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorData(report);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorBarbeiroEServicoDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorBarbeiroEServico(report);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorDataBarbeiroEServicoDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorDataBarbeiroEServico(report);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorDataEBarbeiroDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorDataEBarbeiro(report);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorDataEServicoDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorDataEServico(report);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorBarbeiroDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorBarbeiro(report);
		
		while(rs.next());
	}

}
