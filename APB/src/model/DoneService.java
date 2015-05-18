/*
 * Package: model
 * Class: DoneService.java
 *
 * Description: This class is reponsible to model the service done by the barber in system with all its
 * atributes and necessary methods to attribute them.
 */

package model;

import java.util.Date;

import exception.BarberException;
import exception.ServiceException;
import exception.ServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class DoneService {

	// Declaration of the atributes to the service.
	private String serviceName; // Name of service to be done.
	private String barberName; // Name of barber that did the service.
	private String price; // Price of service
	private String date; // The date when the service was done.

	// Declaration of constants along the class
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
	 * @param serviceName
	 *            is the name of the service.
	 * @param price
	 *            is the price of the service.
	 * @param description
	 *            is the description of the service.
	 */
	public DoneService(String serviceName, String price, String barberName) {
		this.serviceName = serviceName;
		this.price = price;
		this.barberName = barberName;

		Logger.getLogger("Create the atributes od DoneService");
	}

	/**
	 * Get the current Service Name.
	 *
	 * @return current ServiceName of service name in appointment book
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * Get the current Barber Name
	 * 
	 * @return current name of Barber in appointment book
	 */
	public String getBarberName() {
		return barberName;
	}

	/**
	 * Get the current Price
	 * 
	 * @return current price of service in appointment book
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Get the Date
	 * 
	 * @return current Date of service in appointment book
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set the service name of the service of to search in appointment book,
	 * case the name doesn't exist or the field setted empty, the method return
	 * an warning while the user doesn't fill correctly.
	 *
	 * @param name
	 *            is the name of service to be placed into ServiceName.
	 *
	 * @exception ServiceException
	 *                if the field setted empty.
	 * @exception ServiceException
	 *                if the service name doesn't exist.
	 */
	public void setServiceName(String serviceName) throws ServiceException {
		if (serviceName == null)
			throw new NullPointerException(EMPTY_SERVICE_NAME);
		else if ("".equals(serviceName))
			throw new ServiceException(EMPTY_SERVICE_NAME);
		else if (serviceName.matches("^[[ ]|\\p{L}*]+$"))
			this.serviceName = serviceName;
		else
			throw new ServiceException(INVALID_SERVICE_NAME);

		Logger.getLogger("Verify empty service name");

	}

	/**
	 * Set the Barber name to search in appointment book, case the Barber name
	 * doesn't exist or the field setted empty, the method return an warning
	 * while the user doesn't fill correctly.
	 *
	 * @param barberName
	 *            is the name of Barber to be placed into barberName.
	 *
	 * @exception ServiceException
	 *                if the field setted empty.
	 * @exception ServiceException
	 *                if the barber name doesn't exist.
	 */

	public void setBarberName(String barberName) throws ServiceException {
		if (barberName == null)
			throw new NullPointerException(EMPTY_BARBER);
		else if ("".equals(barberName))
			throw new ServiceException(EMPTY_BARBER);
		else if (barberName.matches("^[[ ]|\\p{L}*]+$"))
			this.barberName = barberName;
		else
			throw new ServiceException(INVALID_BARBER);

		Logger.getLogger("Verify empty barber");

	}

	/**
	 * Set the price of the service done by the barber, case the user input an
	 * invalid price the method return an warning while the user doesn't fill
	 * correctly.
	 * 
	 * @param price
	 *            is the price of service to be placed into price.
	 *
	 * @exception NullPointerException
	 *                if the price is equal to a null value.
	 * @exception ServiceException
	 *                if the price is setted empty.
	 * @exception ServiceException
	 *                if the user set any invalid price.
	 */
	public void setPrice(String price) throws ServiceException {
		if (price == null)
			throw new NullPointerException(EMPTY_PRICE);
		else if ("".equals(price))
			throw new ServiceException(EMPTY_PRICE);
		else if (price.matches("[\\d]{1,3},[\\d]{1,2}"))
			this.price = price;
		else
			throw new ServiceException(INVALID_PRICE);

		Logger.getLogger("Verify empty service price");

	}

	/**
	 * Set the date when the service was done, case the user input an invalid
	 * date the method return an warning while the user doesn't fill correctly.
	 *
	 * @param date
	 *            is the current date of the done service.
	 *
	 * @exception NullPointerException
	 *                if the date is equal to a null value.
	 * @exception ServiceException
	 *                if the date is setted empty.
	 * @exception ServiceException
	 *                if the user set an invalid date.
	 */
	public void setDate(String date) throws ServiceException, ParseException {

		if (date == null)
			throw new NullPointerException(EMPTY_DATE);
		else if ("".equals(date))
			throw new ServiceException(EMPTY_DATE);
		else if (date.matches("[\\d]{1,4}-[\\d]{1,2}-[\\d]{1,2}")) {
			this.date = date;
		} else if (date.matches("[\\d]{1,2}/[\\d]{1,2}/[\\d]{1,4}")) {

			SimpleDateFormat dateBRFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateISO = dateBRFormat.parse(date);

			SimpleDateFormat dateUSFormat = new SimpleDateFormat("yyyy-MM-dd");
			String stringDateBR = dateUSFormat.format(dateISO);

			this.date = stringDateBR;
		} else
			throw new ServiceException(INVALID_DATE);

		Logger.getLogger("Verify empty service date");

	}

	/**
	 * It's a method to validate the date beyond brazilian standards, and
	 * returns the right date to the class.
	 *
	 * @param date
	 *            is the current date of the done service.
	 * @return stringDateBR is the date with brazilian standards.
	 */
	public String ConvertTOABNT(String date) throws ParseException {

		SimpleDateFormat dateBRFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateISO = dateBRFormat.parse(date);

		SimpleDateFormat dateUSFormat = new SimpleDateFormat("dd/MM/yyyy");
		String stringDateBR = dateUSFormat.format(dateISO);

		Logger.getLogger("Return a new format of date");

		return stringDateBR;
	}
}
