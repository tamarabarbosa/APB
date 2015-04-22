/*
 * Package: DAO
 * Class: ReportDAO.java
 *
 * Description: This class is reponsible make a connection to Receipt to database doing searches
 * atributes and necessary methods to attribute them.
 */

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
	public ResultSet searchByData(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE data BETWEEN '"
						+ report.getDataInicial()
						+ "' AND '"
						+ report.getDataFinal() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by report date by barber in the database
	public ResultSet searchByDataEBarber(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE data BETWEEN '"
						+ report.getDataInicial()
						+ "' AND '"
						+ report.getDataFinal()
						+ "' AND barber = '"
						+ report.getBarber() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by service date by date in the database
	public ResultSet searchByDataEJob(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE data BETWEEN '"
						+ report.getDataInicial()
						+ "' AND '"
						+ report.getDataFinal()
						+ "' AND name = '"
						+ report.getTipoJob() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;

	}
	//this method search report by barber
	public ResultSet searchByBarber(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE barber = '"
						+ report.getBarber() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by barber and service
	public ResultSet searchByBarberEJob(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE barber = '"
						+ report.getBarber()
						+ "' AND name = '"
						+ report.getTipoJob() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by service
	public ResultSet searchByJob(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE name = '"
						+ report.getTipoJob() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by date, barber and service
	public ResultSet searchByDataBarberEJob(Report report)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE data BETWEEN '"
						+ report.getDataInicial()
						+ "' AND '"
						+ report.getDataFinal()
						+ "' AND barber = '"
						+ report.getBarber()
						+ "' AND name = '"
						+ report.getTipoJob() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
