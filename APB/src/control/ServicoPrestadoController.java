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
		if (servico ==  null){
			return false;
		}else{
			ServicoPrestadoDAO.getInstance().incluir(servico);
			return true;

		}
	}

	public boolean excluir(ServicoPrestado servico) throws SQLException {
		if (servico ==  null){
			return false;
		}else{
			ServicoPrestadoDAO.getInstance().excluir(servico);
			return true;

		}
	}

	private ServicoPrestadoController() {
	}
}
