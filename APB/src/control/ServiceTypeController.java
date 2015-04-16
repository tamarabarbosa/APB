package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ServiceTypeDAO;
import model.ServiceType;

public class ServiceTypeController {

	// Stores the current instance of the class
	private static ServiceTypeController instance;

	// Method that modify a service type on the system
	public boolean inserir(ServiceType tipoServico) throws SQLException {
		if (tipoServico == null) {
			return false;
		} else {
			ServiceTypeDAO.getInstance().incluir(tipoServico);
			return true;
		}
	}

	// Method that change a service type on the system
	public boolean alterar(String nome, ServiceType tipoServico)
			throws SQLException {
		if (tipoServico == null) {
			return false;
		} else {
			ServiceType tipoServico_alterado = tipoServico;
			ServiceTypeDAO.getInstance().alterar(nome, tipoServico_alterado,
					tipoServico);
			return true;
		}
	}

	// Method that delete a service type on the system
	public boolean excluir(ServiceType tipoServico) throws SQLException {

		if (tipoServico == null) {
			return false;
		} else {
			ServiceTypeDAO.getInstance().excluir(tipoServico);
			return true;
		}
	}

	private ServiceTypeController() {
	}

	// Return the current instance or instantiate a new one if 'instance' is
	// null
	public static ServiceTypeController getInstance() {
		if (instance == null) {
			instance = new ServiceTypeController();
		} else {
			/* nothing to do. */
		}
		return instance;
	}

	// Return a ResultSet interface object with the service types registered on
	// the system
	public ResultSet mostrarTipoServicoCadastrados(ServiceType servico)
			throws SQLException {
		return ServiceTypeDAO.getInstance().mostrarTipoServicoCadastrados(
				servico);
	}

	// Search for an specific service type name
	public static ResultSet pesquisarPorNome(ServiceType servico) throws SQLException {
		return ServiceTypeDAO.getInstance().pesquisarPorNome(servico);
	}

}
