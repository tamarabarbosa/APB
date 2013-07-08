package testes;

import static org.junit.Assert.*;
import junit.framework.Assert;

import model.ServicoPrestado;

import org.junit.Test;

import exception.ServicoException;

public class ServicoPrestadoTeste {

	ServicoPrestado servico = new ServicoPrestado();
	@Test (expected = NullPointerException.class)
	public void testeSetNomeNaoNulo() throws ServicoException {
		servico.setNomeServico(null);
		Assert.fail("Deve lançar exceção");
	}
	
	@Test (expected = ServicoException.class)
	public void testeSetNomeBranco() throws ServicoException {
		servico.setNomeServico("");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test (expected = ServicoException.class)
	public void testeSetNomeForaDeFormato() throws ServicoException {
		servico.setNomeServico("123");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test
	public void testeSetNomeValido() {
		try {
			servico.setNomeServico("Corte");
		} catch (ServicoException e) {
			e.printStackTrace();
			Assert.fail("Não deve lançar exceção");
		}
		assertEquals("Corte", servico.getNomeServico());
	}
	
	@Test (expected = ServicoException.class)
	public void precoForaDeFormato() throws ServicoException {
		servico.setPreco("as");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test (expected = NullPointerException.class)
	public void testePrecoNaoNulo() throws ServicoException {
		servico.setPreco(null);
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test (expected = ServicoException.class)
	public void testePrecoEmBranco() throws ServicoException {
		servico.setPreco("");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test
	public void testePrecoValidoo() {
		try {
			servico.setPreco("123,45");
		} catch (ServicoException e) {
			Assert.fail("Não deve lançar exceção");
		}
		assertEquals("123,45", servico.getPreco());
	}
	
	@Test (expected = NullPointerException.class)
	public void testeNomeBarbeiroNulo() throws ServicoException {
		servico.setNomeBarbeiro(null);
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test (expected = ServicoException.class)
	public void testeNomeBarbeiroEmBranco() throws ServicoException {
		servico.setNomeBarbeiro("");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test (expected = ServicoException.class)
	public void testeNomeBarbeiroForaDeFormato() throws ServicoException {
		servico.setNomeBarbeiro("123");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test
	public void testeNomeBarbeiroValido() {
		try {
			servico.setNomeBarbeiro("João");
		} catch (ServicoException e) {
			Assert.fail("Não deve lançar exceção");
		}
		assertEquals("João", servico.getNomeBarbeiro());
	}
	
	@Test (expected = NullPointerException.class)
	public void testeDataNulo() throws ServicoException {
		servico.setData(null);
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test (expected = ServicoException.class)
	public void testeDataEmBranco() throws ServicoException {
		servico.setData("");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test (expected = ServicoException.class)
	public void testeDataForaDeFormato() throws ServicoException {
		servico.setData("abc");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test
	public void testeDataValida() {
		try {
			servico.setData("01/01/01");
		} catch (ServicoException e) {
			Assert.fail("Não deve lançar exceção");
		}
		assertEquals("01/01/01", servico.getData());
	}
}
