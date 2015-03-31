package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ReciboDAO;

public class ReciboController {

	private static ReciboController instance;

	public ReciboController() {
	}
	//this check if the instance is there
	public static ReciboController getInstance() {
		if (instance == null) {
			instance = new ReciboController();
		} 
		else {
			/* nothing to do. */
		}
		return instance;

	}
	//show results of search of barber service
	public ResultSet pesquisarServicosDoBarbeiro(String barbeiro,
			String dataInicial, String dataFinal) throws SQLException {

		return ReciboDAO.getInstance().pesquisarServicosDoBarbeiro(barbeiro,
				dataInicial, dataFinal);

	}

}
