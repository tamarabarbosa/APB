/*
 * Package: Controller
 * Class: BarberController.java
 *
 * Description: This class is reponsible to do a CRUD
 * atributes and necessary methods to attribute them.
 */

package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BarberDAO;
import model.Barber;

public class BarberController {

	private static BarberController instance;

	private BarberController() {
	}

	// this check if the instance is there
	public static BarberController getInstance() {
		if (instance == null) {
			instance = new BarberController();
			return instance;
		} else {
			return instance;
		}
	}

	// this method include barber
	public boolean insert(Barber barber) throws SQLException {
		if (barber == null) {
			return false;
		} else {
			BarberDAO.getInstance().insert(barber);
			return true;
		}
	}

	// this method change data of barber
	public boolean alterar(String name, Barber barber) throws SQLException {
		if (barber == null) {
			return false;
		} else {
			Barber barber_change = barber;
			BarberDAO.getInstance().alterar(name, barber_change, barber);
			return true;
		}
	}

	// this method exclude barber
	public boolean delete(Barber barber) throws SQLException {
		if (barber == null) {
			return false;
		} else {
			BarberDAO.getInstance().delete(barber);
			return true;
		}
	}

	// this show results of search
	public ResultSet search() throws SQLException {
		return BarberDAO.getInstance().search();
	}

	// this show results of barber registred
	public ResultSet showRegisteredBarbers(Barber barber) throws SQLException {
		return BarberDAO.getInstance().showRegisteredBarbers(barber);
	}

	// this show results of seach barber by name
	public ResultSet searchPorNome(Barber barber) throws SQLException {
		return BarberDAO.getInstance().searchByName(barber);
	}

}
