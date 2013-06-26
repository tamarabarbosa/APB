package control;

import java.sql.SQLException;
import dao.BarbeiroDAO;
import model.Barbeiro;

public class BarbeiroController {

	private static BarbeiroController instance;

	public void inserir(Barbeiro barbeiro) throws SQLException {
		BarbeiroDAO.getInstance().incluir(barbeiro);
	}

	public void alterar(Barbeiro barbeiro) throws SQLException {
		Barbeiro barbeiro_alterado = barbeiro;
		BarbeiroDAO.getInstance().alterar(barbeiro_alterado, barbeiro);
	}

	public void excluir(Barbeiro barbeiro) throws SQLException {
		BarbeiroDAO.getInstance().excluir(barbeiro);
	}

	private BarbeiroController() {
	}

	public static BarbeiroController getInstance() {
		if (instance == null)
			instance = new BarbeiroController();
		return instance;
	}

}
