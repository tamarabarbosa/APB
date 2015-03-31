package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ServicoPrestado;

public class ServicoPrestadoDAO {

	private static ServicoPrestadoDAO instance;

	private ServicoPrestadoDAO() {

	}
	//this method check if existence of service
	public static ServicoPrestadoDAO getInstance() {
		if (instance == null)
			instance = new ServicoPrestadoDAO();
		return instance;
	}
	//this method include a new job done
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
	//this method exclude a job done
	public boolean excluir(ServicoPrestado servico) throws SQLException {
		if (servico != null) {
			this.updateQuery("DELETE FROM servicoprestado WHERE "
					+ "servicoprestado.idservicoprestado = \""
					+ pesquisar(servico) + "\";");
			return true;
		}

		return false;
	}
	//this method realize a seach to job done
	private String pesquisar(ServicoPrestado servico) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE "
						+ "servicoprestado.nome = \""
						+ servico.getNomeServico()
						+ "\" AND servicoprestado.preco = \""
						+ servico.getPreco()
						+ "\" AND servicoprestado.barbeiro = \""
						+ servico.getNomeBarbeiro()
						+ "\" AND servicoprestado.data = \""
						+ servico.getData() + "\";");
		ResultSet rs = preparedStatement.executeQuery();
		rs.next();
		return rs.getString("idservicoprestado");
	}
	//this method update the query
	private void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	//this method show the done services and registered
	public ResultSet mostrarServicosPrestadosCadastrados(ServicoPrestado servico)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection
				.createStatement()
				.executeQuery(
						"SELECT nome, preco, barbeiro, data FROM servicoprestado ORDER BY data;");

		return rs;
	}

}
