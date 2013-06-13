package model;

public class Servico {

	private String nome;
	private String preco;
	
	public Servico(String nome, String preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public Servico() {
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
