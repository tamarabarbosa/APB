package testes;

import static org.junit.Assert.*;
import junit.framework.Assert;

import model.Servico;

import org.junit.Test;

import exception.ServicoException;

public class ServicoTeste {

	Servico servico = new Servico();
	@Test (expected = NullPointerException.class)
	public void testeSetNomeNaoNulo() throws ServicoException {
		servico.setNome(null);
		Assert.fail("Deve lançar exceção");
	}
	
	@Test (expected = ServicoException.class)
	public void PrecoForaDeFormato() throws ServicoException {
		servico.setPreco("as");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test (expected = NullPointerException.class)
	public void testePrecoNaoNulo() throws ServicoException {
		servico.setPreco(null);
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test (expected = ServicoException.class)
	public void TestePrecoEmBranco() throws ServicoException {
		servico.setPreco("");
		Assert.fail("Deve lançar exceção");
	}
	
	@Test
	public void TestePrecoRecebeFormatoCorreto () {
		try {
			servico.setPreco("123,45");
		} catch (ServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Não deve lançar exceção");
		}
		assertEquals("123,45", servico.getPreco());
		
		
	}
}
