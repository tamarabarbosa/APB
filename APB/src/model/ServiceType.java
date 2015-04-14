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

	private String nameServiceType;
	private String price;
	private static String tempName;

	private final static String EMPTY_NAME = "Nome do Servi�o em Branco";
	private final String INVALID_PRICE = "Pre�o Inv�lido";
	private final String EMPTY_PRICE = "Pre�o em Branco";

	
	public ServiceType(){
	}
	
	public String getNameServiceType() {
		return nameServiceType;
	}

	public String getPrice() {
		return price;
	}
	
	public static String getTempName() {
		return tempName;
	}

	public void setNameServiceType(String nameServiceType) throws ServiceException {
		if (nameServiceType == null)
			throw new NullPointerException(EMPTY_NAME);
		else if ("".equals(nameServiceType))
			throw new ServiceException(EMPTY_NAME);
		else
			this.nameServiceType = nameServiceType;
	}

	public void setPrice(String price) throws ServiceException {
		if (price == null)
			throw new NullPointerException(INVALID_PRICE);
		else if ("".equals(price))
			throw new ServiceException(EMPTY_PRICE);
		else if (price.matches("[\\d]{1,3},[\\d]{1,2}"))
			this.price = price;
		else
			throw new IllegalArgumentException("Pre�o deve ser no formato: **,** ");
	}

	public static void setTempName(String tempName) throws ServiceException {
		if (tempName == null)
			throw new NullPointerException(EMPTY_NAME);
		else if ("".equals(tempName))
			throw new ServiceException(EMPTY_NAME);
		else
			ServiceType.tempName = tempName;
	}
}
