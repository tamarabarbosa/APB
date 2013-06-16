package control;

import java.sql.SQLException;
import dao.AgendaDAO;
import model.Agenda;

public class AgendaController {
	
private static AgendaController instance;
	
	public void incluir(Agenda agenda) throws SQLException {
		AgendaDAO.getInstance().incluir(agenda);
	}
	
	public void alterar(Agenda agenda) throws SQLException {
		Agenda agenda_alterado = agenda;
		AgendaDAO.getInstance().alterar(agenda_alterado, agenda);
	}

	public void excluir(Agenda agenda) throws SQLException {
		AgendaDAO.getInstance().excluir(agenda);
	}
	
	private AgendaController() {}
	
	public static AgendaController getInstance() {
		if(instance == null)
			instance = new AgendaController();
		return instance;
	}

}
