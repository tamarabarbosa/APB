package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Agenda;
import dao.FactoryConnection;

public class AgendaDAO {

	private static AgendaDAO instance;

	private AgendaDAO() {
	}

	public static AgendaDAO getInstance() {
		if (instance == null)
			instance = new AgendaDAO();
		return instance;
	}

	//this method include one schedule in the agenda
	public boolean incluir(Agenda agenda) throws SQLException {
		if (agenda == null)
			return false;
		
		this.updateQuery("INSERT INTO "
				+ "agenda (nome, telefone, descricao) VALUES (" + "\""
				+ agenda.getNome() + "\", " + "\"" + agenda.getTelefone()
				+ "\", " + "\"" + agenda.getDescricao() + "\"); ");
		return true;
	}
	//this method change data on the schedule
	public boolean alterar(String nome, Agenda agenda_alterado, Agenda agenda) throws SQLException {	
		if(agenda == null || agenda_alterado == null)
			return false;
		
		this.updateQuery("UPDATE agenda SET " +
				"nome = \"" + agenda_alterado.getNome() + "\", " +
				"telefone = \"" + agenda_alterado.getTelefone() + "\", "+
				"descricao = \"" + agenda_alterado.getDescricao() + "\""+
				" WHERE " +
				" agenda.nome = \"" + nome + "\";");
			
		return true;
	}
	//this method exclude one event on the schedule
	public boolean excluir(Agenda contato) throws SQLException {
		if(contato ==  null)
			return false;
		
		this.updateQuery("DELETE FROM agenda WHERE " + "agenda.telefone = \""
				+ contato.getTelefone() + "\";");
		return true;
	}
	//this method is responsible to make connection with the database
	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	//this method shows contacts registred on the schedule
	public ResultSet mostrarContatosCadastrados(Agenda contato) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"Select * from agenda;");
		
		return rs;
	}
	//this method search by name in the schedule
	public ResultSet pesquisarPorNome(Agenda contato) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection.prepareStatement("SELECT * FROM agenda WHERE "
				+ "nome = '" + contato.getNome()+ "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by phone in the schedule
	public ResultSet pesquisarPorTelefone(Agenda contato) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		java.sql.PreparedStatement pst = connection.prepareStatement("SELECT * FROM agenda WHERE "
				+ "telefone = '" + contato.getTelefone()+ "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
