package tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Test;

import exception.BarbeiroException;
import exception.ServicoException;
import model.Phonebook;

public class PhonebookTeste {
	
	Phonebook contato = new Phonebook();
	
	@Before
	public void setUp(){
		try {
			contato.setNome("Alessandro");
			contato.setTelefone("4568-9856");
		} catch (BarbeiroException e1) {
			e1.printStackTrace();
		}
		contato.setDescricao("ASDAS");
	}
	
	@Test
	public void contrutorDeAgendaDeveFuncionar(){
		Phonebook contato = new Phonebook("Alessandro", "6589-5689", "aaaa");
		assertEquals("Alessandro", contato.getNome());
		assertEquals("6589-5689", contato.getTelefone());
		assertEquals("aaaa", contato.getDescricao());
	}
	
	@Test
	public void getterDeNomeDeveFuncionar(){
		assertEquals("Alessandro", contato.getNome());
	}
	
	@Test
	public void getterDeTelefoneDeveFuncionar(){
		assertEquals("4568-9856", contato.getTelefone());
	}
	
	@Test
	public void getterDeDescricaoDeveFuncionar(){
		assertEquals("ASDAS", contato.getDescricao());
	}
	
	
	@Test(expected = BarbeiroException.class)
	public void nomeDoBarbeiroNaoPodePassarQuandoEmBranco() throws BarbeiroException{
		contato.setNome("");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test(expected = BarbeiroException.class)
	public void telefoneDoBarbeiroNaoPodePassarQuandoEmBranco() throws BarbeiroException{
		contato.setTelefone("");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test(expected = BarbeiroException.class)
	public void nomeDoBarbeiroNaoPodePassarQuandoForaDeFormato() throws BarbeiroException{
		contato.setNome("ASDAS!!");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test(expected = BarbeiroException.class)
	public void telefoneDoBarbeiroNaoPodePassarQuandoForaDeFormato() throws BarbeiroException{
		contato.setTelefone("45645aa-a54654");
		Assert.fail("Deve lançar uma exceção");
	}
	

	@Test (expected = AssertionError.class)
	public void getterDeTempNomeDeveRetornarValorPassado() throws ServicoException {
		assertEquals("Barba", Phonebook.getTempNome());
	}
	
	@Test (expected = AssertionFailedError.class)
	public void setterDeTempNomeNaoPodeSerNulo() throws ServicoException {
		Phonebook.setTempNome(null);
		Assert.fail("Deve lançar exceção");
	}
	
	
	@Test (expected = AssertionFailedError.class)
	public void setterDeTempNomeNaoPodeSerEmBranco() {
		Phonebook.setTempNome("");
		Assert.fail("Deve lançar exceção");
	}
	
	@Test
	public void tempNomeValido() throws BarbeiroException {
		Phonebook.setTempNome("Paulo");
		assertEquals("Paulo", Phonebook.getTempNome());
	}

}
