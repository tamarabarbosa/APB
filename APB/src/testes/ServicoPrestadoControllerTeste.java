package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.ServicoPrestado;

import org.junit.Before;
import org.junit.Test;

import control.ServicoPrestadoController;
import exception.ServicoException;

public class ServicoPrestadoControllerTeste {
	ServicoPrestado servico =  new ServicoPrestado();
	ServicoPrestadoController servicoController =  ServicoPrestadoController.getInstance();
	
	@Before
	public void setUp() throws ServicoException{
		servico.setNomeServico("Corte");
		servico.setNomeBarbeiro("Joao");
		servico.setPreco("125,23");
		servico.setData("20/12/13");
		
	}
	
	@Test
	public void testeMetodoInserirBarbeiroController() throws SQLException {
		assertTrue(servicoController.inserir(servico));
		
	}

}
