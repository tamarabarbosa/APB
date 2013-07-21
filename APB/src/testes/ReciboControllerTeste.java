package testes;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import control.ReciboController;
import exception.ReciboException;

public class ReciboControllerTeste {
	
	/*@Before
	public void setUp() throws ReciboException, ParseException {
		try {
			recibo.setBarbeiro("Fulano");
			recibo.setDataFinal("09/09/2013");
			recibo.setDataInicial("01/01/2013");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void getInstanceDeReciboDAODeveRetonarInstanciaCorrente() {
		ReciboController reciboController = ReciboController.getInstance();
		assertEquals(ReciboController.getInstance(), reciboController);
	}
	
	@Test
	public void procurarPorDataEBarbeiroDeReciboControllerDeveMostrarUmRecibo() throws SQLException {
		ReciboController reciboController = new ReciboController();
		ResultSet rs = reciboController.pesquisarPorDataEBarbeiro(recibo);
		
		while(rs.next());
	}*/

}
