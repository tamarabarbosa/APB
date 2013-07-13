package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ServicoPrestado;

public class ServicoPrestadoDAO {

	private static ServicoPrestadoDAO instance;

	private ServicoPrestadoDAO() {

	}

	public static ServicoPrestadoDAO getInstance() {
		if (instance == null)
			instance = new ServicoPrestadoDAO();
		return instance;
	}

	public boolean incluir(ServicoPrestado servico) throws SQLException {
		if (servico != null) {
			this.updateQuery("INSERT INTO "
					+ "servicoprestado (nome, preco, barbeiro, data) VALUES ("
					+ "\"" + servico.getNomeServico() + "\", " + "\""
					+ servico.getPreco() + "\", " + "\""
					+ servico.getNomeBarbeiro() + "\", " + "\""
					+ servico.getData() + "\"); ");
			return true;
		}

		return false;
	}

	public void excluir(ServicoPrestado servico) throws SQLException {
		this.updateQuery("DELETE FROM servicoprestado WHERE "
				+ "servicoprestado.nome = \"" + servico.getNomeServico()
				+ "\" AND servicoprestado.preco = \"" + servico.getPreco()
				+ "\" AND servicoprestado.barbeiro = \""
				+ servico.getNomeBarbeiro() + "\" AND servicoprestado.data = \""
				+ servico.getData() + "\";");
	}

	private void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

}
