package tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import model.Report;

import org.junit.Before;
import org.junit.Test;

import exception.ReportException;

public class ReportTest {

	Report report;

	@Before
	public void setUp() throws ParseException {
		try {
			report = new Report();

			report.setBarber("Chico");
			report.setServiceType("barba");
			report.setInitialDate("01/01/2013");
			report.setEndDate("09/09/2013");

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ReportException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = NullPointerException.class)
	public void dataInicialNaoPodeSerSettadaNula() throws NullPointerException,
			ParseException {
		try {
			report.setDataInicial(null);
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = AssertionError.class)
	public void dataInicialNaoPodeSerSettadaEmBranco()
			throws NullPointerException, ParseException {
		try {
			report.setDataInicial("");
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = NullPointerException.class)
	public void dataFinalNaoPodeSerSettadaNula() throws NullPointerException,
			ParseException {
		try {
			report.setDataFinal(null);
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = AssertionError.class)
	public void dataFinalNaoPodeSerSettaEmBranco() throws NullPointerException,
			ParseException {
		try {
			report.setDataFinal("");
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = NullPointerException.class)
	public void barberNaoPodeSerSettadoNulo() {
		try {
			report.setBarber(null);
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = AssertionError.class)
	public void barberNaoPodeSerSettoEmBranco() {
		try {
			report.setBarber("");
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = NullPointerException.class)
	public void typeDeJobNaoPodeSerSettadoNulo() {
		try {
			report.setTipoJob(null);
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = AssertionError.class)
	public void typeDeJobNaoPodeSerSettoEmBranco() {
		try {
			report.setTipoJob("");
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void construtorDeRelatorioNaoPodePassarBarberNulo() {
		try {
			new Report("2013-01-01", "2013-01-01", null, "barba");
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void construtorDeRelatorioNaoPodePassarDataFinalNula() {
		try {
			new Report("2013-01-01", null, "Chico", "barba");
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void construtorDeRelatorioNaoPodePassarDataInicialNula() {
		try {
			new Report(null, "2013-01-01", "Chico", "barba");
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void construtorDeRelatorioNaoPodePassarTipoJobNulo() {
		try {
			new Report("2013-01-01", "2013-01-01", "Chico", null);
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void construtorDeRelatorioPassandoTodosOsDadosCorretos() {
		try {
			new Report("2013-01-01", "2013-12-31", "Chico", "barba");
			assertEquals(report, report);
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void metodoParaTestarGetterDeBarber() {
		assertEquals("Chico", report.getBarber());
	}

	@Test
	public void metodoParaTestarGetterDeTipoDeJob() {
		assertEquals("barba", report.getTipoJob());
	}

	@Test
	public void metodoParaTestarGetterDeDataInicial() {
		assertEquals("2013-01-01", report.getDataInicial());
	}

	@Test
	public void metodoParaTestarGetterDeDataFinal() {
		assertEquals("2013-09-09", report.getDataFinal());
	}

	@Test
	public void testeDataParaConverter() {
		try {
			report.ConverterDataParaABNT("2010-10-10");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
