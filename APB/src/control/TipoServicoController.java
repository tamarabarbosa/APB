package control;

import java.sql.SQLException;
import dao.TipoServicoDAO;
import model.TipoServico;

public class TipoServicoController {

	private static TipoServicoController instance;

	public boolean inserir(TipoServico tipoServico) throws SQLException {
		if (tipoServico == null) {
			return false;
		} else {
			TipoServicoDAO.getInstance().incluir(tipoServico);
			return true;
		}
	}

	public boolean alterar(TipoServico tipoServico) throws SQLException {
		if (tipoServico == null) {
			return false;
		} else {
			Barbeiro barbeiro_alterado = barbeiro;
			TipoServicoDAO.getInstance().alterar(barbeiro_alterado, tipoServico);
			return true;
		}
	}

	public boolean excluir(Barbeiro barbeiro) throws SQLException {

		if (barbeiro == null) {
			return false;
		} else {
			TipoServicoDAO.getInstance().excluir(barbeiro);
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
