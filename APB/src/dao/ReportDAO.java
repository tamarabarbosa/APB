package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Report;

public class ReportDAO {

	private static ReportDAO instance;

	private ReportDAO() {
	}
	//this method check if the report is there
	public static ReportDAO getInstance() {
		if (instance == null)
			instance = new ReportDAO();
		return instance;
	}
	//this method search by report by date in the database
	public ResultSet pesquisarPorData(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE data BETWEEN '"
						+ report.getDataInicial()
						+ "' AND '"
						+ report.getDataFinal() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by report date by barber in the database
	public ResultSet pesquisarPorDataEBarbeiro(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE data BETWEEN '"
						+ report.getDataInicial()
						+ "' AND '"
						+ report.getDataFinal()
						+ "' AND barber = '"
						+ report.getBarbeiro() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by service date by date in the database
	public ResultSet pesquisarPorDataEServico(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE data BETWEEN '"
						+ report.getDataInicial()
						+ "' AND '"
						+ report.getDataFinal()
						+ "' AND name = '"
						+ report.getTipoServico() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;

	}
	//this method search report by barber
	public ResultSet pesquisarPorBarbeiro(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE barber = '"
						+ report.getBarbeiro() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by barber and service
	public ResultSet pesquisarPorBarbeiroEServico(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE barber = '"
						+ report.getBarbeiro()
						+ "' AND name = '"
						+ report.getTipoServico() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by service
	public ResultSet pesquisarPorServico(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE name = '"
						+ report.getTipoServico() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by date, barber and service
	public ResultSet pesquisarPorDataBarbeiroEServico(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE data BETWEEN '"
						+ report.getDataInicial()
						+ "' AND '"
						+ report.getDataFinal()
						+ "' AND barber = '"
						+ report.getBarbeiro()
						+ "' AND name = '"
						+ report.getTipoServico() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
