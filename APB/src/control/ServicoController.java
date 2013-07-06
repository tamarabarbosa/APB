package control;

import java.sql.SQLException;
import dao.ServicoDAO;
import model.Servico;



public class ServicoController {
	
private static ServicoController instance;
	
	public boolean inserir(Servico servico) throws SQLException {
		ServicoDAO.getInstance().incluir(servico);
		if(ServicoDAO.getInstance().incluir(servico) == true){
			return true;
		}else{
			return false;
		}
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
