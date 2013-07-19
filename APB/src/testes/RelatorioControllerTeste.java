package testes;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Relatorio;

import org.junit.Before;
import org.junit.Test;

import control.RelatorioController;
import exception.RelatorioException;

public class RelatorioControllerTeste {

	Relatorio relatorio = new Relatorio();
	
	
	@Before
	public void setUp() throws RelatorioException {
		try {
			relatorio.setBarbeiro("Luciano");
			relatorio.setDataFinal("2013-09-09");
			relatorio.setDataInicial("2013-01-01");
			relatorio.setTipoServico("corte");
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
		ResultSet rs = relatorioController.pesquisarPorServico(relatorio);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorDataDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorData(relatorio);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorBarbeiroEServicoDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorBarbeiroEServico(relatorio);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorDataBarbeiroEServicoDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorDataBarbeiroEServico(relatorio);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorDataEBarbeiroDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorDataEBarbeiro(relatorio);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorDataEServicoDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorDataEServico(relatorio);
		
		while(rs.next());
	}
	
	@Test
	public void procurarPorBarbeiroDeRelatorioControllerDeveMostrarUmRelatorio() throws SQLException {
		RelatorioController relatorioController = new RelatorioController();
		ResultSet rs = relatorioController.pesquisarPorBarbeiro(relatorio);
		
		while(rs.next());
	}

}
