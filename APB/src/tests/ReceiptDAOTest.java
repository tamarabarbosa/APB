package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.Report;

import org.junit.Before;
import org.junit.Test;

import dao.PhonebookDAO;
import dao.ReceiptDAO;
import exception.ReceiptException;
import exception.ReceiptException;

public class ReceiptDAOTest {

	Report report = new Report();

	@Before
	public void setUp() throws ReceiptException, ParseException {
		try {
			report.setBarber("Fulano");
			report.setInitialDate("09/09/2013");
			report.setEndDate("01/01/2013");

		} catch (ReceiptException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getInstanceDeReciboDAODeveRetonarInstanciaCorrente() {
		ReceiptDAO reciboDAO = ReceiptDAO.getInstance();
		assertEquals(ReceiptDAO.getInstance(), reciboDAO);
	}

	@Test
	public void searchByDataEBArbeiroDAODeveMostrarUmRecibo() {
		try {
			ReceiptDAO reciboDAO = ReceiptDAO.getInstance();
			ResultSet rs = reciboDAO.barberServicesSearch(report.getBarber(),
					report.getInitialDate(), report.getEndDate());

			while (rs.next()) {
				String name = rs.getString("name");
				assertEquals("Corte", name);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
