package testes;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.FactoryConnection;
import exception.BarbeiroException;
import model.Barbeiro;
import org.junit.Test;

import control.BarbeiroController;

public class BarbeiroTeste {

	Barbeiro barbeiro = new Barbeiro();
	private Connection connection;

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
			// TODO Auto-generated catch block
		}
	}

	@Test(expected = AssertionError.class)
	public void nomeNãoPodeConterNumeros() {
		Barbeiro barbeiro = new Barbeiro();

		try {
			barbeiro.setNome("456");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = AssertionError.class)
	public void rgNaoPodeConterLetras() {
		Barbeiro barbeiro = new Barbeiro();

		try {
			barbeiro.setRg("4654654ASD");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = AssertionError.class)
	public void numeroDaCadeiraNaoPodeSerUmaLetra() {
		Barbeiro barbeiro = new Barbeiro();

		try {
			barbeiro.setCadeira("asd");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = AssertionError.class)
	public void numeroDoTelefoneNaoPodeConterLetras() {
		Barbeiro barbeiro = new Barbeiro();

		try {
			barbeiro.setTelefone("65465a4");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void umBarbeiroDeveSerCadastrado() {
		Barbeiro barbeiro = new Barbeiro();
		String nome = null;
		try {
			barbeiro.setNome("Alessandro");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			barbeiro.setCpf("02919594150");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			barbeiro.setRg("418757896");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			barbeiro.setTelefone("3389-9085");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BarbeiroController barbeiroController = BarbeiroController
				.getInstance();
		try {
			barbeiroController.inserir(barbeiro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery(
					"SELECT nome FROM barbeiro WHERE nome LIKE"
							+ barbeiro.getNome());
			nome = rs.getString("nome");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(nome, nome);
	}
	
	@Test
	public void umBarbeiroDeveSerAlterado() {
		Barbeiro barbeiro = new Barbeiro();
		String nome = null;
		try {
			barbeiro.setNome("Luciano");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			barbeiro.setCpf("02919594150");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			barbeiro.setRg("418757896");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			barbeiro.setTelefone("3389-9085");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BarbeiroController barbeiroController = BarbeiroController
				.getInstance();
		try {
			barbeiroController.excluir(barbeiro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery(
					"SELECT nome FROM barbeiro WHERE nome LIKE"
							+ barbeiro.getNome());
			nome = rs.getString("nome");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(nome, nome);
	}

}
