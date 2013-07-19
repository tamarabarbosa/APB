package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.AlterarContato;
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

	public boolean incluir(Agenda agenda) throws SQLException {
		if (agenda == null)
			return false;
		
		this.updateQuery("INSERT INTO "
				+ "Agenda (nome, telefone, descricao) VALUES (" + "\""
				+ agenda.getNome() + "\", " + "\"" + agenda.getTelefone()
				+ "\", " + "\"" + agenda.getDescricao() + "\"); ");
		return true;
	}

	public boolean alterar(Agenda agenda_alterado, Agenda agenda) throws SQLException {	
		if(agenda == null || agenda_alterado == null)
			return false;
		
		this.updateQuery("UPDATE agenda SET " +
				"nome = \"" + agenda_alterado.getNome() + "\", " +
				"telefone = \"" + agenda_alterado.getTelefone() + "\", "+
				"descricao = \"" + agenda_alterado.getDescricao() + "\""+
				" WHERE " +
				" agenda.telefone = \"" + AlterarContato.getTelefoneAntigo() + "\";");
			
		return true;
	}

	public boolean excluir(Agenda agenda) throws SQLException {
		if(agenda ==  null)
			return false;
		
		this.updateQuery("DELETE FROM agenda WHERE " + "agenda.telefone = \""
				+ agenda.getTelefone() + "\";");
		return true;
	}

	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	
	public ResultSet mostrarContatosCadastrados(Agenda contato) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection.createStatement().executeQuery(
				"Select nome, telefone, descricao from agenda;");
		
		return rs;
	}

}
