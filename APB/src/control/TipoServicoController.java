package control;

import java.sql.SQLException;
import dao.BarbeiroDAO;
import model.Barbeiro;

public class TipoServicoController {

	private static TipoServicoController instance;

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

	private TipoServicoController() {
	}

	public static TipoServicoController getInstance() {
		if (instance == null)
			instance = new TipoServicoController();
		return instance;
	}

}
