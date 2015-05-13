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

	// Stores the current instance of the class
	private static ReportDAO instance;

	// General class constructor
	private ReportDAO() {
	}

	/**
	 * @return The current instance if exists, or instantiate a new one if does
	 *         not and return it
	 */
	public static ReportDAO getInstance() {
		if (instance == null)
			instance = new ReportDAO();
		return instance;
	}

	/**
	 * Create a connection with DB
	 * 
	 * @return The connection established
	 * @throws SQLException
	 * @return - Return the connection with the database
	 */
	public ResultSet searchByData(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE data BETWEEN '"
						+ report.getInitialDate()
						+ "' AND '"
						+ report.getEndDate() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

	/**
	 * Method used to search barber services
	 * 
	 * @param barberName
	 *            - Contains the barber name
	 * @param initialDate
	 *            - Receives the initial date
	 * @param finalDate
	 *            - Receives the final date
	 * @throws SQLException
	 * @return - Return the ResultSet of the selection of the search by a
	 *         service
	 */
	public ResultSet searchByDataEBarber(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE data BETWEEN '"
						+ report.getInitialDate()
						+ "' AND '"
						+ report.getEndDate()
						+ "' AND barber = '"
						+ report.getBarber() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

	/**
	 * Method used to execute some action on DB
	 * 
	 * @param message
	 *            - SQL code of action to be executed
	 * @throws SQLException
	 */
	public ResultSet searchByDataEJob(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE data BETWEEN '"
						+ report.getInitialDate()
						+ "' AND '"
						+ report.getEndDate()
						+ "' AND name = '"
						+ report.getServiceType() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;

	}

	// this method search report by barber
	public ResultSet searchByBarber(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE barber = '"
						+ report.getBarber() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

	// this method search by barber and service
	public ResultSet searchByBarberEJob(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE barber = '"
						+ report.getBarber() + "' AND name = '"
						+ report.getServiceType() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

	// this method search by service
	public ResultSet searchByJob(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE name = '"
						+ report.getServiceType() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

	// this method search by date, barber and service
	public ResultSet searchByDataBarberEJob(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM jobprestado WHERE data BETWEEN '"
						+ report.getInitialDate()
						+ "' AND '"
						+ report.getEndDate()
						+ "' AND barber = '"
						+ report.getBarber()
						+ "' AND name = '"
						+ report.getServiceType() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
