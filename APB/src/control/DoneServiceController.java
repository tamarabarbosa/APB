/*
 * Package: Controller
 * Class: DoneServiceController.java
 *
 * Description: This class is reponsible to do a CRUD of services done
 * atributes and necessary methods to attribute them.
 */

package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DoneServiceDAO;
import model.DoneService;

public class DoneServiceController {

	// General class constructor
	private DoneServiceController() {
	}

	/**
	 * @return - Return the current instance if exists, or instantiate a new one
	 *         if does not and return it
	 */
	public static DoneServiceController getInstance() {
		// "DoneServiceController" class instance
		if (instance == null) {
			instance = new DoneServiceController();
		} else {
			// Nothing to do - because the condition "if" is just used to check
			// the initial value of the variable
		}

		return instance;

	}

	// Stores the current instance of the class
	private static DoneServiceController instance;

	/**
	 * Method used to insert a service
	 * 
	 * @param providedService
	 *            - Contains the provided service
	 * @return - Return the status of the insertion
	 */
	public boolean insert(DoneService providedService) throws SQLException {
		boolean providedServiceInserted;

		if (providedService != null) {
			DoneServiceDAO.getInstance().insert(providedService);

			providedServiceInserted = true;
		} else {
			providedServiceInserted = false;
		}

		return providedServiceInserted;
	}

	/**
	 * Method used to delete a service
	 * 
	 * @param providedService
	 *            - Contains the provided service
	 * @return - Return the status of the exclusion
	 */
	public boolean delete(DoneService providedService) throws SQLException {
		boolean providedServiceDeleted;

		if (providedService != null) {
			DoneServiceDAO.getInstance().delete(providedService);

			providedServiceDeleted = true;
		} else {
			providedServiceDeleted = false;
		}

		return providedServiceDeleted;
	}

	/**
	 * Method that gives access to the registered services
	 * 
	 * @param providedService
	 *            - Contains the provided service
	 * @return - Return the ResultSet of the Show Done Service Registered
	 */
	public ResultSet mostrarJobsPrestadosCadastrados(DoneService providedService)
			throws SQLException {
		DoneServiceDAO doneServiceDAOInstance = DoneServiceDAO.getInstance();
		ResultSet showRegistredDoneServicesResult = doneServiceDAOInstance
				.showRegistredDoneServices(providedService);

		return showRegistredDoneServicesResult;
	}

}
