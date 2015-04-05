/*

*/

package model;

import exception.BarbeiroException;

public class Agenda {

	//Declaration of the atributes  
	private String nome;
	private String telefone;
	private String descricao;

	//Declation of instance variables
	private static String tempNome;

	//Declaration of the constants along the class
	private final String NOME_INVALIDO = "Nome Inválido";
	private final String NOME_BRANCO = "Nome em Branco";
	private final String TELEFONE_INVALIDO = "Telefone Inválido";
	private final String TELEFONE_BRANCO = "Telefone em Branco";

	//this is the constructor of object "Agenda"
	public Agenda(String nome, String telefone, String descricao) {
		this.nome = nome;
		this.telefone = telefone;
		this.descricao = descricao;
	}

	/**
 	* @return current name of the barber in appoiment book
 	*/
	public String getNome() {
		return nome;
	}

	/**
 	* @return current telephone of the barber in appoiment book
 	*/
	public String getTelefone() {
		return telefone;
	}

	/**
 	* @return the description of the barber in appoiment book
 	*/
	public String getDescricao() {
		return descricao;
	}

	/**	 
	* Set the name of the barber to search in appoiment book, case the name doesn't
	* exist or the field setted empty, the method return an warning while
	* the user doesn't filled correctly.
	*
 	* @param nome is the name of the barber to be placed into nome.
 	* 
 	* @exception BarbeiroException if the field setted empty.
 	* @exception BarbeiroExcepetion if the name of barber doesn't exist. 
 	*/
	public void setNome(String nome) throws BarbeiroException {
		if ("".equals(nome))
			throw new BarbeiroException(NOME_BRANCO);
		else if (nome.matches("^[[ ]|\\p{L}*]+$"))
			this.nome = nome;
		else
			throw new BarbeiroException(NOME_INVALIDO);
	}

	/**	 
	* Set the telephone of the barber to search in appoiment book, case the telephone doesn't
	* exist or the field setted empty, the method return an warning while
	* the user doesn't filled correctly.
	*
 	* @param telefone is the telephone of the barber to be placed into telefone.
 	*
 	* @exception BarbeiroException if the field setted empty.
 	* @exception BarbeiroExcepetion if the telephone of barber doesn't exist. 
 	*/
	public void setTelefone(String telefone) throws BarbeiroException {
		if ("".equals(telefone))
			throw new BarbeiroException(TELEFONE_BRANCO);
		else if (telefone.matches("(\\([\\d]{2,3}\\))?[ ]*[\\d]{4,4}[ ]*-[ ]*[\\d]{4,4}[ ]*$"))
			this.telefone = telefone;
		else
			throw new BarbeiroException(TELEFONE_INVALIDO);
	}

	/**	 
	* Set the description of the service that the barber will do.
	*
 	* @param descricao is the description of the service to be placed into descricao.
 	*/
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static String getTempNome() {
		return tempNome;
	}

	public static void setTempNome(String tempNome) {
		Agenda.tempNome = tempNome;
	}

}
