/* This class is responsible to create a report of the barbers*/
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import exception.ReceiptException;
import exception.ReceiptException;

public class Receipt {

	private String dataInicial;
	private String dataFinal;
	private String barbeiro;
	private String tipoServico;

	private final String DATA_FINAL_BRANCO = "Data final em Branco";
	private final String DATA_INICIAL_BRANCO = "Data inicial em Branco";
	private final String BARBEIRO_BRANCO = "Barbeiro em Branco";
	private final String TIPO_SERVICO_BRANCO = "Tipo do Serviço em Branco";

	public Receipt(String dataInicial, String dataFinal, String barbeiro,
			String tipoServico) throws ReceiptException {
		// super();
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.barbeiro = barbeiro;
		this.tipoServico = tipoServico;

		if (this.dataInicial == null)
			throw new IllegalArgumentException(DATA_INICIAL_BRANCO);

		if (this.dataFinal == null)
			throw new IllegalArgumentException(DATA_FINAL_BRANCO);

		if (this.barbeiro == null)
			throw new IllegalArgumentException(BARBEIRO_BRANCO);

		if (this.tipoServico == null)
			throw new IllegalArgumentException(TIPO_SERVICO_BRANCO);
	}

	public Receipt() {
	}

	public String getDataInicial() {
		return dataInicial;
	}

	//this setter define how the inicial date must be filled
	public void setDataInicial(String dataInicial) throws ReceiptException,
			NullPointerException, ParseException {
		if (dataInicial == null)
			throw new NullPointerException(DATA_INICIAL_BRANCO);
		else if ("".equals(dataInicial))
			throw new AssertionError(DATA_INICIAL_BRANCO);
		else {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataIso = sdf.parse(dataInicial);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			String dataISO = sdf2.format(dataIso);

			this.dataInicial = dataISO;
		}

	}

	public String getDataFinal() {
		return dataFinal;
	}

	//this setter define how the final date must be filled
	public void setDataFinal(String dataFinal) throws ReceiptException, NullPointerException,
			ParseException {
		
		if (dataFinal == null)
			throw new NullPointerException(DATA_FINAL_BRANCO);
		else if ("".equals(dataFinal))
			throw new AssertionError(DATA_FINAL_BRANCO);
		else {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataIso = sdf.parse(dataFinal);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			String dataISO = sdf2.format(dataIso);
			
			this.dataFinal = dataISO;
		}
	}

	public String getBarbeiro() {
		return barbeiro;
	}

	//this setter define how the barber must be filled in report
	public void setBarbeiro(String barbeiro) throws ReceiptException {
		if (barbeiro == null)
			throw new NullPointerException(BARBEIRO_BRANCO);
		else if ("".equals(barbeiro))
			throw new AssertionError(BARBEIRO_BRANCO);
		else
			this.barbeiro = barbeiro;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	//this setter define how the type of service must be filled
	public void setTipoServico(String tipoServico) throws ReceiptException {
		if (tipoServico == null)
			throw new NullPointerException(TIPO_SERVICO_BRANCO);
		else if ("".equals(tipoServico))
			throw new AssertionError(TIPO_SERVICO_BRANCO);
		else
			this.tipoServico = tipoServico;
	}
	
	//this method converts the input date to according norms to ABNT
	public String ConverterDataParaABNT(String data) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataISO = sdf.parse(data);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String databr = sdf2.format(dataISO);
		
		return databr;
	}
	

}
