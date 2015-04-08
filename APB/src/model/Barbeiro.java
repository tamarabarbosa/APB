package model;

import exception.BarbeiroException;

public class Barbeiro {

	//Declaration of atributes of the barber
	private String nome;
	private String cpf;
	private String rg;
	private String telefone;
	private String cadeira;

	//Declaration of instace variable to the class
	private static String tempNome;

	//Declarion of the constants along de class
	private final String NOME_INVALIDO = "Nome Inválido";
	private final String NOME_BRANCO = "Nome em Branco";
	private final String CPF_INVALIDO = "CPF Inválido";
	private final String CPF_BRANCO = "CPF em Branco";
	private final String RG_BRANCO = "RG em Branco";
	private final String RG_INVALIDO = "RG Inválido";
	private final String TELEFONE_INVALIDO = "Telefone Inválido";
	private final String TELEFONE_BRANCO = "Telefone em Branco";
	private final String CADEIRA_INVALIDA = "Cadeira Inválida";
	private final String CADEIRA_BRANCO = "Campo Cadeira em Branco";

	//Constructor of the barber
	public Barbeiro() {
		/*Nothing to declare*/
	}

	/**	 
	* Set the name of the new barber in system.
	*
 	* @param nome is the name of the barber to be placed into nome. 
 	* @param cpf is the CPF (Indivdual Registration) of the barber to be placed into cpf.
 	* @param rg is the ID (Identidade) of the barber to be placed into rg.
 	* @param telefone is the phone number of the barber to be placed into telefone.
 	* @param cadeira is the chair that the barber will work, to be placed into cadeira.
 	* 
 	* @exception BarbeiroException as parameter. 
 	* @throws IllegalArgumentException if the name didn't be filled. 
 	* @throws IllegalArgumentException if the CPF (Indivdual Registration) didn't be filled. 
 	* @throws IllegalArgumentException if the ID didn't be filled. 
 	* @throws IllegalArgumentException if the phone number didn't be filled. 
 	* @throws IllegalArgumentException if the chair didn't be filled. 
 	*/
	public Barbeiro(String nome, String cpf, String rg, String telefone,
			String cadeira) throws BarbeiroException {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.cadeira = cadeira;

		if (this.nome == null)
			throw new IllegalArgumentException(NOME_BRANCO);

		if (this.cpf == null)
			throw new IllegalArgumentException(CPF_BRANCO);

		if (this.rg == null)
			throw new IllegalArgumentException(RG_BRANCO);

		if (this.telefone == null)
			throw new IllegalArgumentException(TELEFONE_BRANCO);

		if (this.cadeira == null)
			throw new IllegalArgumentException(CADEIRA_BRANCO);
	}

	/**
	* Get the current name.
	* 
	* @return current name of the barber in system.
	*/
	public String getNome() {
		return nome;
	}

	/**
	* Get the current CPF (Indivdual Registration).
	* 
	* @return current CPF (Indivdual Registration) of the barber in system.
	*/
	public String getCpf() {
		return cpf;
	}

	/**
	* Get the current ID.
	* 
	* @return current ID of the barber in system.
	*/
	public String getRg() {
		return rg;
	}

	/**
	* Get the current phone number.
	* 
	* @return current phone number of the barber in system.
	*/
	public String getTelefone() {
		return telefone;
	}

	/**
	* Get the current chair.
	* 
	* @return current chair of the barber in system.
	*/
	public String getCadeira() {
		return cadeira;
	}

	/**	 
	* Set the name of the barber to in system, in case of the field name didn't be filled 
	* the method return an warning while the user doesn't fill correctly.
	*
 	* @param nome is the name of the barber to be placed into nome.
 	* 
 	* @throws NullPointerException if the name returns a null value.
 	* @throws BarbeiroException if the user didn't fill de name.
 	* @throws BarbeiroException if the name can't be placed in nome.
 	*/
	public void setNome(String nome) throws BarbeiroException {
		if (nome == null)
			throw new NullPointerException(NOME_BRANCO);
		else if ("".equals(nome))
			throw new BarbeiroException(NOME_BRANCO);
		else if (nome.matches("^[[ ]|\\p{L}*]+$"))
			this.nome= nome;
		else
			throw new BarbeiroException(NOME_INVALIDO);
	}

	/**	 
	* Set the Individual Registration of the barber to in system, in case of the field "CPF" doesn't be filled 
	* the method return an warning while the user doesn't fill correctly.
	*
 	* @param cpf is the Individual Registration of the barber to be placed into cpfe.
 	* 
 	* @throws NullPointerException if the cpf returns a null value.
 	* @throws BarbeiroException if the user didn't fill de cpf.
 	* @throws BarbeiroException if the IR doesn't match with the valid IR.
 	*/
	public void setCpf(String cpf) throws BarbeiroException {
		// Sample of valid CPF: 493.751.185-84
		try {
			if (cpf == null)
				throw new NullPointerException(CPF_BRANCO);
			else if ("".equals(cpf))
				throw new AssertionError(CPF_BRANCO);
			else if (cpf.matches("[\\d]{3,3}.[\\d]{3,3}.[\\d]{3,3}-[\\d]{2,2}$"))
				cpf = cpf.split("[\\. | -]")[0] + cpf.split("[\\. | -]")[1]
				+ cpf.split("[\\. | -]")[2] + cpf.split("[\\. | -]")[3];
			if (this.validarCpf(cpf))
				this.cpf = cpf;
			else
				throw new BarbeiroException(CPF_INVALIDO);
		} catch (AssertionError e) {
			throw new BarbeiroException(CPF_INVALIDO);
		}
	}

	//this setter define how the RG of barber must be filled
	public void setRg(String rg) throws BarbeiroException {
		if (rg == null)
			throw new NullPointerException(RG_BRANCO);
		else if ("".equals(rg))
			throw new BarbeiroException(RG_BRANCO);
		else if (rg.matches("^[[ ]|\\p{L}*]+$"))
			throw new AssertionError(RG_INVALIDO);
		else if (rg.matches("^[0-9]*$"))
			this.rg = rg;
		else
			throw new AssertionError(RG_INVALIDO);
	}

	//this setter define how the telephone of barber must be filled
	public void setTelefone(String telefone) throws BarbeiroException {
		if (telefone == null)
			throw new NullPointerException(TELEFONE_BRANCO);
		else if ("".equals(telefone))
			throw new BarbeiroException(TELEFONE_BRANCO);
		else if (telefone.matches("(\\([\\d]{2,3}\\))?[ ]*[\\d]{4,4}[ ]*-[ ]*[\\d]{4,4}[ ]*$"))
			this.telefone = telefone;
		else
			throw new AssertionError(TELEFONE_INVALIDO);
	}

	//this setter define how the chair of barber must be filled
	public void setCadeira(String cadeira) throws BarbeiroException {
		if (cadeira == null)
			throw new NullPointerException(CADEIRA_BRANCO);
		else if ("".equals(cadeira))
			throw new BarbeiroException(CADEIRA_BRANCO);
		else if ("0".equals(cadeira) || cadeira.matches("^[[ ]|\\p{L}*]+$"))
			throw new AssertionError(CADEIRA_INVALIDA);
		else if (cadeira.matches("^[0-9]{0,2}$"))
			this.cadeira = cadeira;
		else
			throw new BarbeiroException(CADEIRA_INVALIDA);
	}
	
	public static String getTempNome() {
		return tempNome;
	}

	public static void setTempNome(String tempNome) {
		Barbeiro.tempNome = tempNome;
	}

	//this method verify if the CPF was filled correctly 
	private boolean validarCpf(String cpf) {
		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String result;

		d1 = d2 = digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();

			d1 = d1 + (11 - nCount) * digitoCPF;
			d2 = d2 + (12 - nCount) * digitoCPF;
		};

		resto = d1 % 11;

		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2*digito1;
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
