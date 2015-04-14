package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AgendaDAO;
import model.Phonebook;

public class ContactController {

	private static ContactController instance;

	private ContactController() {
	}
	//this method include barber on the agenda
	public boolean incluir(Phonebook phonebook) throws SQLException {
		if (phonebook == null) {
			return false;
		} 
		else {
			AgendaDAO.getInstance().incluir(phonebook);
			return true;
		}
	}
	//this method change barber on the agenda
	public boolean alterar(String nome, Phonebook phonebook) throws SQLException {
		if (phonebook == null) {
			return false;
		} 
		else {
			Phonebook agenda_alterado = phonebook;
			AgendaDAO.getInstance().alterar(nome, agenda_alterado, phonebook);
			return true;
		}
	}
	//this method exclude barber on the agenda
	public boolean excluir(Phonebook contato) throws SQLException {
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
	public ResultSet mostrarContatosCadastrados(Phonebook contato)
			throws SQLException {
		return AgendaDAO.getInstance().mostrarContatosCadastrados(contato);
	}
	//show results by name
	public ResultSet pesquisarPorNome(Phonebook contato) throws SQLException {
		return AgendaDAO.getInstance().pesquisarPorNome(contato);
	}
	//show results by phone
	public ResultSet pesquisarPorTelefone(Phonebook contato) throws SQLException {
		return AgendaDAO.getInstance().pesquisarPorTelefone(contato);
	}

}
