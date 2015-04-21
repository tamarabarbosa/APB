package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ReceiptDAO;

;

public class ReceiptController {

	private static ReceiptController instance;

	public ReceiptController() {
	}

	// this check if the instance is there
	public static ReceiptController getInstance() {
		if (instance == null) {
			instance = new ReceiptController();
		} else {
			/* nothing to do. */
		}
		return instance;

	}

	// show results of search of barber service
	public ResultSet pesquisarServicosDoBarbeiro(String barber,
			String dataInicial, String dataFinal) throws SQLException {

		return ReceiptDAO.getInstance().pesquisarServicosDoBarbeiro(barber,
				dataInicial, dataFinal);

	}

}
