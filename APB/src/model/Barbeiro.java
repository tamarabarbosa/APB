package model;

import exception.BarbeiroException;

public class Barbeiro {

	private String nome;
	private String cpf;
	private String rg;
	private String telefone;
	private int cadeira;
	private Servico servicos[];

	private final String NOME_INVALIDO = "Nome Inválido.";
	private final String NOME_BRANCO = "Nome em Branco.";
	private final String CPF_INVALIDO = "CPF Inválido.";
	private final String CPF_BRANCO = "CPF em Branco.";
	private final String RG_BRANCO = "RG em Branco.";
	private final String TELEFONE_INVALIDO = "Telefone Inválido.";
	private final String TELEFONE_BRANCO = "Telefone em Branco.";

	public Barbeiro() {

	}

	public Barbeiro(String nome, String cpf, String rg, String telefone,
			int cadeira) throws BarbeiroException {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.cadeira = cadeira;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public int getCadeira() {
		return cadeira;
	}

	public Servico[] getServicos() {
		return servicos;
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

	public void setCpf(String cpf) throws BarbeiroException {
		try {
			if ("".equals(cpf))
				throw new BarbeiroException(CPF_BRANCO);
			else if (cpf
					.matches("[\\d]{3,3}.[\\d]{3,3}.[\\d]{3,3}-[\\d]{2,2}$")) {
				cpf = cpf.split("[\\. | -]")[0] + cpf.split("[\\. | -]")[1]
						+ cpf.split("[\\. | -]")[2] + cpf.split("[\\. | -]")[3];
			}

			if (this.validarCpf(cpf))
				this.cpf = cpf;
			else
				throw new BarbeiroException(CPF_INVALIDO);

		} catch (StringIndexOutOfBoundsException e) {
			throw new BarbeiroException(CPF_INVALIDO);
		} catch (NumberFormatException e) {
			throw new BarbeiroException(CPF_INVALIDO);
		}
	}

	public void setRg(String rg) throws BarbeiroException {
		if ("".equals(rg))
			throw new BarbeiroException(RG_BRANCO);
		else
			this.rg = rg;
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

	public void setCadeira(int cadeira) {
		this.cadeira = cadeira;
	}

	public void setServicos(Servico[] servicos) {
		this.servicos = servicos;
	}

	private boolean validarCpf(String cpf) {
		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String result;

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount))
					.intValue();

			d1 = d1 + (11 - nCount) * digitoCPF;
			d2 = d2 + (12 - nCount) * digitoCPF;
		}
		;

		resto = d1 % 11;

		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;
		resto = (d2 % 11);

		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		String verific = cpf.substring(cpf.length() - 2, cpf.length());
		result = String.valueOf(digito1) + String.valueOf(digito2);

		return verific.equals(result);
	}

}
