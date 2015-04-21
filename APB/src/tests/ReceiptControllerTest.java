package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.Report;

import org.junit.Before;
import org.junit.Test;

import control.ReciboController;
import exception.ReciboException;
import exception.RelatorioException;

public class ReceiptControllerTest {

	Report report = new Report();

	@Before
	public void setUp() throws ReciboException, ParseException {

				try {
					report.setBarber("Fulano");
					report.setDataFinal("09/09/2013");
					report.setDataInicial("01/01/2013");

				} catch (RelatorioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

	@Test
	public void getInstanceDeReciboDAODeveRetonarInstanciaCorrente() {
		ReciboController reciboController = ReciboController.getInstance();
		assertEquals(ReciboController.getInstance(), reciboController);
	}

	@Test
	public void procurarPorDataEBarberDeReciboControllerDeveMostrarUmRecibo() throws SQLException {
		ReciboController reciboController = new ReciboController();
		ResultSet rs = reciboController.pesquisarJobsDoBarber(report.getBarber(), report.getDataInicial(), report.getDataFinal());

		while(rs.next());
	}

}
