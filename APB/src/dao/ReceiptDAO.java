package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptDAO {

	private static ReceiptDAO instance;

	private ReceiptDAO(){}

	public static ReceiptDAO getInstance(){
		if(instance == null)
			instance = new ReceiptDAO();
		return instance;
	}
	//this method search on the schedule works done by the barber
	public ResultSet pesquisarJobsDoBarber(String barber, String dataInicial, String dataFinal) throws SQLException{

		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection.prepareStatement("SELECT * FROM jobprestado WHERE data BETWEEN '"
				+dataInicial+"' AND '"+ dataFinal+"' AND barber = '"
				+barber+"';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method is responsible by connection
	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

}
