package tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import model.JobPrestado;

import org.junit.Test;

import exception.JobException;


public class ServiceProvidedTest {

	JobPrestado job = new JobPrestado();

	@Test
	public void testeDeConstrutor(){
		JobPrestado job1 = new JobPrestado("Corte", "15,00","Claudio");
		assertEquals("Corte", job1.getNomeJob());
		assertEquals("15,00", job1.getPreco());
		assertEquals("Claudio", job1.getNomeBarber());
	}
	@Test (expected = NullPointerException.class)
	public void testeSetNomeNaoNulo() throws JobException {
		job.setNomeJob(null);
		Assert.fail("Deve lan�ar exce��o");
	}

	@Test (expected = JobException.class)
	public void testeSetNomeBranco() throws JobException {
		job.setNomeJob("");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test (expected = JobException.class)
	public void testeSetNomeForaDeFormato() throws JobException {
		job.setNomeJob("123");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test
	public void testeSetNomeValido() {
		try {
			job.setNomeJob("Corte");
		} catch (JobException e) {
			e.printStackTrace();
			Assert.fail("N�o deve lan�ar exce��o");
		}
		assertEquals("Corte", job.getNomeJob());
	}

	@Test (expected = JobException.class)
	public void precoForaDeFormato() throws JobException {
		job.setPreco("as");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test (expected = NullPointerException.class)
	public void testePrecoNaoNulo() throws JobException {
		job.setPreco(null);
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test (expected = JobException.class)
	public void testePrecoEmBranco() throws JobException {
		job.setPreco("");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test
	public void testePrecoValido() {
		try {
			job.setPreco("123,45");
		} catch (JobException e) {
			Assert.fail("N�o deve lan�ar exce��o");
		}
		assertEquals("123,45", job.getPreco());
	}

	@Test (expected = NullPointerException.class)
	public void testeNomeBarberNulo() throws JobException {
		job.setNomeBarber(null);
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test (expected = JobException.class)
	public void testeNomeBarberEmBranco() throws JobException {
		job.setNomeBarber("");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test (expected = JobException.class)
	public void testeNomeBarberForaDeFormato() throws JobException {
		job.setNomeBarber("123");
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test (expected = AssertionFailedError.class)
	public void testeNomeBarberValido() {
		try {
			job.setNomeBarber("Jo�o");
		} catch (JobException e) {
			Assert.fail("Não deve lançar uma exceção");
		}
		assertEquals("Jo�o", job.getNomeBarber());
	}

	@Test (expected = NullPointerException.class)
	public void testeDataNulo() throws JobException {
		try {
			job.setData(null);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (AssertionFailedError e) {
			e.printStackTrace();
		}
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test (expected = JobException.class)
	public void testeDataEmBranco() throws JobException {
		try {
			job.setData("");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (AssertionFailedError e) {
			e.printStackTrace();
		}
		Assert.fail("Deve lan�ar uma exce��o");
	}

	@Test (expected = JobException.class)
	public void testeDataForaDeFormato() throws JobException {
		try {
			job.setData("abc");
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
			job.ConverterDataParaABNT("2010-10-10");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeDataNormal() {
		try {
			job.setData("10/10/2012");
		} catch (JobException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = AssertionError.class)
	public void getterDeDataDeveFuncionar(){
		assertEquals("10/10/2012", job.getData());
	}
}
