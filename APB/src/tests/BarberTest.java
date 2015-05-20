package tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import exception.BarberException;
import exception.JobException;
import model.Phonebook;
import model.Barber;

import org.junit.Before;
import org.junit.Test;


public class BarberTest {

	Barber barber;

	@Before
	public void setUp() {
		try {
			barber =  new Barber();
			barber.setName("Alessandro");
			barber.setRg("418757896");
			barber.setPhoneNumber("3389-9085");
			barber.setCpf("02919594150");
			barber.setChair("10");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarberException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = NullPointerException.class)
	public void barberNaoPodePossuirNomeNuloPassandoPeloSetter() {
		try {
			barber.setName(null);
		} catch (BarberException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = NullPointerException.class)
	public void barberNaoPodePossuirCPFNuloPassandoPeloSetter() {
		try {
			barber.setCpf(null);
		} catch (BarberException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = NullPointerException.class)
	public void barberNaoPodePossuirRGNuloPassandoPeloSetter() {
		try {
			barber.setRg(null);
		} catch (BarberException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = NullPointerException.class)
	public void barberNaoPodePossuirPhoneNuloPassandoPeloSetter() {
		try {
			barber.setPhoneNumber(null);
		} catch (BarberException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = NullPointerException.class)
	public void barberNaoPodePossuirChairNuloPassandoPeloSetter() {
		try {
			barber.setChair(null);
		} catch (BarberException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = IllegalArgumentException.class)
	public void contrutorDeBarberNaoPodePassarComNomeNulo() {
		try {
			new Barber(null, "493.751.185-84", "2258256", "3389-9085", "10");
		} catch (BarberException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = IllegalArgumentException.class)
	public void contrutorDeBarberNaoPodePassarComCpfNulo() {
		try {
			new Barber("Alessandro", null, "2258256", "3389-9085", "10");
		} catch (BarberException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = IllegalArgumentException.class)
	public void contrutorDeBarberNaoPodePassarComRgNulo() {
		try {
			new Barber("Alessandro", "493.751.185-84", null, "3389-9085", "10");
		} catch (BarberException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarberNaoPodePassarComPhoneNulo() {
		try {
			new Barber("Alessandro", "493.751.185-84", "2258256", null, "10");
		} catch (BarberException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void contrutorDeBarberNaoPodePassarComChairNulo() {
		try {
			new Barber("Alessandro", "493.751.185-84", "2258256", "3389-9085", null);
		} catch (BarberException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = AssertionError.class)
	public void cpfNaoPodePassarQuandoInvalido() {
		try {
			barber.setCpf("000000000");
			fail();
		} catch (BarberException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = AssertionError.class)
	public void rgNaoPodeConterLetras() {
		try {
			barber.setRg("4654654ASD");
		} catch (BarberException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = AssertionError.class)
	public void numeroDaChairNaoPodeSerUmaLetra() {
		try {
			barber.setChair("asd");
		} catch (BarberException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = AssertionError.class)
	public void numeroDoPhoneNaoPodeConterLetras() {
		try {
			barber.setPhoneNumber("65465a4");
		} catch (BarberException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeParaGetterDeNomeDeBarber() {
		assertEquals("Alessandro", barber.getName());
	}

	@Test
	public void testeParaGetterDeCPFDeBarber() {
		assertEquals("02919594150", barber.getCpf());
	}

	@Test
	public void testeParaGetterDeRGDeBarber() {
		assertEquals("418757896", barber.getRg());
	}

	@Test
	public void testeParaGetterDePhoneDeBarber() {
		assertEquals("3389-9085", barber.getPhoneNumber());
	}

	@Test
	public void testeParaGetterDeChairDeBarber() {
		assertEquals("10", barber.getChair());
	}

	@Test
	public void testeParaGetterDeTempNomeDeBarber() {
		assertEquals(null, Barber.getTempName());
	}

	@Test
	public void setDeBarberDeveFuncionar() {
		try {
			barber.setName("Alessandro");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarberException e) {
			e.printStackTrace();
		}
		assertEquals("Alessandro", barber.getName());
	}

	@Test (expected = BarberException.class)
	public void nameComNumero() throws BarberException {
		barber.setName("J040");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  BarberException.class)
	public void cpfPassadoEmBranco() throws BarberException {
		barber.setCpf("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  BarberException.class)
	public void cpfInvalido() throws BarberException {
		barber.setCpf("123.654.456-75");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  AssertionError.class)
	public void rgPassadoComLetras() throws BarberException {
		barber.setRg("asasa");
		Assert.fail("Deve lançar uma exceção");
	}
	@Test (expected =  BarberException.class)
	public void rgPassadoEmBrancro() throws BarberException {
		barber.setRg("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  BarberException.class)
	public void namePassadoEmBrancro() throws BarberException {
		barber.setName("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  BarberException.class)
	public void telefonePassadoEmBrancro() throws BarberException {
		barber.setPhoneNumber("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  BarberException.class)
	public void chairPassadoEmBrancro() throws BarberException {
		barber.setChair("");
		Assert.fail("Deve lançar uma exceção");
	}
	@Test (expected =  AssertionError.class)
	public void chairPassadoComoZero() throws BarberException {
		barber.setChair("0");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected = BarberException.class)
	public void chairPassadoComMaisDeDoisDigitos() throws BarberException {
		barber.setChair("1000");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected = AssertionError.class)
	public void getterDeTempNomeDeveRetornarValorPassado() throws JobException {
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected = AssertionFailedError.class)
	public void setterDeTempNomeNaoPodeSerNulo() throws JobException {
		Barber.setTempName(null);
		Assert.fail("Deve lançar uma exceção");
	}


	@Test (expected = AssertionFailedError.class)
	public void setterDeTempNomeNaoPodeSerEmBranco() {
		Barber.setTempName("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected = AssertionError.class)
	public void tempNomeValido() throws BarberException {
		Barber.setTempName("João");
		assertEquals("João", Phonebook.getTempName());
	}
}
