package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import view.AlterarContato;

import model.Agenda;
import dao.FactoryConnection;

public class AgendaDAO {
	
	private static AgendaDAO instance;
	
	private AgendaDAO(){
	}
		
		public static AgendaDAO getInstance(){
			if(instance == null)
				instance = new AgendaDAO();
			return instance;
	}
		
	public void incluir(Agenda agenda) throws SQLException{
		
		this.updateQuery("INSERT INTO " +
				"Agenda (nome, telefone, descricao) VALUES (" +
				"\"" + agenda.getNome() + "\", " +
				"\"" + agenda.getTelefone() + "\", " +
				"\"" + agenda.getDescricao() + "\"); "
			);
	}
		
	public void alterar(Agenda agenda_alterado, Agenda agenda) throws SQLException {			
		this.updateQuery("UPDATE agenda SET " +
				"nome = \"" + agenda_alterado.getNome() + "\", " +
				"telefone = \"" + agenda_alterado.getTelefone() + "\""+
				"descricao = \"" + agenda_alterado.getDescricao() + "\""+
				" WHERE " +
				" agenda.telefone = \"" + AlterarContato.getTelefoneAntigo() + "\";"
				);
	}
	
	public void excluir(Agenda agenda) throws SQLException {
		this.updateQuery("DELETE FROM agenda WHERE " +
				"agenda.telefone = \"" + agenda.getTelefone() + "\";"
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
