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

	private static ReportController instance;

	public ReportController() {
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date
	public ResultSet pesquisarPorData(Report report) throws SQLException {
		return ReportDAO.getInstance().pesquisarPorData(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date and barber
	public ResultSet pesquisarPorDataEBarber(Report report)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorDataEBarber(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date and service
	public ResultSet pesquisarPorDataEJob(Report report)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorDataEJob(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by barber
	public ResultSet pesquisarPorBarber(Report report) throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorBarber(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by barber and service
	public ResultSet pesquisarPorBarberEJob(Report report)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorBarberEJob(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by service
	public ResultSet pesquisarPorJob(Report report) throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorJob(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date, barber and service
	public ResultSet pesquisarPorDataBarberEJob(Report report)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorDataBarberEJob(
				report);
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
