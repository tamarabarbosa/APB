package tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Test;

import exception.BarberException;
import exception.JobException;
import model.Phonebook;

public class PhonebookTeste {

	Phonebook contato = new Phonebook();

	@Before
	public void setUp(){
		try {
			contato.setNome("Alessandro");
			contato.setTelefone("4568-9856");
		} catch (BarberException e1) {
			e1.printStackTrace();
		}
		contato.setDescricao("ASDAS");
	}

	@Test
	public void contrutorDePhonebookDeveFuncionar(){
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


	@Test(expected = BarberException.class)
	public void nameDoBarberNaoPodePassarQuandoEmBranco() throws BarberException{
		contato.setNome("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test(expected = BarberException.class)
	public void telefoneDoBarberNaoPodePassarQuandoEmBranco() throws BarberException{
		contato.setTelefone("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test(expected = BarberException.class)
	public void nameDoBarberNaoPodePassarQuandoForaDeFormato() throws BarberException{
		contato.setNome("ASDAS!!");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test(expected = BarberException.class)
	public void telefoneDoBarberNaoPodePassarQuandoForaDeFormato() throws BarberException{
		contato.setTelefone("45645aa-a54654");
		Assert.fail("Deve lançar uma exceção");
	}


	@Test (expected = AssertionError.class)
	public void getterDeTempNomeDeveRetornarValorPassado() throws JobException {
		assertEquals("Barba", Phonebook.getTempNome());
	}

	@Test (expected = AssertionFailedError.class)
	public void setterDeTempNomeNaoPodeSerNulo() throws JobException {
		Phonebook.setTempNome(null);
		Assert.fail("Deve lançar exceção");
	}


	@Test (expected = AssertionFailedError.class)
	public void setterDeTempNomeNaoPodeSerEmBranco() {
		Phonebook.setTempNome("");
		Assert.fail("Deve lançar exceção");
	}

	@Test
	public void tempNomeValido() throws BarberException {
		Phonebook.setTempNome("Paulo");
		assertEquals("Paulo", Phonebook.getTempNome());
	}

}
