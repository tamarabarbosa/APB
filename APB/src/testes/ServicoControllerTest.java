package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.ServicoPrestado;

import org.junit.Before;
import org.junit.Test;

import control.BarbeiroController;
import control.ServicoController;
import dao.ServicoDAO;
import exception.ServicoException;

public class ServicoControllerTest {
	ServicoPrestado servico =  new ServicoPrestado();
	ServicoController servicoController =  ServicoController.getInstance();
	
	@Before
	public void setUp() throws ServicoException{
		servico.setNome("Corte");
		servico.setNomeBarbeiro("Joao");
		servico.setPreco("125,23");
		servico.setData("20/12/13");
		
	}
	
	@Test
	public void testeMetodoInserirBarbeiroController() throws SQLException {
		assertTrue(servicoController.inserir(servico));
		
	}

}
