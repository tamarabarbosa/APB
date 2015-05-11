/*
 * Package: Controller
 * Class: BarberController.java
 *
 * Description: This class is reponsible to do a CRUD
 * atributes and necessary methods to attribute them.
 */

package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BarberDAO;
import model.Barber;

public class BarberController {

	// Stores the current instance of the class
	private static BarberController instance;

	// Class constructor
	private BarberController() {
	}

	// this check if the instance is there
	public static BarberController getInstance() {
		if (instance == null) {
			instance = new BarberController();
			return instance;
		} else {
			return instance;
		}
	}

	// this method include barber
	public boolean insert(Barber barber) throws SQLException {
		if (barber == null) {
			return false;
		} else {
			BarberDAO.getInstance().includeBarber(barber);
			return true;
		}
	}

	/**
	 * Method that includes a new barber on DB
	 * 
	 * @param barberToInclude
	 *            - Barber to be included on DB
	 */
	public boolean includeBarber(Barber barberToInclude) throws SQLException {
		boolean returnMethodIncludeBarber;
		if (barberToInclude == null) {
			returnMethodIncludeBarber = false;
		} else {
			returnMethodIncludeBarber = true;
		}

		BarberDAO barberDAOInstance = BarberDAO.getInstance();

		barberDAOInstance.includeBarber(barberToInclude);

		return returnMethodIncludeBarber;
	}

	// this method exclude barber
	public boolean delete(Barber barber) throws SQLException {
		if (barber == null) {
			return false;
		} else {
			BarberDAO.getInstance().deleteBarber(barber);
			return true;
		}
	}

	/**
	 * Method that modify a barber registered on DB
	 * 
	 * @param barberToChangeName
	 *            - String that contains the barber name that will be replaced
	 * @param newBarber
	 *            - Barber that will replace the old one (where
	 *            'barberToChangeName' on DB)
	 */
	public boolean modifyBarber(String barberToChangeName, Barber newBarber)
			throws SQLException {
		boolean returnMethodModifyBarber;
		if (newBarber == null) {
			returnMethodModifyBarber = false;
		} else {
			returnMethodModifyBarber = true;
		}

		// Check use - Probably can be deleted
		Barber changedBarber = newBarber;

		BarberDAO barberDAOInstance = BarberDAO.getInstance();

		barberDAOInstance.changeBarber(barberToChangeName, changedBarber,
				newBarber);

		return returnMethodModifyBarber;
	}

	/**
	 * Method that delete a barber registered on DB
	 * 
	 * @param barberToDelete
	 *            - Barber to be deleted
	 * @return true if the barber to delete exists
	 */
	public boolean deleteBarber(Barber barberToDelete) throws SQLException {
		boolean returnMethodDeleteBarber;
		if (barberToDelete == null) {
			returnMethodDeleteBarber = false;
		} else {
			returnMethodDeleteBarber = true;
		}

		BarberDAO barberDAOInstance = BarberDAO.getInstance();

		barberDAOInstance.deleteBarber(barberToDelete);

		return returnMethodDeleteBarber;
	}

	/**
	 * Method that return all barber table (on BarberDAO) - Check the need of
	 * this method
	 * 
	 * @param ResultSet
	 *            - Return the barber searched
	 */
	public ResultSet searchBarbers() throws SQLException {
		BarberDAO barberDAOInstance = BarberDAO.getInstance();

		ResultSet searchBarberResult = barberDAOInstance.search();

		return searchBarberResult;
	}

	/**
	 * Method that return all registered barbers on DB
	 * 
	 * @param barber
	 *            - Check the need of this parameter. Never used, should be
	 *            deleted.
	 */
	public ResultSet showRegisteredBarbers(Barber barber) throws SQLException {

		BarberDAO barberDAOInstance = BarberDAO.getInstance();

		ResultSet showRegisteredBarberResult = barberDAOInstance
				.showRegisteredBarber(barber);

		return showRegisteredBarberResult;
	}

	/**
	 * Method that search for a specific barber on DB
	 * 
	 * @param barberToSearchFor
	 *            - Barber to search for on DB
	 */
	public ResultSet searchBarberByName(Barber barberToSearchFor)
			throws SQLException {

		BarberDAO barberDAOInstance = BarberDAO.getInstance();

		ResultSet searchByNameResult = barberDAOInstance
				.searchByName(barberToSearchFor);

		return searchByNameResult;
	}

}
