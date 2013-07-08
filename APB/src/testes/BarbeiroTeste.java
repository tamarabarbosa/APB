package testes;

import static org.junit.Assert.*;
import junit.framework.Assert;



import exception.BarbeiroException;
import model.Barbeiro;
import org.junit.Before;
import org.junit.Test;


public class BarbeiroTeste {

	Barbeiro barbeiro =  new Barbeiro();
	
	@Before
	public void setUp() {
		try {
			barbeiro.setNome("Alessandro");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

		try {
			barbeiro.setRg("418757896");
			barbeiro.setTelefone("3389-9085");
			barbeiro.setCpf("02919594150");
			barbeiro.setCadeira("5");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

		

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirNomeNuloPassandoPeloSetter() {
		try {
			barbeiro.setNome(null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirCPFNuloPassandoPeloSetter() {
		try {
			barbeiro.setCpf(null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirRGNuloPassandoPeloSetter() {
		try {
			barbeiro.setRg(null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirTelefoneNuloPassandoPeloSetter() {
		try {
			barbeiro.setTelefone(null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirCadeiraNuloPassandoPeloSetter() {
		try {
			barbeiro.setCadeira(null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComNomeNulo() {
		try {
			new Barbeiro(null, "493.751.185-84", "2258256", "3389-9085", "5");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComCpfNulo() {
		try {
			new Barbeiro("Alessandro", null, "2258256", "3389-9085", "5");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComRgNulo() {
		try {
			new Barbeiro("Alessandro", "493.751.185-84", null, "3389-9085", "5");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComTelefoneNulo() {
		try {
			new Barbeiro("Alessandro", "493.751.185-84", "2258256", null, "5");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComCadeiraNulo() {
		try {
			new Barbeiro("Alessandro", "493.751.185-84", "2258256",
					"3389-9085", null);
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = AssertionError.class)
	public void cpfNaoPodePassarQuandoInvalido() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setCpf("000000000");
			fail();
		} catch (BarbeiroException e) {
		}
	}

	@Test(expected = AssertionError.class)
	public void nomeNãoPodeConterNumeros() {
		Barbeiro barbeiro = new Barbeiro();

		try {
			barbeiro.setNome("456");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = AssertionError.class)
	public void rgNaoPodeConterLetras() {
		Barbeiro barbeiro = new Barbeiro();

		try {
			barbeiro.setRg("4654654ASD");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = AssertionError.class)
	public void numeroDaCadeiraNaoPodeSerUmaLetra() {
		Barbeiro barbeiro = new Barbeiro();

		try {
			barbeiro.setCadeira("asd");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = AssertionError.class)
	public void numeroDoTelefoneNaoPodeConterLetras() {
		Barbeiro barbeiro = new Barbeiro();

		try {
			barbeiro.setTelefone("65465a4");
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeParaGetterDeNomeDeBarbeiro() {
		assertEquals("Alessandro",barbeiro.getNome());
	}
	
	
	@Test
	public void testeParaGetterDeCPFDeBarbeiro() {
		assertEquals("02919594150",barbeiro.getCpf());
	}
	
	@Test
	public void testeParaGetterDeRGDeBarbeiro() {
		assertEquals("418757896",barbeiro.getRg());
	}
	
	@Test
	public void testeParaGetterDeTelefoneDeBarbeiro() {
		assertEquals("3389-9085",barbeiro.getTelefone());
	}
	
	@Test
	public void testeParaGetterDeCadeiraDeBarbeiro() {
		assertEquals("5",barbeiro.getCadeira());
	}
	
	@Test
	public void setDeBarbeiroDeveFuncionar(){
		Barbeiro barbeiro =  new Barbeiro();
		try {
			barbeiro.setNome("Alessandrô");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Alessandrô", barbeiro.getNome());
	}
	
	@Test(expected =  BarbeiroException.class)
	public void cpfPassadoEmBranco() throws BarbeiroException{
		barbeiro.setCpf("");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test(expected =  BarbeiroException.class)
	public void cpfInvalido() throws BarbeiroException{
		barbeiro.setCpf("123.654.456-75");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test(expected =  AssertionError.class)
	public void rgPassadoComLetras() throws BarbeiroException{
		barbeiro.setRg("asasa");
		Assert.fail("Deve lançar uma exceção");
	}
	@Test(expected =  BarbeiroException.class)
	public void rgPassadoEmBrancro() throws BarbeiroException{
		barbeiro.setRg("");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test(expected =  BarbeiroException.class)
	public void nomePassadoEmBrancro() throws BarbeiroException{
		barbeiro.setNome("");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test(expected =  BarbeiroException.class)
	public void telefonePassadoEmBrancro() throws BarbeiroException{
		barbeiro.setTelefone("");
		Assert.fail("Deve lançar uma exceção");
	}
	
	@Test(expected =  BarbeiroException.class)
	public void cadeiraPassadoEmBrancro() throws BarbeiroException{
		barbeiro.setCadeira("");
		Assert.fail("Deve lançar uma exceção");
	}
	@Test(expected =  AssertionError.class)
	public void cadeiraPassadoComoZero() throws BarbeiroException{
		barbeiro.setCadeira("0");
		Assert.fail("Deve lançar uma exceção");
	}
}
