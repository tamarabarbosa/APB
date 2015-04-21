package tests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import exception.BarbeiroException;
import exception.ServicoException;
import model.Phonebook;
import model.Barbeiro;

import org.junit.Before;
import org.junit.Test;


public class BarberTest {

	Barbeiro barber;

	@Before
	public void setUp() {
		try {
			barber =  new Barbeiro();
			barber.setNome("Alessandro");
			barber.setRg("418757896");
			barber.setTelefone("3389-9085");
			barber.setCpf("02919594150");
			barber.setCadeira("10");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = NullPointerException.class)
	public void barberNaoPodePossuirNomeNuloPassandoPeloSetter() {
		try {
			barber.setNome(null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = NullPointerException.class)
	public void barberNaoPodePossuirCPFNuloPassandoPeloSetter() {
		try {
			barber.setCpf(null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = NullPointerException.class)
	public void barberNaoPodePossuirRGNuloPassandoPeloSetter() {
		try {
			barber.setRg(null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = NullPointerException.class)
	public void barberNaoPodePossuirTelefoneNuloPassandoPeloSetter() {
		try {
			barber.setTelefone(null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = NullPointerException.class)
	public void barberNaoPodePossuirCadeiraNuloPassandoPeloSetter() {
		try {
			barber.setCadeira(null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComNomeNulo() {
		try {
			new Barbeiro(null, "493.751.185-84", "2258256", "3389-9085", "10");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComCpfNulo() {
		try {
			new Barbeiro("Alessandro", null, "2258256", "3389-9085", "10");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test (expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComRgNulo() {
		try {
			new Barbeiro("Alessandro", "493.751.185-84", null, "3389-9085", "10");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComTelefoneNulo() {
		try {
			new Barbeiro("Alessandro", "493.751.185-84", "2258256", null, "10");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComCadeiraNulo() {
		try {
			new Barbeiro("Alessandro", "493.751.185-84", "2258256", "3389-9085", null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = AssertionError.class)
	public void cpfNaoPodePassarQuandoInvalido() {
		try {
			barber.setCpf("000000000");
			fail();
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = AssertionError.class)
	public void rgNaoPodeConterLetras() {
		try {
			barber.setRg("4654654ASD");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = AssertionError.class)
	public void numeroDaCadeiraNaoPodeSerUmaLetra() {
		try {
			barber.setCadeira("asd");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = AssertionError.class)
	public void numeroDoTelefoneNaoPodeConterLetras() {
		try {
			barber.setTelefone("65465a4");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeParaGetterDeNomeDeBarbeiro() {
		assertEquals("Alessandro", barber.getNome());
	}

	@Test
	public void testeParaGetterDeCPFDeBarbeiro() {
		assertEquals("02919594150", barber.getCpf());
	}

	@Test
	public void testeParaGetterDeRGDeBarbeiro() {
		assertEquals("418757896", barber.getRg());
	}

	@Test
	public void testeParaGetterDeTelefoneDeBarbeiro() {
		assertEquals("3389-9085", barber.getTelefone());
	}

	@Test
	public void testeParaGetterDeCadeiraDeBarbeiro() {
		assertEquals("10", barber.getCadeira());
	}

	@Test
	public void testeParaGetterDeTempNomeDeBarbeiro() {
		assertEquals(null, Barbeiro.getTempNome());
	}

	@Test
	public void setDeBarbeiroDeveFuncionar() {
		try {
			barber.setNome("Alessandro");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
		assertEquals("Alessandro", barber.getNome());
	}

	@Test (expected = BarbeiroException.class)
	public void nameComNumero() throws BarbeiroException {
		barber.setNome("J040");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  BarbeiroException.class)
	public void cpfPassadoEmBranco() throws BarbeiroException {
		barber.setCpf("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  BarbeiroException.class)
	public void cpfInvalido() throws BarbeiroException {
		barber.setCpf("123.654.456-75");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  AssertionError.class)
	public void rgPassadoComLetras() throws BarbeiroException {
		barber.setRg("asasa");
		Assert.fail("Deve lançar uma exceção");
	}
	@Test (expected =  BarbeiroException.class)
	public void rgPassadoEmBrancro() throws BarbeiroException {
		barber.setRg("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  BarbeiroException.class)
	public void namePassadoEmBrancro() throws BarbeiroException {
		barber.setNome("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  BarbeiroException.class)
	public void telefonePassadoEmBrancro() throws BarbeiroException {
		barber.setTelefone("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected =  BarbeiroException.class)
	public void cadeiraPassadoEmBrancro() throws BarbeiroException {
		barber.setCadeira("");
		Assert.fail("Deve lançar uma exceção");
	}
	@Test (expected =  AssertionError.class)
	public void cadeiraPassadoComoZero() throws BarbeiroException {
		barber.setCadeira("0");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected = BarbeiroException.class)
	public void cadeiraPassadoComMaisDeDoisDigitos() throws BarbeiroException {
		barber.setCadeira("1000");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected = AssertionError.class)
	public void getterDeTempNomeDeveRetornarValorPassado() throws ServicoException {
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected = AssertionFailedError.class)
	public void setterDeTempNomeNaoPodeSerNulo() throws ServicoException {
		Barbeiro.setTempNome(null);
		Assert.fail("Deve lançar uma exceção");
	}


	@Test (expected = AssertionFailedError.class)
	public void setterDeTempNomeNaoPodeSerEmBranco() {
		Barbeiro.setTempNome("");
		Assert.fail("Deve lançar uma exceção");
	}

	@Test (expected = AssertionError.class)
	public void tempNomeValido() throws BarbeiroException {
		Barbeiro.setTempNome("João");
		assertEquals("João", Phonebook.getTempNome());
	}
}
