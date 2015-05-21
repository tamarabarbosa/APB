package tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import model.ServiceType;
import model.ServiceType;

import org.junit.Before;
import org.junit.Test;

import exception.ServiceException;

public class TypeServiceTest {

	ServiceType Service = new ServiceType();

	@Before
	public void setUp() {
		try {
			Service.setNameServiceType("Corte");
			Service.setPrice("14,50");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getterDeNomeDeveRetornarValorPassado() {
		assertEquals("Corte", Service.getNameServiceType());
	}

	@Test
	public void getterDePrecoDeveRetornarValorPassado() {
		assertEquals("14,50", Service.getPrice());
	}

	@Test(expected = NullPointerException.class)
	public void setterDePrecoNaoPodeSerNulo() throws ServiceException {
		Service.setPrice(null);
		Assert.fail("Deve lançar exceção");
	}

	@Test(expected = NullPointerException.class)
	public void setterDeNomeNaoPodeSerNulo() throws ServiceException {
		Service.setNameServiceType(null);
		Assert.fail("Deve lançar exceção");
	}

	@Test(expected = IllegalArgumentException.class)
	public void setterDePrecoNaoPodeSerInvalido() throws ServiceException {
		Service.setPrice("14.50%");
		Assert.fail("Deve lançar exceção");
	}

	@Test(expected = ServiceException.class)
	public void setterDePrecoServiceNaoPodeSerEmBranco()
			throws ServiceException {
		Service.setPrice("");
		Assert.fail("Deve lançar exceção");
	}

	@Test(expected = ServiceException.class)
	public void setterDeNomeServiceNaoPodeSerEmBranco() throws ServiceException {
		Service.setNameServiceType("");
		Assert.fail("Deve lançar exceção");
	}

	@Test(expected = AssertionError.class)
	public void getterDeTempNomeDeveRetornarValorPassado()
			throws ServiceException {
		assertEquals("Corte", ServiceType.getTempName());
	}

	@Test(expected = NullPointerException.class)
	public void setterDeTempNomeNaoPodeSerNulo() throws ServiceException {
		ServiceType.setTempName(null);
		Assert.fail("Deve lançar exceção");
	}

	@Test(expected = ServiceException.class)
	public void setterDeTempNomeNaoPodeSerEmBranco() throws ServiceException {
		ServiceType.setTempName("");
		Assert.fail("Deve lançar exceção");
	}

	@Test
	public void tempNomeValido() {
		try {
			ServiceType.setTempName("Barba");
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail("Não Deve lançar exceção");
		}
		assertEquals("Barba", ServiceType.getTempName());
	}

}
