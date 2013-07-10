package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Relatorio;

public class RelatorioDAO {

	private static RelatorioDAO instance;
	
	private RelatorioDAO(){}

	public static RelatorioDAO getInstance() {
		if (instance == null)
			instance = new RelatorioDAO();
		return instance;
	}

	public void pesquisarPorData(Relatorio relatorio)
			throws SQLException {
		this.updateQuery("SELECT * FROM servicoprestado WHERE data BETWEEN '"
			+relatorio.getDataInicial()+"' AND '"+relatorio.getDataFinal()+"';");
	}
	public void pesquisarPorDataEBArbeiro(Relatorio relatorio)
			throws SQLException {
		this.updateQuery("SELECT * FROM servicoprestado WHERE data BETWEEN '"
			+relatorio.getDataInicial()+"' AND '"+relatorio.getDataFinal()+"' AND barbeiro = '"
			+relatorio.getBarbeiro()+"';");
	}
	public void pesquisarPorDataEServico(Relatorio relatorio)
			throws SQLException {
		this.updateQuery("SELECT * FROM servicoprestado WHERE data BETWEEN '"
				+relatorio.getDataInicial()+"' AND '"+relatorio.getDataFinal()+"' AND nome = '"
				+relatorio.getTipoServico()+"';");
	}
	public void pesquisarPorBArbeiro(Relatorio relatorio)
			throws SQLException {
		this.updateQuery("SELECT * FROM servicoprestado WHERE barbeiro = '"
			+relatorio.getBarbeiro()+"';");
	}
	public void pesquisarPorBArbeiroEServico(Relatorio relatorio)
			throws SQLException {
		this.updateQuery("SELECT * FROM servicoprestado WHERE barbeiro = '"
				+relatorio.getBarbeiro()+"' AND nome = '"+relatorio.getTipoServico()+"';");
	}
	public void pesquisarPorServico(Relatorio relatorio)
			throws SQLException {
		this.updateQuery("SELECT * FROM servicoprestado WHERE nome = '"
			+relatorio.getTipoServico()+"';");
	}
	public void pesquisarPorDataBarbeiroEServico(Relatorio relatorio)
			throws SQLException {
		this.updateQuery("SELECT * FROM servicoprestado WHERE data BETWEEN '"
			+relatorio.getDataInicial()+"' AND '"+relatorio.getDataFinal()+"' AND barbeiro = '"
			+relatorio.getBarbeiro()+"' AND servico = '"+relatorio.getTipoServico()+"';");
	}

	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

}
