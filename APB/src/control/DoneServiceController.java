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
	public boolean insert(DoneService job) throws SQLException {
		if (job != null) {
			DoneServiceDAO.getInstance().insert(job);
			return true;
		} else {
			return false;
		}
	}

	// Method used to delete a service
	public boolean delete(DoneService job) throws SQLException {
		if (job != null) {
			DoneServiceDAO.getInstance().delete(job);
			return true;
		} else {
			return false;
		}
	}

	// Method that gives access to the registered services
	public ResultSet mostrarJobsPrestadosCadastrados(DoneService job)
			throws SQLException {
		return DoneServiceDAO.getInstance()
				.mostrarJobsPrestadosCadastrados(job);
	}

}
