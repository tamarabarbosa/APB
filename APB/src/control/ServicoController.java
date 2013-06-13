package control;

import java.sql.SQLException;
import dao.ServicoDAO;
import model.Servico;



public class ServicoController {
	
private static ServicoController instance;
	
	public void inserir(Servico servico) throws SQLException {
		ServicoDAO.getInstance().incluir(servico);
	}
	
	public void alterar(Servico servico) throws SQLException {
		Servico servico_alterado = servico;
		ServicoDAO.getInstance().alterar(servico_alterado, servico);
	}

	public void excluir(Servico servico) throws SQLException {
		ServicoDAO.getInstance().excluir(servico);
	}
	
	private ServicoController() {}
	
	public static ServicoController getInstance() {
		if(instance == null)
			instance = new ServicoController();
		return instance;
	}
	

}
