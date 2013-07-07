package control;

import java.sql.SQLException;
import dao.AgendaDAO;
import dao.BarbeiroDAO;
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

	public static boolean excluir(Agenda agenda) throws SQLException {
		if (agenda == null) {
			return false;
		} else {
			AgendaDAO.getInstance().excluir(agenda);
			return true;
		}
	}
	
	private AgendaController() {}
	
	public static AgendaController getInstance() {
		if(instance == null)
			instance = new AgendaController();
		return instance;
	}

}
