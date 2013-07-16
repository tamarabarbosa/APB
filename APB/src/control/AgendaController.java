package control;

import java.sql.SQLException;
import dao.AgendaDAO;
import dao.BarbeiroDAO;
import model.Agenda;

public class AgendaController {
	
private static AgendaController instance;
	
	public boolean incluir(Agenda agenda) throws SQLException {
		if(agenda == null ){
			return false;
		}else{
			AgendaDAO.getInstance().incluir(agenda);
			return true;
		}
	}
	
	public boolean alterar(Agenda agenda) throws SQLException {
		if(agenda == null ){
			return false;
		}else{
			Agenda agenda_alterado = agenda;
			AgendaDAO.getInstance().alterar(agenda_alterado, agenda);
			return true;
		}
		
	}

	public  boolean excluir(Agenda agenda) throws SQLException {
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
