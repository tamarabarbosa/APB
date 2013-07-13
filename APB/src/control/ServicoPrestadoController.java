package control;

import java.sql.SQLException;
import dao.ServicoPrestadoDAO;
import model.ServicoPrestado;

public class ServicoPrestadoController {

	public static ServicoPrestadoController getInstance() {
		if (instance == null)
			instance = new ServicoPrestadoController();
		return instance;
	}

	private static ServicoPrestadoController instance;

	public boolean inserir(ServicoPrestado servico) throws SQLException {
		if (ServicoPrestadoDAO.getInstance().incluir(servico))
			return true;

		return false;
	}

	public void excluir(ServicoPrestado servico) throws SQLException {
		ServicoPrestadoDAO.getInstance().excluir(servico);
	}

	private ServicoPrestadoController() {
	}
}
