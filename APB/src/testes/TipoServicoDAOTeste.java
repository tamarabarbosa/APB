package testes;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.TipoServico;

import org.junit.Test;

import dao.TipoServicoDAO;

public class TipoServicoDAOTeste {

	TipoServico tiposervico = new TipoServico();
	TipoServicoDAO servicoDAO = TipoServicoDAO.getInstance();
	
	@Test
	public void inserirDeTipoServicoDAOPassandoUmServicoNulo() {
		try {
			assertFalse(servicoDAO.incluir(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void excluirDeTipoServicoDAOPassandoUmServicoNulo() {
		try {
			assertFalse(servicoDAO.excluir(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void alterarDeTipoServicoDAOPassandoUmServicoNulo() {
		try {
			assertFalse(servicoDAO.alterar(tiposervico, null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void alterarDeTipoServicoDAOPassandoUmServicoAlteradoNulo() {
		try {
			assertFalse(servicoDAO.alterar(null, tiposervico));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	@Test
	public void pesquisarDeBarbeiroDAODeveMostrarUmBarbeiro() {
		try {
			ResultSet rs = barbeiroDAO.pesquisar();
			
			while (rs.next()) {
				String nome = rs.getString("nome");
				assertNotNull(nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

}
