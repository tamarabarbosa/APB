package model;

import java.util.Date;

import exception.ServicoException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ServicoPrestado {

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


	public ServicoPrestado() {

	}

	public ServicoPrestado(String nomeServico, String preco, String nomeBarbeiro) {
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
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        data = formato.format(date);
        return data;
    }


	public void setNomeServico(String nomeServico) throws ServicoException {
		if (nomeServico == null)
			throw new NullPointerException(NOME_BRANCO);
		else if ("".equals(nomeServico))
			throw new ServicoException(NOME_BRANCO);
		else if (nomeServico.matches("^[[ ]|\\p{L}*]+$")) // inclui letras acentuadas
			this.nomeServico = nomeServico;
		else
			throw new ServicoException(NOME_INVALIDO);
	}

	public void setNomeBarbeiro(String nomeBarbeiro) throws ServicoException {
		if (nomeBarbeiro == null)
			throw new NullPointerException(BARBEIRO_BRANCO);
		else if ("".equals(nomeBarbeiro))
			throw new ServicoException(BARBEIRO_BRANCO);
		else if (nomeBarbeiro.matches("^[[ ]|\\p{L}*]+$"))
			this.nomeBarbeiro = nomeBarbeiro;
		else
			throw new ServicoException(BARBEIRO_INVALIDO);
	}

	public void setPreco(String preco) throws ServicoException {
		if (preco == null)
			throw new NullPointerException(PRECO_BRANCO);
		else if ("".equals(preco))
			throw new ServicoException(PRECO_BRANCO);
		else if (preco.matches("[\\d]{1,3},[\\d]{1,2}"))
			this.preco = preco;
		else
			throw new ServicoException(PRECO_INVALIDO);
	}

	public void setData(String data) {
		this.data = data;
	}
}
