package model;

import java.util.Date;

public class Servico {

	private String nome;
	private String preco;
	private String nomeDoBarbeiro;
	private Date data;

	
	public Servico() {
		
	}

	public Servico(String nome, String preco, String  nomeDoBarbeiro, Date data) {
		this.nome = nome;
		this.preco = preco;
		this.data = data;
		this.nomeDoBarbeiro = nomeDoBarbeiro;
	}
	
	


	public String getNomeDoBarbeiro() {
		return nomeDoBarbeiro;
	}

	public void setNomeDoBarbeiro(String nomeDoBarbeiro) {
		this.nomeDoBarbeiro = nomeDoBarbeiro;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

}
