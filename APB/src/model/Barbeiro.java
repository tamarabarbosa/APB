package model;

public class Barbeiro {

	private String nome;
	private String cpf;
	private String rg;
	private String telefone;
	private int cadeira;
	private Servico servicos[];

	public Barbeiro() {

	}

	public Barbeiro(String nome, String cpf, String rg, String telefone,
			int cadeira) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.cadeira = cadeira;
	}

	public Servico[] getServicos() {
		return servicos;
	}

	public void setServicos(Servico[] servicos) {
		this.servicos = servicos;
	}

	public int getCadeira() {
		return cadeira;
	}

	public void setCadeira(int cadeira) {
		this.cadeira = cadeira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
