/*
 * Package: Controller
 * Class: DoneServiceController.java
 *
 * Description: This class is reponsible to make a report of date, barber and job
 * atributes and necessary methods to attribute them.
 */

package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ReportDAO;
import model.Report;

public class ReportController {

	// Stores the current instance of the class
	private static ReportController instance;

	// General class constructor
	public ReportController() {
	}

	/**
	 * @return - Return the current instance if exists, or instantiate a new one
	 *         if does not and return it
	 */
	public ResultSet searchByData(Report report) throws SQLException {
		return ReportDAO.getInstance().searchByData(report);
	}

	/**
	 * Method that gives access to the barber services search
	 * 
	 * @param barberName
	 *            - Contains the barber name
	 * @param initialDate
	 *            - Contains the initial date
	 * @param finalDate
	 *            - Contains the final date
	 * @return - Return the ResultSet of the search
	 */
	public ResultSet searchByDataEBarber(Report report) throws SQLException {
		return ReportDAO.getInstance().searchByDataEBarber(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date and service
	public ResultSet searchByDataEJob(Report report) throws SQLException {
		return ReportDAO.getInstance().searchByDataEJob(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by barber
	public ResultSet searchByBarber(Report report) throws SQLException {
		return ReportDAO.getInstance().searchByBarber(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by barber and service
	public ResultSet searchByBarberEJob(Report report) throws SQLException {
		return ReportDAO.getInstance().searchByBarberEJob(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by service
	public ResultSet searchByJob(Report report) throws SQLException {
		return ReportDAO.getInstance().searchByJob(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date, barber and service
	public ResultSet searchByDataBarberEJob(Report report) throws SQLException {
		return ReportDAO.getInstance().searchByDataBarberEJob(report);
	}

	public static ReportController getInstance() {
		if (instance == null) {
			instance = new ReportController();
		} else {
			/* nothing to do. */
		}
		return instance;
	}

}
