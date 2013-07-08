package model;

import exception.ServicoException;

public class TipoServico {

	private String nomeTipoServico;
	private String preco;

	private final String NOME_INVALIDO = "Nome do Serviço Inválido";
	private final String NOME_BRANCO = "Nome do Serviço em Branco";
	private final String PRECO_INVALIDO = "Preço Inválido";
	private final String PRECO_BRANCO = "Preço em Branco";

	
	public TipoServico(){
	}
	
	public String getNomeTipoServico() {
		return nomeTipoServico;
	}

	public String getPreco() {
		return preco;
	}

	public void setNomeTipoServico(String nomeTipoServico)
			throws ServicoException {
		if (nomeTipoServico == null)
			throw new NullPointerException(NOME_BRANCO);
		else if ("".equals(nomeTipoServico))
			throw new ServicoException(NOME_BRANCO);
		else if (nomeTipoServico.matches("^[[ ]|\\p{L}*]+$")) // inclui letras
																// acentuadas
			this.nomeTipoServico = nomeTipoServico;
		else
			throw new ServicoException(NOME_INVALIDO);
	}

	public void setPreco(String preco) throws ServicoException {
		try {
			if (preco == null)
				throw new NullPointerException(PRECO_INVALIDO);
			else if ("".equals(preco))
				throw new ServicoException(PRECO_BRANCO);
			else if (preco.matches("[\\d]{1,3},[\\d]{1,2}"))
				this.preco = preco;
			else
				throw new ServicoException(PRECO_INVALIDO);
		} catch (IllegalArgumentException e) {
			throw new ServicoException(PRECO_INVALIDO);
		}
	}
}
