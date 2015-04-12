package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.RelatorioDAO;
import model.Relatorio;

public class ReportController {

	private static ReportController instance;

	public ReportController() {
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date
	public ResultSet pesquisarPorData(Relatorio relatorio) throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorData(relatorio);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date and barber
	public ResultSet pesquisarPorDataEBarbeiro(Relatorio relatorio)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorDataEBarbeiro(relatorio);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date and service
	public ResultSet pesquisarPorDataEServico(Relatorio relatorio)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorDataEServico(relatorio);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by barber
	public ResultSet pesquisarPorBarbeiro(Relatorio relatorio)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorBarbeiro(relatorio);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by barber and service
	public ResultSet pesquisarPorBarbeiroEServico(Relatorio relatorio)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorBarbeiroEServico(
				relatorio);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by service
	public ResultSet pesquisarPorServico(Relatorio relatorio)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorServico(relatorio);
	}

	// Method that gives access to the registered reports and also gives the
	// option to search it by date, barber and service
	public ResultSet pesquisarPorDataBarbeiroEServico(Relatorio relatorio)
			throws SQLException {
		return RelatorioDAO.getInstance().pesquisarPorDataBarbeiroEServico(
				relatorio);
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
