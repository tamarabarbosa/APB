package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Servico;

public class ServicoDAO {
	
	private static ServicoDAO instance;
	
	private ServicoDAO(){
	}
	public static ServicoDAO getInstance(){
		if(instance == null)
			instance = new ServicoDAO();
		return instance;
	
	}
	
	public void incluir(Servico servico) throws SQLException{
		this.updateQuery("INSERT INTO " +
					"servico (nome, preco, barbeiro, date) VALUES (" +
					"\"" + servico.getNome() + "\", " +
					"\"" + servico.getPreco() + "\", " +
					"\"" + servico.getNomeBarbeiro()+ "\", " +
					"\"" + servico.getData() + "\"); "
				);
	
	}
	
	public void alterar(Servico servico_alterado, Servico servico) throws SQLException {			
		this.updateQuery("UPDATE servico SET " +
				"nome = \"" + servico_alterado.getNome() + "\", " +
				"preco = \"" + servico_alterado.getPreco() + "\", " +
				" WHERE " +
				"servico.preco = \"" + servico.getPreco() + "\";"
				);
	}

	public void excluir(Servico servico) throws SQLException {
		this.updateQuery("DELETE FROM servico WHERE " +
				"servico.nome = \"" + servico.getNome() + "\";"
				);
	}

	
	private void updateQuery(String message) throws SQLException{
		Connection connection =  FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(message);
		preparedStatement.executeUpdate();		
		preparedStatement.close();
		connection.close();
	}
	
}


