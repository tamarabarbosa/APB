package testes;

import static org.junit.Assert.*;

import java.text.ParseException;

import model.Report;

import org.junit.Before;
import org.junit.Test;

import exception.RelatorioException;

public class RelatorioTeste {

	Report report;

	@Before
	public void setUp() throws ParseException {
		try {
			report = new Report();

			report.setBarbeiro("Chico");
			report.setTipoServico("barba");
			report.setDataInicial("01/01/2013");
			report.setDataFinal("09/09/2013");

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = NullPointerException.class)
	public void dataInicialNaoPodeSerSettadaNula() throws NullPointerException, ParseException {
		try {
			report.setDataInicial(null);
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = AssertionError.class)
	public void dataInicialNaoPodeSerSettadaEmBranco() throws NullPointerException, ParseException {
		try {
			report.setDataInicial("");
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = NullPointerException.class)
	public void dataFinalNaoPodeSerSettadaNula() throws NullPointerException, ParseException {
		try {
			report.setDataFinal(null);
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = AssertionError.class)
	public void dataFinalNaoPodeSerSettaEmBranco() throws NullPointerException, ParseException {
		try {
			report.setDataFinal("");
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = NullPointerException.class)
	public void barbeiroNaoPodeSerSettadoNulo() {
		try {
			report.setBarbeiro(null);
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = AssertionError.class)
	public void barbeiroNaoPodeSerSettoEmBranco() {
		try {
			report.setBarbeiro("");
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = NullPointerException.class)
	public void tipoDeServicoNaoPodeSerSettadoNulo() {
		try {
			report.setTipoServico(null);
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = AssertionError.class)
	public void tipoDeServicoNaoPodeSerSettoEmBranco() {
		try {
			report.setTipoServico("");
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void construtorDeRelatorioNaoPodePassarBarbeiroNulo() {
		try {
			new Report ("2013-01-01", "2013-01-01", null, "barba");
		} catch(RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void construtorDeRelatorioNaoPodePassarDataFinalNula() {
		try {
			new Report("2013-01-01", null, "Chico", "barba");
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void construtorDeRelatorioNaoPodePassarDataInicialNula() {
		try {
			new Report (null, "2013-01-01", "Chico", "barba");
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void construtorDeRelatorioNaoPodePassarTipoServicoNulo() {
		try {
			new Report ("2013-01-01", "2013-01-01", "Chico", null);
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test 
	public void construtorDeRelatorioPassandoTodosOsDadosCorretos() {
		try {
			new Report ("2013-01-01", "2013-12-31", "Chico", "barba");
			assertEquals(report, report);
		} catch (RelatorioException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void metodoParaTestarGetterDeBarbeiro() {
		assertEquals("Chico", report.getBarbeiro());
	}
	
	@Test
	public void metodoParaTestarGetterDeTipoDeServico() {
		assertEquals("barba", report.getTipoServico());
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
