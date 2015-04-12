package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AgendaDAO;
import model.Agenda;

public class ContactController {

	private static ContactController instance;

	private ContactController() {
	}
	//this method include barber on the agenda
	public boolean incluir(Agenda agenda) throws SQLException {
		if (agenda == null) {
			return false;
		} 
		else {
			AgendaDAO.getInstance().incluir(agenda);
			return true;
		}
	}
	//this method change barber on the agenda
	public boolean alterar(String nome, Agenda agenda) throws SQLException {
		if (agenda == null) {
			return false;
		} 
		else {
			Agenda agenda_alterado = agenda;
			AgendaDAO.getInstance().alterar(nome, agenda_alterado, agenda);
			return true;
		}
	}
	//this method exclude barber on the agenda
	public boolean excluir(Agenda contato) throws SQLException {
		if (contato == null) {
			return false;
		} 
		else {
			AgendaDAO.getInstance().excluir(contato);
			return true;
		}
	}
	//this method check if the instance is null case dont he set new agenda
	public static ContactController getInstance() {
		if (instance == null) {
			instance = new ContactController();
			return instance;
		} 
		else {
			return instance;
		}
	}
	//show results of contacts 
	public ResultSet mostrarContatosCadastrados(Agenda contato)
			throws SQLException {
		return AgendaDAO.getInstance().mostrarContatosCadastrados(contato);
	}
	//show results by name
	public ResultSet pesquisarPorNome(Agenda contato) throws SQLException {
		return AgendaDAO.getInstance().pesquisarPorNome(contato);
	}
	//show results by phone
	public ResultSet pesquisarPorTelefone(Agenda contato) throws SQLException {
		return AgendaDAO.getInstance().pesquisarPorTelefone(contato);
	}

}
