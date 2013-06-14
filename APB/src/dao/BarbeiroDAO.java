package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import view.CadastroBarbeiro;
import model.Barbeiro;
import dao.FactoryConnection;

public class BarbeiroDAO {
	
	private static BarbeiroDAO instance;

	
	private BarbeiroDAO(){
	}
	public static BarbeiroDAO getInstance(){
		if(instance == null)
			instance = new BarbeiroDAO();
		return instance;
	}
	
	public void incluir(Barbeiro barbeiro) throws SQLException{
		this.updateQuery("INSERT INTO " +
					"barbeiro (nome, cpf, rg, telefone, cadeira) VALUES (" +
					"\"" + barbeiro.getNome() + "\", " +
					"\"" + barbeiro.getCpf()+ "\", " +
					"\"" + barbeiro.getRg() + "\", " +
					"\"" + barbeiro.getTelefone() + "\" +" +
					"\"" + barbeiro.getCadeira() + "\"); "
				);
	
	}
	
	public void alterar(Barbeiro barbeiro_alterado, Barbeiro barbeiro) throws SQLException {			
		this.updateQuery("UPDATE barbeiro SET " +
				"nome = \"" + barbeiro_alterado.getNome() + "\", " +
				"cpf = \"" + barbeiro_alterado.getCpf() + "\", " +
				"rg = \"" + barbeiro_alterado.getRg() + "\", " +
				"telefone = \"" + barbeiro_alterado.getTelefone() + "\""+
				"cadeira = \"" + barbeiro_alterado.getCadeira() + "\""+
				" WHERE " +
				" barbeiro.cpf = \"" + CadastroBarbeiro.getOldCpf() + "\";"
				);
	}

	public void excluir(Barbeiro barbeiro) throws SQLException {
		this.updateQuery("DELETE FROM barbeiro WHERE " +
				"barbeiro.nome = \"" + barbeiro.getNome() + "\";"
				);
	}
	
	
	public void updateQuery(String message) throws SQLException{
		Connection connection =  FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(message);
		preparedStatement.executeUpdate();		
		preparedStatement.close();
		connection.close();
	}
	
}
