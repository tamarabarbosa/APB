package control;

import java.sql.SQLException;


import dao.RelatorioDAO;
import model.Relatorio;

public class RelatorioController {
	
private static RelatorioController instance;

	private RelatorioController() {}
	
	public boolean pesquisarPorData(Relatorio relatorio) throws SQLException {
		if (relatorio == null) {
			return false;
		} else {
			RelatorioDAO.getInstance().pesquisarPorData(relatorio);
			return true;
		}
	}
	public boolean pesquisarPorDataEBarbeiro(Relatorio relatorio) throws SQLException {
		if (relatorio == null) {
			return false;
		} else {
			RelatorioDAO.getInstance().pesquisarPorDataEBArbeiro(relatorio);
			return true;
		}
	}
	public boolean pesquisarPorDataEServico(Relatorio relatorio) throws SQLException {
		if (relatorio == null) {
			return false;
		} else {
			RelatorioDAO.getInstance().pesquisarPorDataEServico(relatorio);
			return true;
		}
	}
	public boolean pesquisarPorBarbeiro(Relatorio relatorio) throws SQLException {
		if (relatorio == null) {
			return false;
		} else {
			RelatorioDAO.getInstance().pesquisarPorBArbeiro(relatorio);
			return true;
		}
	}
	public boolean pesquisarPorBarbeiroEServico(Relatorio relatorio) throws SQLException {
		if (relatorio == null) {
			return false;
		} else {
			RelatorioDAO.getInstance().pesquisarPorBArbeiroEServico(relatorio);
			return true;
		}
	}
	public boolean pesquisarPorServico(Relatorio relatorio) throws SQLException {
		if (relatorio == null) {
			return false;
		} else {
			RelatorioDAO.getInstance().pesquisarPorServico(relatorio);
			return true;
		}
	}
	public boolean pesquisarPorDataBarbeiroEServico(Relatorio relatorio) throws SQLException {
		if (relatorio == null) {
			return false;
		} else {
			RelatorioDAO.getInstance().pesquisarPorDataBarbeiroEServico(relatorio);
			return true;
		}
	}
	
	public static RelatorioController getInstance() {
		if(instance == null)
			instance = new RelatorioController();
		return instance;
	}

}
