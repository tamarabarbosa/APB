/* This class is responsible to create a report to job done */
package model;

import java.util.Date;

import exception.ServiceException;
import exception.ServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DoneService {

	private String nomeServico;
	private String nomeBarbeiro;
	private String preco;
	private String data;

	private final String NOME_INVALIDO = "Nome do Serviço Inválido";
	private final String NOME_BRANCO = "Nome do Serviço em Branco";
	private final String BARBEIRO_INVALIDO = "Nome do Barbeiro em Branco";
	private final String BARBEIRO_BRANCO = "Insira um Barbeiro responsável pelo serviço";
	private final String PRECO_INVALIDO = "Preço Inválido";
	private final String PRECO_BRANCO = "Preço em Branco";
	private final String DATA_BRANCO = "Data em Branco";
	private final String DATA_INVALIDA = "Insira uma data válida";

	public DoneService() {

	}

	// Class constructor
	public DoneService(String nomeServico, String preco, String nomeBarbeiro) {
		this.nomeServico = nomeServico;
		this.preco = preco;
		this.nomeBarbeiro = nomeBarbeiro;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public String getNomeBarbeiro() {
		return nomeBarbeiro;
	}

	public String getPreco() {
		return preco;
	}

	public String getData() {
		return data;
	}

	// Service name setter
	public void setNomeServico(String nomeServico) throws ServiceException {
		if (nomeServico == null)
			throw new NullPointerException(NOME_BRANCO);
		else if ("".equals(nomeServico))
			throw new ServiceException(NOME_BRANCO);
		else if (nomeServico.matches("^[[ ]|\\p{L}*]+$"))
			this.nomeServico = nomeServico;
		else
			throw new ServiceException(NOME_INVALIDO);
	}

	// Barber name setter
	public void setNomeBarbeiro(String nomeBarbeiro) throws ServiceException {
		if (nomeBarbeiro == null)
			throw new NullPointerException(BARBEIRO_BRANCO);
		else if ("".equals(nomeBarbeiro))
			throw new ServiceException(BARBEIRO_BRANCO);
		else if (nomeBarbeiro.matches("^[[ ]|\\p{L}*]+$"))
			this.nomeBarbeiro = nomeBarbeiro;
		else
			throw new ServiceException(BARBEIRO_INVALIDO);
	}

	// Price setter
	public void setPreco(String preco) throws ServiceException {
		if (preco == null)
			throw new NullPointerException(PRECO_BRANCO);
		else if ("".equals(preco))
			throw new ServiceException(PRECO_BRANCO);
		else if (preco.matches("[\\d]{1,3},[\\d]{1,2}"))
			this.preco = preco;
		else
			throw new ServiceException(PRECO_INVALIDO);
	}

	// Date setter
	public void setData(String data) throws ServiceException, ParseException {

		if (data == null)
			throw new NullPointerException(DATA_BRANCO);
		else if ("".equals(data))
			throw new ServiceException(DATA_BRANCO);
		else if (data.matches("[\\d]{1,4}-[\\d]{1,2}-[\\d]{1,2}")) {
			this.data = data;
		} else if (data.matches("[\\d]{1,2}/[\\d]{1,2}/[\\d]{1,4}")) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataIso = sdf.parse(data);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			String dataISO = sdf2.format(dataIso);

			this.data = dataISO;
		} else
			throw new ServiceException(DATA_INVALIDA);
	}

	// Method to convert service date to ABNT
	public String ConverterDataParaABNT(String data) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataISO = sdf.parse(data);

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String databr = sdf2.format(dataISO);

		return databr;
	}
}
