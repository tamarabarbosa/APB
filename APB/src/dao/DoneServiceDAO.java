package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DoneService;

public class DoneServiceDAO {

	private static DoneServiceDAO instance;

	private DoneServiceDAO() {

	}

	// this method check if existence of service
	public static DoneServiceDAO getInstance() {
		if (instance == null)
			instance = new DoneServiceDAO();
		return instance;
	}

	// this method include a new job done
	public boolean insert(DoneService servico) throws SQLException {
		if (servico != null) {
			this.updateQuery("INSERT INTO "
					+ "DoneService (nome, preco, barbeiro, data) VALUES ("
					+ "\"" + servico.getServiceName() + "\", " + "\""
					+ servico.getPrice() + "\", " + "\""
					+ servico.getBarberName() + "\", " + "\""
					+ servico.getDate() + "\"); ");
			return true;
		}

		return false;
	}

	// this method exclude a job done
	public boolean delete(DoneService servico) throws SQLException {
		if (servico != null) {
			this.updateQuery("DELETE FROM DoneService WHERE "
					+ "DoneService.idDoneService = \"" + pesquisar(servico)
					+ "\";");
			return true;
		}

		return false;
	}

	// this method realize a seach to job done
	private String pesquisar(DoneService servico) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM DoneService WHERE "
						+ "DoneService.nome = \"" + servico.getServiceName()
						+ "\" AND DoneService.preco = \"" + servico.getPrice()
						+ "\" AND DoneService.barbeiro = \""
						+ servico.getBarberName()
						+ "\" AND DoneService.data = \"" + servico.getDate()
						+ "\";");
		ResultSet rs = preparedStatement.executeQuery();
		rs.next();
		return rs.getString("idDoneService");
	}

	// this method update the query
	private void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

	// this method show the done services and registered
	public ResultSet mostrarServicosPrestadosCadastrados(DoneService servico)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		ResultSet rs = connection
				.createStatement()
				.executeQuery(
						"SELECT nome, preco, barbeiro, data FROM DoneService ORDER BY data;");

		return rs;
	}

}
