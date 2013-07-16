package testes;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.relation.RelationException;

import model.Relatorio;

import org.junit.Before;
import org.junit.Test;

import dao.FactoryConnection;
import dao.RelatorioDAO;

import exception.RelatorioException;

public class RelatorioDAOTeste {

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
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		assertEquals(RelatorioDAO.getInstance(), relatorioDAO);
	}

	@Test
	public void procurarPorDataDeRelatorioDAODeveMostrarUmRelatorio() {
		ResultSet rs;
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		try {
			rs = relatorioDAO.pesquisarPorData(relatorio);
			String nome = rs.getString("nome");
			rs.next();
			assertEquals(
					relatorioDAO.pesquisarPorData(relatorio).getString("nome"),
					nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorDataEServicoDAODeveMostrarUmRelatorio() {
		ResultSet rs;
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		try {
			rs = relatorioDAO.pesquisarPorDataEServico(relatorio);
			String nome = rs.getString("nome");
			rs.next();
			assertEquals(relatorioDAO.pesquisarPorDataEServico(relatorio)
					.getString("nome"), nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorBArbeiroDAODeveMostrarUmRelatorio() {
		ResultSet rs;
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		try {
			rs = relatorioDAO.pesquisarPorBArbeiro(relatorio);
			String nome = rs.getString("nome");
			rs.next();
			assertEquals(relatorioDAO.pesquisarPorBArbeiro(relatorio)
					.getString("nome"), nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorBArbeiroEServicoDAODeveMostrarUmRelatorio() {
		ResultSet rs;
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		try {
			rs = relatorioDAO.pesquisarPorBArbeiroEServico(relatorio);
			String nome = rs.getString("nome");
			rs.next();
			assertEquals(relatorioDAO.pesquisarPorBArbeiroEServico(relatorio)
					.getString("nome"), nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorServicoDAODeveMostrarUmRelatorio() {
		ResultSet rs;
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		try {
			rs = relatorioDAO.pesquisarPorServico(relatorio);
			String nome = rs.getString("nome");
			rs.next();
			assertEquals(
					relatorioDAO.pesquisarPorServico(relatorio).getString(
							"nome"), nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void pesquisarPorDataEBArbeiroDAODeveMostrarUmRelatorio() {
		ResultSet rs;
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		try {
			rs = relatorioDAO.pesquisarPorDataEBArbeiro(relatorio);
			String nome = rs.getString("nome");
			rs.next();
			assertEquals(relatorioDAO.pesquisarPorDataEBArbeiro(relatorio)
					.getString("nome"), nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void pesquisarPorDataBarbeiroEServicoDAODeveMostrarUmRelatorio(){
		ResultSet rs;
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		try {
			rs = relatorioDAO.pesquisarPorDataBarbeiroEServico(relatorio);
			String nome = rs.getString("nome");
			rs.next();
			assertEquals(relatorioDAO.pesquisarPorDataBarbeiroEServico(relatorio).getString("nome"), nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
