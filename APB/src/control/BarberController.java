package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BarbeiroDAO;
import model.Barbeiro;

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
	public boolean inserir(Barbeiro barbeiro) throws SQLException {
		if (barbeiro == null) {
			return false;
		} else {
			BarbeiroDAO.getInstance().incluir(barbeiro);
			return true;
		}
	}
	//this method change data of barber
	public boolean alterar(String nome, Barbeiro barbeiro) throws SQLException {
		if (barbeiro == null) {
			return false;
		} else {
			Barbeiro barbeiro_alterado = barbeiro;
			BarbeiroDAO.getInstance()
					.alterar(nome, barbeiro_alterado, barbeiro);
			return true;
		}
	}
	//this method exclude barber
	public boolean excluir(Barbeiro barbeiro) throws SQLException {
		if (barbeiro == null) {
			return false;
		} else {
			BarbeiroDAO.getInstance().excluir(barbeiro);
			return true;
		}
	}
	//this show results of search
	public ResultSet pesquisar() throws SQLException {
		return BarbeiroDAO.getInstance().pesquisar();
	}
	//this show results of barber registred
	public ResultSet mostrarBarbeirosCadastrados(Barbeiro barbeiro)
			throws SQLException {
		return BarbeiroDAO.getInstance().mostrarBarbeirosCadastrados(barbeiro);
	}
	//this show results of seach barber by name
	public ResultSet pesquisarPorNome(Barbeiro barbeiro) throws SQLException {
		return BarbeiroDAO.getInstance().pesquisarPorNome(barbeiro);
	}

}
