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
					+ "servicoprestado (nome, preco, barbeiro, data) VALUES (" + "\""
					+ servico.getNomeServico() + "\", " + "\"" 
					+ servico.getPreco() + "\", " + "\"" 
					+ servico.getNomeBarbeiro() + "\", " + "\""
					+ servico.getData() + "\"); "
					);
			return true;
		}
		
		return false;
	}

	public void alterar(ServicoPrestado servico_alterado, ServicoPrestado servico) throws SQLException {
		this.updateQuery("UPDATE servicoprestado SET " + "nome = \""
				+ servico_alterado.getNomeServico() + "\", " + "preco = \""
				+ servico_alterado.getPreco() + "\", " + "barbeiro = \""
				+ servico_alterado.getNomeBarbeiro() + "\", " + "data = \""
				+ servico_alterado.getData() + "\", " + " WHERE servicoprestado.preco = \"" 
				+ servico.getPreco() + "\";"
				);
	}

	public void excluir(ServicoPrestado servico) throws SQLException {
		this.updateQuery("DELETE FROM servicoprestado WHERE " + "servicoprestado.nome = \""
				+ servico.getNomeServico() + "\";");
	}

	private void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

}
