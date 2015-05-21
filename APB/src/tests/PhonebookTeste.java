package tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Test;

import exception.BarberException;
import exception.ServiceException;
import model.Contact;
import model.Phonebook;

public class PhonebookTeste {

	Contact contact = new Contact();

	@Before
	public void setUp() {
		try {
			contact.setName("Alessandro");
			contact.setName("4568-9856");
		} catch (BarberException e1) {
			e1.printStackTrace();
		}
		contact.setDescription("ASDAS");
	}

	@Test
	public void contrutorDePhonebookDeveFuncionar() {
		Phonebook contact = new Phonebook("Alessandro", "6589-5689", "aaaa");
		assertEquals("Alessandro", contact.getName());
		assertEquals("6589-5689", contact.getPhoneNumber());
		assertEquals("aaaa", contact.getDescription());
	}

	@Test
	public void getterDeNomeDeveFuncionar() {
		assertEquals("Alessandro", contact.getName());
	}

	@Test
	public void getterDePhoneDeveFuncionar() {
		assertEquals("4568-9856", contact.getPhoneNumber());
	}

	@Test
	public void getterDeDescricaoDeveFuncionar() {
		assertEquals("ASDAS", contact.getDescription());
	}

	@Test(expected = BarberException.class)
	public void nameDoBarberNaoPodePassarQuandoEmBranco()
			throws BarberException {
		contact.setName("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test(expected = BarberException.class)
	public void telefoneDoBarberNaoPodePassarQuandoEmBranco()
			throws BarberException {
		contact.setName("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test(expected = BarberException.class)
	public void nameDoBarberNaoPodePassarQuandoForaDeFormato()
			throws BarberException {
		contact.setName("ASDAS!!");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test(expected = BarberException.class)
	public void telefoneDoBarberNaoPodePassarQuandoForaDeFormato()
			throws BarberException {
		contact.setName("45645aa-a54654");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test(expected = AssertionError.class)
	public void getterDeTempNomeDeveRetornarValorPassado()
			throws ServiceException {
		assertEquals("Barba", Contact.getTempName());
	}

	@Test(expected = AssertionFailedError.class)
	public void setterDeTempNomeNaoPodeSerNulo() throws ServiceException {
		Contact.setTempName(null);
		Assert.fail("Deve lançar exceção");
	}

	@Test(expected = AssertionFailedError.class)
	public void setterDeTempNomeNaoPodeSerEmBranco() {
		Contact.setTempName("");
		Assert.fail("Deve lançar exceção");
	}

	@Test
	public void tempNomeValido() throws BarberException {
		Contact.setTempName("Paulo");
		assertEquals("Paulo", Contact.getTempName());
	}

}
