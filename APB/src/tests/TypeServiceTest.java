package tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import model.TipoJob;

import org.junit.Before;
import org.junit.Test;

import exception.JobException;


public class TypeServiceTest {

	TipoJob  job =  new TipoJob();

	@Before
	public void setUp(){
		try {
			job.setNomeTipoJob("Corte");
			job.setPreco("14,50");
		} catch (JobException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getterDeNomeDeveRetornarValorPassado(){
		assertEquals("Corte", job.getNomeTipoJob());
	}

	@Test
	public void getterDePrecoDeveRetornarValorPassado(){
		assertEquals("14,50", job.getPreco());
	}

	@Test (expected = NullPointerException.class)
	public void setterDePrecoNaoPodeSerNulo() throws JobException {
		job.setPreco(null);
		Assert.fail("Deve lançar exceção");
	}

	@Test (expected = NullPointerException.class)
	public void setterDeNomeNaoPodeSerNulo() throws JobException {
		job.setNomeTipoJob(null);
		Assert.fail("Deve lançar exceção");
	}

	@Test (expected = IllegalArgumentException.class)
	public void setterDePrecoNaoPodeSerInvalido() throws JobException {
		job.setPreco("14.50%");
		Assert.fail("Deve lançar exceção");
	}

	@Test (expected =  JobException.class)
	public void setterDePrecoJobNaoPodeSerEmBranco() throws JobException {
		job.setPreco("");
		Assert.fail("Deve lançar exceção");
	}

	@Test (expected =  JobException.class)
	public void setterDeNomeJobNaoPodeSerEmBranco() throws JobException {
		job.setNomeTipoJob("");
		Assert.fail("Deve lançar exceção");
	}

	@Test (expected = AssertionError.class)
	public void getterDeTempNomeDeveRetornarValorPassado() throws JobException {
		assertEquals("Corte", TipoJob.getTempNome());
	}

	@Test (expected = NullPointerException.class)
	public void setterDeTempNomeNaoPodeSerNulo() throws JobException {
		TipoJob.setTempNome(null);
		Assert.fail("Deve lançar exceção");
	}


	@Test (expected = JobException.class)
	public void setterDeTempNomeNaoPodeSerEmBranco() throws JobException {
		TipoJob.setTempNome("");
		Assert.fail("Deve lançar exceção");
	}

	@Test
	public void tempNomeValido() {
		try {
			TipoJob.setTempNome("Barba");
		} catch (JobException e) {
			e.printStackTrace();
			Assert.fail("Não Deve lançar exceção");
		}
		assertEquals("Barba", TipoJob.getTempNome());
	}

}
