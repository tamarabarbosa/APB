package testes;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Barbeiro;

import org.junit.Before;
import org.junit.Test;

import view.AlterarBarbeiro;
import view.CadastrarBarbeiro;

import control.BarbeiroController;

import dao.BarbeiroDAO;
import dao.FactoryConnection;

import exception.BarbeiroException;

public class BarbeiroDAOTeste {

	Barbeiro barbeiro = new Barbeiro();
	Barbeiro barbeiro2 = new Barbeiro();
	@Before
	public void setUp() {
		try {
			barbeiro.setNome("Alessandro");
			barbeiro2.setNome("Luciano");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

		try {
			barbeiro.setRg("418757896");
			barbeiro.setTelefone("3389-9085");
			barbeiro.setCpf("02919594150");
			barbeiro.setCadeira("5");
			barbeiro2.setRg("418757896");
			barbeiro2.setTelefone("3389-9085");
			barbeiro2.setCpf("02919594150");
			barbeiro2.setCadeira("5");
			AlterarBarbeiro.setCpfAntigo("02919594150");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
		
		
		try {
			BarbeiroDAO barbeiroDao = BarbeiroDAO.getInstance();
			barbeiroDao.incluir(barbeiro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getInstanceDeBarbeiroDAODeveRetonarInstanciaCorrente() {
		BarbeiroDAO barbeiroDAO = BarbeiroDAO.getInstance();
		assertEquals(BarbeiroDAO.getInstance(), barbeiroDAO);
	}

	@Test
	public void inserirDeBarbeiroDAODeveCadastrarUmBarbeiro() {
		BarbeiroDAO barbeiroDAO = BarbeiroDAO.getInstance();
		try {
			assertTrue(barbeiroDAO.incluir(barbeiro));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			Connection connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery("SELECT nome FROM barbeiro WHERE "
					+ " nome = \""
					+ barbeiro.getNome() + "\";");
			rs.next();
			assertEquals("Alessandro", rs.getString("nome"));
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test(expected = AssertionError.class)
	public void excluirDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		BarbeiroDAO barbeiroDAO = BarbeiroDAO.getInstance();
		try {
			assertTrue(barbeiroDAO.excluir(barbeiro));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery("SELECT nome FROM barbeiro WHERE "
					+ " nome = \""
					+ barbeiro.getNome() + "\";");
			rs.next();
			fail();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void alterarDeBarbeiroDaoDeveAlterarUmBarbeiro() {
		BarbeiroDAO barbeiroDAO = BarbeiroDAO.getInstance();
		try {
			assertTrue(barbeiroDAO.alterar(barbeiro, barbeiro2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			
			barbeiroDAO.alterar(barbeiro2, barbeiro);
			Connection connection = FactoryConnection.getInstance().getConnection();
			java.sql.PreparedStatement pst1 = connection
					.prepareStatement("SELECT nome FROM barbeiro WHERE "
							+ " nome = \""
							+ barbeiro.getNome() + "\";");
			
			ResultSet rs = pst1.executeQuery();
			while(rs.next()){
			assertEquals("Luciano", rs.getString("nome"));
			}rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}