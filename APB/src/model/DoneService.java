/*
 * Package: model
 * Class: DoneService.java
 *
 * Description: This class is reponsible to model the service done by the barber in system with all its
 * atributes and necessary methods to attribute them.
*/

package model;

import java.util.Date;

import exception.ServiceException;
import exception.ServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DoneService {

	//Declaration of the atributes to the service.
	private String serviceName; //Name of service to be done.
	private String barberName; 	//Name of barber that did the service.
	private String price; 		//Price of service
	private String date; 		//The date when the service was done.

	//Declaration of constants along the class
	private final String INVALID_SERVICE_NAME = "Nome do Serviço Inválido";
	private final String EMPTY_SERVICE_NAME = "Nome do Serviço em Branco";
	private final String INVALID_BARBER = "Nome do Barbeiro em Branco";
	private final String EMPTY_BARBER = "Insira um Barbeiro responsável pelo serviço";
	private final String INVALID_PRICE = "Preço Inválido";
	private final String EMPTY_PRICE = "Preço em Branco";
	private final String EMPTY_DATE = "Data em Branco";
	private final String INVALID_DATE = "Insira uma date válida";

	/**
	* Constructor.
	*
	* @param serviceName if the name of the service to be done.
	* @param price is the price tag of the service.
	* @param barberName is the name of barber that done the service.
	*/
	public DoneService(String serviceName, String price, String barberName) {
		this.serviceName = serviceName;
		this.price = price;
		this.barberName = barberName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getBarberName() {
		return barberName;
	}

	public String getPrice() {
		return price;
	}

	public String getDate() {
		return date;
	}

	// Service name setter
	public void setServiceName(String serviceName) throws ServiceException {
		if (serviceName == null)
			throw new NullPointerException(EMPTY_SERVICE_NAME);
		else if ("".equals(serviceName))
			throw new ServiceException(EMPTY_SERVICE_NAME);
		else if (serviceName.matches("^[[ ]|\\p{L}*]+$"))
			this.serviceName = serviceName;
		else
			throw new ServiceException(INVALID_SERVICE_NAME);
	}

	// Barber name setter
	public void setBarberName(String barberName) throws ServiceException {
		if (barberName == null)
			throw new NullPointerException(EMPTY_BARBER);
		else if ("".equals(barberName))
			throw new ServiceException(EMPTY_BARBER);
		else if (barberName.matches("^[[ ]|\\p{L}*]+$"))
			this.barberName = barberName;
		else
			throw new ServiceException(INVALID_BARBER);
	}

	// Price setter
	public void setPrice(String price) throws ServiceException {
		if (price == null)
			throw new NullPointerException(EMPTY_PRICE);
		else if ("".equals(price))
			throw new ServiceException(EMPTY_PRICE);
		else if (price.matches("[\\d]{1,3},[\\d]{1,2}"))
			this.price = price;
		else
			throw new ServiceException(INVALID_PRICE);
	}

	// Date setter
	public void setDate(String date) throws ServiceException, ParseException {

		if (date == null)
			throw new NullPointerException(EMPTY_DATE);
		else if ("".equals(date))
			throw new ServiceException(EMPTY_DATE);
		else if (date.matches("[\\d]{1,4}-[\\d]{1,2}-[\\d]{1,2}")) {
			this.date = date;
		} else if (date.matches("[\\d]{1,2}/[\\d]{1,2}/[\\d]{1,4}")) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dateISO = sdf.parse(date);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			String stringDateBR = sdf2.format(dateISO);

			this.date = stringDateBR;
		} else
			throw new ServiceException(INVALID_DATE);
	}

	// Method to convert service date to ABNT
	public String ConvertTOABNT(String date) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateISO = sdf.parse(date);

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String stringDateBR = sdf2.format(dateISO);

		return stringDateBR;
	}
}
