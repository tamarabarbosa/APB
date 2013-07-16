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
	public void setUp() {
		
		try{
			relatorio.setBarbeiro("Luciano");
			relatorio.setDataFinal("2013-09-09");
			relatorio.setDataInicial("2013-01-01");
			relatorio.setTipoServico("corte");
			relatorio.setDataIso("2013-01-01");
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void getInstanceDeRelatorioDAODeveRetonarInstanciaCorrente() {
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		assertEquals(RelatorioDAO.getInstance(), relatorioDAO);
	}
	
	/*@Test
	public void procurarPorDataDeRelatorioDAODeveMostrarUmRelatorio(){
		ResultSet rs;
		RelatorioDAO relatorioDAO = RelatorioDAO.getInstance();
		try {
			rs = relatorioDAO.pesquisarPorData(relatorio);
			rs.next();
			assertEquals(relatorioDAO.pesquisarPorData(relatorio), rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

}
