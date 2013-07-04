package control;

import java.sql.SQLException;
import dao.BarbeiroDAO;
import model.Barbeiro;

public class BarbeiroController {

	private static BarbeiroController instance;

	public boolean inserir(Barbeiro barbeiro) throws SQLException {
		if (barbeiro == null) {
			return false;
		} else {
			BarbeiroDAO.getInstance().incluir(barbeiro);
			return true;
		}
	}

	public boolean alterar(Barbeiro barbeiro) throws SQLException {
		if (barbeiro == null) {
			return false;
		} else {
			Barbeiro barbeiro_alterado = barbeiro;
			BarbeiroDAO.getInstance().alterar(barbeiro_alterado, barbeiro);
			return true;
		}
	}

	public boolean excluir(Barbeiro barbeiro) throws SQLException {

		if (barbeiro == null) {
			return false;
		} else {
			BarbeiroDAO.getInstance().excluir(barbeiro);
			return true;
		}
	}

	private BarbeiroController() {
	}

	public static BarbeiroController getInstance() {
		if (instance == null)
			instance = new BarbeiroController();
		return instance;
	}

}
