package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.RelatorioDAO;
import model.Report;

public class ReportController {

	private static ReportController instance;

	public ReportController() {
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date
	public ResultSet pesquisarPorData(Report report) throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorData(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date and barber
	public ResultSet pesquisarPorDataEBarbeiro(Report report)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorDataEBarbeiro(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date and service
	public ResultSet pesquisarPorDataEServico(Report report)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorDataEServico(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by barber
	public ResultSet pesquisarPorBarbeiro(Report report)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorBarbeiro(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by barber and service
	public ResultSet pesquisarPorBarbeiroEServico(Report report)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorBarbeiroEServico(
				report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by service
	public ResultSet pesquisarPorServico(Report report)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorServico(report);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date, barber and service
	public ResultSet pesquisarPorDataBarbeiroEServico(Report report)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorDataBarbeiroEServico(
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
