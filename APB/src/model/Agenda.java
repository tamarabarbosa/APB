package model;

import exception.BarbeiroException;

public class Agenda {

	private String nome;
	private String telefone;
	private String descricao;
	private static String oldTelefone;

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

	public void setNome(String nome) {
				this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
		public static String getOldTelefone() {
				return oldTelefone;
			}
		
			public void setOldTelefone(String oldTelefone) {
				this.oldTelefone = oldTelefone;
			}


}
