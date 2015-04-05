package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ServicoPrestadoDAO;
import model.ServicoPrestado;

public class ServicoPrestadoController {

	private ServicoPrestadoController() {
	}

	public static ServicoPrestadoController getInstance() {
		if (instance == null) {
			instance = new ServicoPrestadoController();
		} else {
			/* nothing to do. */
		}
		return instance;

	}

	private static ServicoPrestadoController instance;

	// Method used to insert a service
	public boolean inserir(ServicoPrestado servico) throws SQLException {
		if (servico != null) {
			ServicoPrestadoDAO.getInstance().incluir(servico);
			return true;
		} else {
			return false;
		}
	}

	// Method used to delete a service
	public boolean excluir(ServicoPrestado servico) throws SQLException {
		if (servico != null) {
			ServicoPrestadoDAO.getInstance().excluir(servico);
			return true;
		} else {
			return false;
		}
	}

	// Method that gives access to the registered services
	public ResultSet mostrarServicosPrestadosCadastrados(ServicoPrestado servico)
			throws SQLException {
		return ServicoPrestadoDAO.getInstance()
				.mostrarServicosPrestadosCadastrados(servico);
	}

}
