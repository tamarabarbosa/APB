package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import view.AlterarBarbeiro;

import model.Barbeiro;



public class BarbeiroDAO {

	private static BarbeiroDAO instance;

	private BarbeiroDAO() {
	}

	public static BarbeiroDAO getInstance() {
		if (instance == null)
			instance = new BarbeiroDAO();
		return instance;
	}

	public boolean incluir(Barbeiro barbeiro) throws SQLException {
		if (barbeiro == null) {
			return false;
		} else {
			this.updateQuery("INSERT INTO "
					+ "barbeiro (nome, cpf, rg, telefone, cadeira) VALUES ("
					+ "\"" + barbeiro.getNome() + "\", " + "\""
					+ barbeiro.getCpf() + "\", " + "\"" + barbeiro.getRg()
					+ "\", " + "\"" + barbeiro.getTelefone() + "\", " + "\""
					+ barbeiro.getCadeira() + "\"); ");

			return true;
		}
	}

	public boolean alterar(Barbeiro barbeiro_alterado, Barbeiro barbeiro)
			throws SQLException {
		if (barbeiro_alterado == null || barbeiro == null) {
			return false;
		} else {
			this.updateQuery("UPDATE barbeiro SET nome = '"
					+ barbeiro_alterado.getNome() + "', " + "cpf = '"
					+ barbeiro_alterado.getCpf() + "', " + "rg = '"
					+ barbeiro_alterado.getRg() + "', " + "telefone = '"
					+ barbeiro_alterado.getTelefone() + "', " + "cadeira = '"
					+ barbeiro_alterado.getCadeira() + "' WHERE"
					+ " cpf = '" + AlterarBarbeiro.getCpfAntigo() + "';");

			return true;
		}
	}

	public boolean excluir(Barbeiro barbeiro) throws SQLException {
		if (barbeiro == null) {
			return false;
		} else {
			this.updateQuery("DELETE FROM barbeiro WHERE "
					+ "barbeiro.nome = \"" + barbeiro.getNome() + "\";");
			return true;

		}
	}

	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

}
