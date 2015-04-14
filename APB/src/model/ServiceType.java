/*
 * Package: model
 * Class: ServiceType.java
 *
 * Description: This class is reponsible to model the type of service done by the barber 
 * in system with all its atributes and necessary methods to attribute them.
*/

package model;

import exception.ServiceException;

public class ServiceType {

	private String nomeServiceType;
	private String preco;
	private static String tempNome;

	private final static String NOME_BRANCO = "Nome do Servi�o em Branco";
	private final String PRECO_INVALIDO = "Pre�o Inv�lido";
	private final String PRECO_BRANCO = "Pre�o em Branco";

	
	public ServiceType(){
	}
	
	public String getNomeServiceType() {
		return nomeServiceType;
	}

	public String getPreco() {
		return preco;
	}
	
	public static String getTempNome() {
		return tempNome;
	}

	public void setNomeServiceType(String nomeServiceType) throws ServiceException {
		if (nomeServiceType == null)
			throw new NullPointerException(NOME_BRANCO);
		else if ("".equals(nomeServiceType))
			throw new ServiceException(NOME_BRANCO);
		else
			this.nomeServiceType = nomeServiceType;
	}

	public void setPreco(String preco) throws ServiceException {
		if (preco == null)
			throw new NullPointerException(PRECO_INVALIDO);
		else if ("".equals(preco))
			throw new ServiceException(PRECO_BRANCO);
		else if (preco.matches("[\\d]{1,3},[\\d]{1,2}"))
			this.preco = preco;
		else
			throw new IllegalArgumentException("Pre�o deve ser no formato: **,** ");
	}

	public static void setTempNome(String tempNome) throws ServiceException {
		if (tempNome == null)
			throw new NullPointerException(NOME_BRANCO);
		else if ("".equals(tempNome))
			throw new ServiceException(NOME_BRANCO);
		else
			ServiceType.tempNome = tempNome;
	}
}
