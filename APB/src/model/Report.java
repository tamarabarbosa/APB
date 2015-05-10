/*
 * Package: model
 * Class: Report.java
 *
 * Description: This class is reponsible to model the Report in system with all its
 * atributes and necessary methods to attribute them.
 */

package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import exception.ReportException;

public class Report {

	// Declaration of the atributes to the Report
	private String initialDate; // The date when the service started.
	private String endDate; // The date when the service was done.
	private String barber; // The barber that did the service.
	private String serviceType; // The type of service that was done.

	// Declaration of the constants along the class
	private final String END_DATE_EMPTY = "Data final em Branco";
	private final String INITIAL_DATE_EMPTY = "Data inicial em Branco";
	private final String BARBER_EMPTY = "Barber em Branco";
	private final String SERVICE_TYPE_EMPTY = "Tipo do Serviço em Branco";

	/**
	 * Constructor.
	 *
	 * @param initialDate
	 *            is when the service started.
	 * @param endDate
	 *            is when the service was done.
	 * @param barber
	 *            is the barber that did the service.
	 * @param serviceType
	 *            is the service type that was done.
	 *
	 * @exception IllegalArgumentException 
	 * 								if the class set a null value to the initialDate.
	 * @exception IllegalArgumentException 
	 * 								if the class set a null value to the endDate.
	 * @exception IllegalArgumentException 
	 * 								if the class set a null value to the barber.
	 * @exception IllegalArgumentException 
	 * 								if the class set a null value to the serviceType.
	 */
	public Report(String initialDate, String endDate, String barber,
			String serviceType) throws ReportException {

		this.initialDate = initialDate;
		this.endDate = endDate;
		this.barber = barber;
		this.serviceType = serviceType;

		if (this.initialDate == null)
			throw new IllegalArgumentException(INITIAL_DATE_EMPTY);

		if (this.endDate == null)
			throw new IllegalArgumentException(END_DATE_EMPTY);

		if (this.barber == null)
			throw new IllegalArgumentException(BARBER_EMPTY);

		if (this.serviceType == null)
			throw new IllegalArgumentException(SERVICE_TYPE_EMPTY);
	}

	/**
	 * Get the initial date of the service done.
	 *
	 * @return initialDate the date when the service started.
	 */
	public String getInitialDate() {
		return initialDate;
	}

	
	/**
	* Set the date of the the service started in the report, according with
	* brazilian standards.
	*
	* @param initialDate 
	*				is the date when the service started.
	*
	* @exception NullPointerException 
	*					if the initialDate is setted with a null value.
	* @exception AssertionError
	*					if the initialDate is setted with empty field.
	*/
	public void setInitialDate(String initialDate) throws ReportException,
			NullPointerException, ParseException {
		if (initialDate == null)
			throw new NullPointerException(INITIAL_DATE_EMPTY);
		else if ("".equals(initialDate))
			throw new AssertionError(INITIAL_DATE_EMPTY);
		else {

			SimpleDateFormat dateBRFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateISO = dateBRFormat.parse(initialDate);

			SimpleDateFormat dateUSFormat = new SimpleDateFormat("yyyy-MM-dd");
			String stringDateBR = dateUSFormat.format(dateISO);

			this.initialDate = stringDateBR;
		}

	}

	/**
	 * Get the final date when the service was done.
	 *
	 * @return endDate the date when the service was done.
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	* Set the date when the the service finished in the report, according with
	* brazilian standards.
	*
	* @param endDate 
	*				is the date when the service finished.
	*
	* @exception NullPointerException 
	*					if the endDate is setted with a null value.
	* @exception AssertionError
	*					if the endDate is setted with empty field.
	*/
	public void setEndDate(String endDate) throws ReportException,
			NullPointerException, ParseException {

		if (endDate == null)
			throw new NullPointerException(END_DATE_EMPTY);
		else if ("".equals(endDate))
			throw new AssertionError(END_DATE_EMPTY);
		else {

			SimpleDateFormat dateBRFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateISO = dateBRFormat.parse(endDate);

			SimpleDateFormat dateUSFormat = new SimpleDateFormat("yyyy-MM-dd");
			String stringDateBR = dateUSFormat.format(dateISO);

			this.endDate = stringDateBR;
		}
	}

	public String getBarber() {
		return barber;
	}

	// this setter define how the barber must be filled in report
	public void setBarber(String barber) throws ReportException {
		if (barber == null)
			throw new NullPointerException(BARBER_EMPTY);
		else if ("".equals(barber))
			throw new AssertionError(BARBER_EMPTY);
		else
			this.barber = barber;
	}

	public String getServiceType() {
		return serviceType;
	}

	// this setter define how the type of service must be filled
	public void setServiceType(String serviceType) throws ReportException {
		if (serviceType == null)
			throw new NullPointerException(SERVICE_TYPE_EMPTY);
		else if ("".equals(serviceType))
			throw new AssertionError(SERVICE_TYPE_EMPTY);
		else
			this.serviceType = serviceType;
	}

	// this method converts the input date to according norms to ABNT
	public String ConvertToABNT(String date) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateISO = sdf.parse(date);

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String stringDateBR = sdf2.format(dateISO);

		return stringDateBR;
	}

}
