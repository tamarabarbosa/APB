package model;

import exception.BarbeiroException;

public class Agenda {

	private String nome;
	private String telefone;
	private String descricao;
	
	private final String NOME_INVALIDO = "Nome Inválido.";
	private final String NOME_BRANCO = "Nome em Branco.";
	private final String TELEFONE_INVALIDO = "Telefone Inválido.";
	private final String TELEFONE_BRANCO = "Telefone em Branco.";

	public Agenda() {

	}

	public Agenda(String nome, String telefone, String descricao) {

		this.nome = nome;
		this.telefone = telefone;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws BarbeiroException {
		try {
			if ("".equals(nome))
				throw new BarbeiroException(NOME_BRANCO);
			else if (nome.matches("[a-zA-Z\\s]+"))
				this.nome = nome;
			else
				throw new BarbeiroException(NOME_INVALIDO);
		} catch (StringIndexOutOfBoundsException e) {
			throw new BarbeiroException(NOME_INVALIDO);
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws BarbeiroException {
		try {
			if ("".equals(telefone))
				throw new BarbeiroException(TELEFONE_BRANCO);
			else if (telefone
					.matches("(\\([\\d]{2,3}\\))?[ ]*[\\d]{4,4}[ ]*-[ ]*[\\d]{4,4}[ ]*$"))
				this.telefone = telefone;
			else
				throw new BarbeiroException(TELEFONE_INVALIDO);
		} catch (StringIndexOutOfBoundsException e) {
			throw new BarbeiroException(TELEFONE_INVALIDO);
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
