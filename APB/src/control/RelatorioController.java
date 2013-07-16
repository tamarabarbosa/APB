package control;

import java.sql.ResultSet;
import java.sql.SQLException;


import dao.RelatorioDAO;
import model.Relatorio;

public class RelatorioController {
	
private static RelatorioController instance;

	public RelatorioController() {}
	
	public ResultSet pesquisarPorData(Relatorio relatorio) throws SQLException {
		
		return RelatorioDAO.getInstance().pesquisarPorData(relatorio);
	}
	public ResultSet pesquisarPorDataEBarbeiro(Relatorio relatorio) throws SQLException {
		
		return RelatorioDAO.getInstance().pesquisarPorDataEBArbeiro(relatorio);
	}
	public ResultSet pesquisarPorDataEServico(Relatorio relatorio) throws SQLException {
		
		return RelatorioDAO.getInstance().pesquisarPorDataEServico(relatorio);
	}
	public ResultSet pesquisarPorBarbeiro(Relatorio relatorio) throws SQLException {
		
		return RelatorioDAO.getInstance().pesquisarPorBArbeiro(relatorio);
	}
	public ResultSet pesquisarPorBarbeiroEServico(Relatorio relatorio) throws SQLException {
		
		return RelatorioDAO.getInstance().pesquisarPorBArbeiroEServico(relatorio);
	}
	public ResultSet pesquisarPorServico(Relatorio relatorio) throws SQLException {
		
		return RelatorioDAO.getInstance().pesquisarPorServico(relatorio);
	}
	public ResultSet pesquisarPorDataBarbeiroEServico(Relatorio relatorio) throws SQLException {	
		
		return RelatorioDAO.getInstance().pesquisarPorDataBarbeiroEServico(relatorio);
	}
	
	public static RelatorioController getInstance() {
		if(instance == null)
			instance = new RelatorioController();
		return instance;
	}

}
