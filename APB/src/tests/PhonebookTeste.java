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

	Phonebook contact = new Phonebook();

	@Before
	public void setUp(){
		try {
			contact.setNome("Alessandro");
			contact.setPhone("4568-9856");
		} catch (BarberException e1) {
			e1.printStackTrace();
		}
		contact.setDescricao("ASDAS");
	}

	@Test
	public void contrutorDePhonebookDeveFuncionar(){
		Phonebook contact = new Phonebook("Alessandro", "6589-5689", "aaaa");
		assertEquals("Alessandro", contact.getNome());
		assertEquals("6589-5689", contact.getPhone());
		assertEquals("aaaa", contact.getDescricao());
	}

	@Test
	public void getterDeNomeDeveFuncionar(){
		assertEquals("Alessandro", contact.getNome());
	}

	@Test
	public void getterDePhoneDeveFuncionar(){
		assertEquals("4568-9856", contact.getPhone());
	}

	@Test
	public void getterDeDescricaoDeveFuncionar(){
		assertEquals("ASDAS", contact.getDescricao());
	}


	@Test(expected = BarberException.class)
	public void nameDoBarberNaoPodePassarQuandoEmBranco() throws BarberException{
		contact.setNome("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test(expected = BarberException.class)
	public void telefoneDoBarberNaoPodePassarQuandoEmBranco() throws BarberException{
		contact.setPhone("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test(expected = BarberException.class)
	public void nameDoBarberNaoPodePassarQuandoForaDeFormato() throws BarberException{
		contact.setNome("ASDAS!!");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test(expected = BarberException.class)
	public void telefoneDoBarberNaoPodePassarQuandoForaDeFormato() throws BarberException{
		contact.setPhone("45645aa-a54654");
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
