/*
 * Package: Controller
 * Class: DoneServiceController.java
 *
 * Description: This class is reponsible to make a registre of receipt
 * atributes and necessary methods to attribute them.
 */

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
	public ResultSet pesquisarJobsDoBarber(String barber,
			String dataInicial, String dataFinal) throws SQLException {

		return ReceiptDAO.getInstance().pesquisarJobsDoBarber(barber,
				dataInicial, dataFinal);

	}

}
