package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DoneServiceDAO;
import model.DoneService;

;

public class DoneServiceController {

	private DoneServiceController() {
	}

	public static DoneServiceController getInstance() {
		if (instance == null) {
			instance = new DoneServiceController();
		} else {
			/* nothing to do. */
		}
		return instance;

	}

	private static DoneServiceController instance;

	// Method used to insert a service
	public boolean inserir(DoneService servico) throws SQLException {
		if (servico != null) {
			DoneServiceDAO.getInstance().insert(servico);
			return true;
		} else {
			return false;
		}
	}

	// Method used to delete a service
	public boolean delete(DoneService servico) throws SQLException {
		if (servico != null) {
			DoneServiceDAO.getInstance().delete(servico);
			return true;
		} else {
			return false;
		}
	}

	// Method that gives access to the registered services
	public ResultSet mostrarServicosPrestadosCadastrados(DoneService servico)
			throws SQLException {
		return DoneServiceDAO.getInstance()
				.mostrarServicosPrestadosCadastrados(servico);
	}

}
