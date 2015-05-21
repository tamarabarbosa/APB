package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.Report;

import org.junit.Before;
import org.junit.Test;

import control.ReceiptController;
import exception.ReceiptException;
import exception.ReportException;

public class ReceiptControllerTest {

	Report report = new Report();

	@Before
	public void setUp() throws ReceiptException, ParseException {

		try {
			report.setBarber("Fulano");
			report.setEndDate("09/09/2013");
			;
			report.setInitialDate("01/01/2013");

		} catch (ReportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void getInstanceDeReciboDAODeveRetonarInstanciaCorrente() {
		ReceiptController reciboController = ReceiptController.getInstance();
		assertEquals(ReceiptController.getInstance(), reciboController);
	}

	@Test
	public void procurarPorDataEBarberDeReciboControllerDeveMostrarUmRecibo()
			throws SQLException {
		ReceiptController reciboController = new ReceiptController();
		ResultSet rs = reciboController.barberServicesSearch(
				report.getBarber(), report.getInitialDate(),
				report.getEndDate());

		while (rs.next())
			;
	}

}
