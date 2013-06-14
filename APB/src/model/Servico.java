package model;

import java.util.Date;

public class Servico {

	private String nome;
	private String preco;
	private Barbeiro barbeiro;
	private Date data;

	
	public Servico() {
		
	}

	public Servico(String nome, String preco, Barbeiro barbeiro, Date data) {
		this.nome = nome;
		this.preco = preco;
		this.barbeiro =  barbeiro;
		this.data = data;
	}
	
	

	public Barbeiro getBarbeiro() {
		return barbeiro;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
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
