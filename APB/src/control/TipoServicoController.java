package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.TipoServicoDAO;
import model.TipoServico;

public class TipoServicoController {

	// Stores the current instance of the class
	private static TipoServicoController instance;

	// Method that modify a service type on the system
	public boolean inserir(TipoServico tipoServico) throws SQLException {
		if (tipoServico == null) {
			return false;
		} else {
			TipoServicoDAO.getInstance().incluir(tipoServico);
			return true;
		}
	}

	// Method that change a service type on the system
	public boolean alterar(String nome, TipoServico tipoServico)
			throws SQLException {
		if (tipoServico == null) {
			return false;
		} else {
			TipoServico tipoServico_alterado = tipoServico;
			TipoServicoDAO.getInstance().alterar(nome, tipoServico_alterado,
					tipoServico);
			return true;
		}
	}

	// Method that delete a service type on the system
	public boolean excluir(TipoServico tipoServico) throws SQLException {

		if (tipoServico == null) {
			return false;
		} else {
			TipoServicoDAO.getInstance().excluir(tipoServico);
			return true;
		}
	}

	private TipoServicoController() {
	}

	// Return the current instance or instantiate a new one if 'instance' is
	// null
	public static TipoServicoController getInstance() {
		if (instance == null) {
			instance = new TipoServicoController();
		} else {
			/* nothing to do. */
		}
		return instance;
	}

	// Return a ResultSet interface object with the service types registered on
	// the system
	public ResultSet mostrarTipoServicoCadastrados(TipoServico servico)
			throws SQLException {
		return TipoServicoDAO.getInstance().mostrarTipoServicoCadastrados(
				servico);
	}

	// Search for an specific service type name
	public ResultSet pesquisarPorNome(TipoServico servico) throws SQLException {
		return TipoServicoDAO.getInstance().pesquisarPorNome(servico);
	}

}
