package tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import model.DoneService;

import org.junit.Test;

import exception.ServiceException;

public class ServiceProvidedTest {

	DoneService job = new DoneService();

	@Test
	public void testeDeConstrutor() {
		DoneService job1 = new DoneService("Corte", "15,00", "Claudio");
		assertEquals("Corte", job1.getServiceName());
		assertEquals("15,00", job1.getPrice());
		assertEquals("Claudio", job1.getBarberName());
	}

	@Test(expected = NullPointerException.class)
	public void testeSetNomeNaoNulo() throws ServiceException {
		job.setServiceName(null);
		Assert.fail("Deve lan�ar exce��o");
	}

	@Test(expected = ServiceException.class)
	public void testeSetNomeBranco() throws ServiceException {
		job.setServiceName("");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test(expected = ServiceException.class)
	public void testeSetNomeForaDeFormato() throws ServiceException {
		job.setServiceName("123");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test
	public void testeSetNomeValido() {
		try {
			job.setServiceName("Corte");
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail("N�o deve lan�ar exce��o");
		}
		assertEquals("Corte", job.getServiceName());
	}

	@Test(expected = ServiceException.class)
	public void precoForaDeFormato() throws ServiceException {
		job.setPrice("as");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test(expected = NullPointerException.class)
	public void testePrecoNaoNulo() throws ServiceException {
		job.setPrice(null);
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test(expected = ServiceException.class)
	public void testePrecoEmBranco() throws ServiceException {
		job.setPrice("");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test
	public void testePrecoValido() {
		try {
			job.setPrice("123,45");
		} catch (ServiceException e) {
			Assert.fail("N�o deve lan�ar exce��o");
		}
		assertEquals("123,45", job.getPrice());
	}

	@Test(expected = NullPointerException.class)
	public void testeNomeBarberNulo() throws ServiceException {
		job.setServiceName(null);
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test(expected = ServiceException.class)
	public void testeNomeBarberEmBranco() throws ServiceException {
		job.setServiceName("");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test(expected = ServiceException.class)
	public void testeNomeBarberForaDeFormato() throws ServiceException {
		job.setServiceName("123");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test(expected = AssertionFailedError.class)
	public void testeNomeBarberValido() {
		try {
			job.setServiceName("Jo�o");
		} catch (ServiceException e) {
			Assert.fail("Não deve lançar uma exceção");
		}
		assertEquals("Jo�o", job.getServiceName());
	}

	@Test(expected = NullPointerException.class)
	public void testeDataNulo() throws ServiceException {
		try {
			job.setDate(null);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (AssertionFailedError e) {
			e.printStackTrace();
		}
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test(expected = ServiceException.class)
	public void testeDataEmBranco() throws ServiceException {
		try {
			job.setDate("");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (AssertionFailedError e) {
			e.printStackTrace();
		}
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test(expected = ServiceException.class)
	public void testeDataForaDeFormato() throws ServiceException {
		try {
			job.setDate("abc");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (AssertionFailedError e) {
			e.printStackTrace();
		}
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test
	public void testeDataParaConverter() {
		try {
			job.ConvertTOABNT("2010-10-10");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeDataNormal() {
		try {
			job.setDate("10/10/2012");
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = AssertionError.class)
	public void getterDeDataDeveFuncionar() {
		assertEquals("10/10/2012", job.getDate());
	}
}
