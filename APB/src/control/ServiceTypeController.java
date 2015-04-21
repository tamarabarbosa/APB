package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ServiceTypeDAO;
import model.ServiceType;

public class ServiceTypeController {

	// Stores the current instance of the class
	private static ServiceTypeController instance;

	// Method that modify a service type on the system
	public boolean insert(ServiceType tipoJob) throws SQLException {
		if (tipoJob == null) {
			return false;
		} else {
			ServiceTypeDAO.getInstance().insert(tipoJob);
			return true;
		}
	}

	// Method that change a service type on the system
	public boolean change(String name, ServiceType tipoJob)
			throws SQLException {
		if (tipoJob == null) {
			return false;
		} else {
			ServiceType tipoJob_alterado = tipoJob;
			ServiceTypeDAO.getInstance().change(name, tipoJob_alterado,
					tipoJob);
			return true;
		}
	}

	// Method that delete a service type on the system
	public boolean delete(ServiceType tipoJob) throws SQLException {

		if (tipoJob == null) {
			return false;
		} else {
			ServiceTypeDAO.getInstance().delete(tipoJob);
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
	public ResultSet mostrarTipoJobCadastrados(ServiceType job)
			throws SQLException {
		return ServiceTypeDAO.getInstance().mostrarTipoJobCadastrados(
				job);
	}

	// Search for an specific service type name
	public static ResultSet pesquisarPorNome(ServiceType job) throws SQLException {
		return ServiceTypeDAO.getInstance().pesquisarPorNome(job);
	}

}
