package model;

public class Agenda {
	
	private String nome;
	private String telefone;
	private String descricao;

	public Agenda (){
		
	}
	
	public Agenda (String nome, String telefone, String descricao){
		
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
	
	
}
