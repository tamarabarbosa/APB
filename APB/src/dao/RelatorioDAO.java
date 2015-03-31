package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Relatorio;

public class RelatorioDAO {

	private static RelatorioDAO instance;

	private RelatorioDAO() {
	}
	//this method check if the report is there
	public static RelatorioDAO getInstance() {
		if (instance == null)
			instance = new RelatorioDAO();
		return instance;
	}
	//this method search by report by date in the database
	public ResultSet pesquisarPorData(Relatorio relatorio) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE data BETWEEN '"
						+ relatorio.getDataInicial()
						+ "' AND '"
						+ relatorio.getDataFinal() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by report date by barber in the database
	public ResultSet pesquisarPorDataEBarbeiro(Relatorio relatorio)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE data BETWEEN '"
						+ relatorio.getDataInicial()
						+ "' AND '"
						+ relatorio.getDataFinal()
						+ "' AND barbeiro = '"
						+ relatorio.getBarbeiro() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by service date by date in the database
	public ResultSet pesquisarPorDataEServico(Relatorio relatorio)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE data BETWEEN '"
						+ relatorio.getDataInicial()
						+ "' AND '"
						+ relatorio.getDataFinal()
						+ "' AND nome = '"
						+ relatorio.getTipoServico() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;

	}
	//this method search report by barber
	public ResultSet pesquisarPorBarbeiro(Relatorio relatorio)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE barbeiro = '"
						+ relatorio.getBarbeiro() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by barber and service 
	public ResultSet pesquisarPorBarbeiroEServico(Relatorio relatorio)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE barbeiro = '"
						+ relatorio.getBarbeiro()
						+ "' AND nome = '"
						+ relatorio.getTipoServico() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by service
	public ResultSet pesquisarPorServico(Relatorio relatorio)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE nome = '"
						+ relatorio.getTipoServico() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}
	//this method search by date, barber and service
	public ResultSet pesquisarPorDataBarbeiroEServico(Relatorio relatorio)
			throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement pst = connection
				.prepareStatement("SELECT * FROM servicoprestado WHERE data BETWEEN '"
						+ relatorio.getDataInicial()
						+ "' AND '"
						+ relatorio.getDataFinal()
						+ "' AND barbeiro = '"
						+ relatorio.getBarbeiro()
						+ "' AND nome = '"
						+ relatorio.getTipoServico() + "';");
		ResultSet rs = pst.executeQuery();

		return rs;
	}

}
