package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BarberDAO;
import model.Barber;

public class BarberController {

	private static BarberController instance;

	private BarberController() {
	}
	//this check if the instance is there
	public static BarberController getInstance() {
		if (instance == null) {
			instance = new BarberController();
			return instance;
		} 
		else {
			return instance;
		}
	}
	//this method include barber
	public boolean inserir(Barber barber) throws SQLException {
		if (barber == null) {
			return false;
		} else {
			BarberDAO.getInstance().incluir(barber);
			return true;
		}
	}
	//this method change data of barber
	public boolean alterar(String nome, Barber barber) throws SQLException {
		if (barber == null) {
			return false;
		} else {
			Barber barber_alterado = barber;
			BarberDAO.getInstance()
					.alterar(nome, barber_alterado, barber);
			return true;
		}
	}
	//this method exclude barber
	public boolean excluir(Barber barber) throws SQLException {
		if (barber == null) {
			return false;
		} else {
			BarberDAO.getInstance().excluir(barber);
			return true;
		}
	}
	//this show results of search
	public ResultSet pesquisar() throws SQLException {
		return BarberDAO.getInstance().pesquisar();
	}
	//this show results of barber registred
	public ResultSet showRegisteredBarbers(Barber barber)
			throws SQLException {
		return BarberDAO.getInstance().showRegisteredBarbers(barber);
	}
	//this show results of seach barber by name
	public ResultSet pesquisarPorNome(Barber barber) throws SQLException {
		return BarberDAO.getInstance().pesquisarPorNome(barber);
	}

}
