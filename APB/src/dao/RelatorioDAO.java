package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RelatorioDAO {
	
	private static RelatorioDAO instance;
	
	public static RelatorioDAO getInstance(){
		if(instance == null)
			instance = new RelatorioDAO();
		return instance;
}
	
	
	public void updateQuery(String message) throws SQLException{
		Connection connection =  FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(message);
		preparedStatement.executeUpdate();		
		preparedStatement.close();
		connection.close();
	}
	

}
