package testes;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import model.Report;

import org.junit.Before;
import org.junit.Test;

import dao.AgendaDAO;
import dao.ReciboDAO;
import exception.ReciboException;
import exception.RelatorioException;

public class ReceiptDAOTest {

	Report report = new Report();

	@Before
	public void setUp() throws ReciboException, ParseException {
		try {
			report.setBarbeiro("Fulano");
			report.setDataFinal("09/09/2013");
			report.setDataInicial("01/01/2013");

		} catch (RelatorioException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void getInstanceDeReciboDAODeveRetonarInstanciaCorrente() {
		ReciboDAO reciboDAO = ReciboDAO.getInstance();
		assertEquals(ReciboDAO.getInstance(), reciboDAO);
	}

	@Test
	public void pesquisarPorDataEBArbeiroDAODeveMostrarUmRecibo() {
		try {
			ReciboDAO reciboDAO = ReciboDAO.getInstance();
			ResultSet rs = reciboDAO.pesquisarServicosDoBarbeiro(
					report.getBarbeiro(), report.getDataInicial(),
					report.getDataFinal());

			while (rs.next()) {
				String nome = rs.getString("nome");
				assertEquals("Corte", nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}

}
