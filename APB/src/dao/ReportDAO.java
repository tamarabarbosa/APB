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
		if (instance == null) {
			instance = new ReportDAO();
		} else {
			// Nothing to do because if 'instance' is not null, there is an
			// active instance
		}

		return instance;
	}

	/**
	 * Search for done services between two dates
	 * 
	 * @param report
	 *            - Report object that contains the dates to search between
	 * @return a ResultSet object with the done services found
	 * @throws SQLException
	 */
	public ResultSet searchByData(Report report) throws SQLException {
		String prepareStatementToMethod = "SELECT * FROM servicoprestado WHERE data BETWEEN '"
				+ report.getInitialDate()
				+ "' AND '"
				+ report.getEndDate()
				+ "';";

		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement(prepareStatementToMethod);
		ResultSet instanceStatement = pst.executeQuery();

		return instanceStatement;
	}

	/**
	 * Search for done services between two dates and by the barber whom did the
	 * service
	 * 
	 * @param report
	 *            - Report object that contains the dates to search between and
	 *            barber name
	 * @return a ResultSet object with the done services found
	 * @throws SQLException
	 */
	public ResultSet searchByDataEBarber(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();

		String prepareStatementMethod = "SELECT * FROM servicoprestado WHERE data BETWEEN '"
				+ report.getInitialDate()
				+ "' AND '"
				+ report.getEndDate()
				+ "' AND barbeiro = '" + report.getBarber() + "';";

		PreparedStatement pst = connection
				.prepareStatement(prepareStatementMethod);
		ResultSet instanceStatement = pst.executeQuery();

		return instanceStatement;
	}

	/**
	 * Search for done services between two dates and by the service type
	 * 
	 * @param report
	 *            - Report object that contains the dates to search between and
	 *            service type name
	 * @return a ResultSet object with the done services found
	 * @throws SQLException
	 */
	public ResultSet searchByDataEJob(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();

		String prepareStatementMethod = "SELECT * FROM servicoprestado WHERE data BETWEEN '"
				+ report.getInitialDate()
				+ "' AND '"
				+ report.getEndDate()
				+ "' AND nome = '" + report.getServiceType() + "';";

		PreparedStatement pst = connection
				.prepareStatement(prepareStatementMethod);
		ResultSet queryResult = pst.executeQuery();

		return queryResult;

	}

	/**
	 * Search for done services by the barber who did it
	 * 
	 * @param report
	 *            - Report object that contains the barber name to search for
	 * @return a ResultSet object with the done services found
	 * @throws SQLException
	 */
	public ResultSet searchByBarber(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();

		String prepareStatementMethod = "SELECT * FROM servicoprestado WHERE barbeiro = '"
				+ report.getBarber() + "';";

		PreparedStatement pst = connection
				.prepareStatement(prepareStatementMethod);
		ResultSet queryResult = pst.executeQuery();

		return queryResult;
	}

	/**
	 * Search for done services by the barber who did it and the service type
	 * 
	 * @param report
	 *            - Report object that contains the barber name and the service
	 *            type to search for
	 * @return a ResultSet object with the done services found
	 * @throws SQLException
	 */
	public ResultSet searchByBarberEJob(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();

		String prepareStatementMethod = "SELECT * FROM servicoprestado WHERE barbeiro = '"
				+ report.getBarber()
				+ "' AND nome = '"
				+ report.getServiceType() + "';";

		PreparedStatement pst = connection
				.prepareStatement(prepareStatementMethod);
		ResultSet queryResult = pst.executeQuery();

		return queryResult;
	}

	/**
	 * Search for done services by the service type
	 * 
	 * @param report
	 *            - Report object that contains the service type to search for
	 * @return a ResultSet object with the done services found
	 * @throws SQLException
	 */
	public ResultSet searchByJob(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();

		String prepareStatementMethod = "SELECT * FROM servicoprestado WHERE nome = '"
				+ report.getServiceType() + "';";

		PreparedStatement pst = connection
				.prepareStatement(prepareStatementMethod);
		ResultSet queryResult = pst.executeQuery();

		return queryResult;
	}

	/**
	 * Search for done services between two dates, by the service type and the
	 * barber who did it
	 * 
	 * @param report
	 *            - Report object that contains the service type to search for
	 * @return a ResultSet object with the done services found
	 * @throws SQLException
	 */
	public ResultSet searchByDataBarberEJob(Report report) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();

		String prepareStatementMethod = "SELECT * FROM servicoprestado WHERE data BETWEEN '"
				+ report.getInitialDate()
				+ "' AND '"
				+ report.getEndDate()
				+ "' AND barbeiro = '"
				+ report.getBarber()
				+ "' AND nome = '"
				+ report.getServiceType() + "';";

		PreparedStatement pst = connection
				.prepareStatement(prepareStatementMethod);

		ResultSet instanceStatement = pst.executeQuery();

		return instanceStatement;
	}

}
