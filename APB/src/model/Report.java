/* This class is responsible to create a report of the barbers*/
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import exception.RelatorioException;

public class Report {

	private String initialDate;
	private String endDate;
	private String barber;
	private String serviceType;

	private final String END_DATE_EMPTY = "Data final em Branco";
	private final String INITIAL_DATE_EMPTY = "Data inicial em Branco";
	private final String BARBER_EMPTY = "Barbeiro em Branco";
	private final String SERVICE_TYPE_EMPTY = "Tipo do Serviço em Branco";

	public Report(String initialDate, String endDate, String barber,
			String serviceType) throws RelatorioException {
		// super();
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

	public Report() {
	}

	public String getInitialDate() {
		return initialDate;
	}

	//this setter define how the inicial date must be filled
	public void setInitialDate(String initialDate) throws RelatorioException,
			NullPointerException, ParseException {
		if (initialDate == null)
			throw new NullPointerException(INITIAL_DATE_EMPTY);
		else if ("".equals(initialDate))
			throw new AssertionError(INITIAL_DATE_EMPTY);
		else {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dateISO = sdf.parse(initialDate);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			String stringDateBR = sdf2.format(dateISO);

			this.initialDate = stringDateBR;
		}

	}

	public String getEndDate() {
		return endDate;
	}

	//this setter define how the final date must be filled
	public void setEndDate(String endDate) throws RelatorioException, NullPointerException,
			ParseException {
		
		if (endDate == null)
			throw new NullPointerException(END_DATE_EMPTY);
		else if ("".equals(endDate))
			throw new AssertionError(END_DATE_EMPTY);
		else {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dateISO = sdf.parse(endDate);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			String stringDateBR = sdf2.format(dateISO);
			
			this.endDate = stringDateBR;
		}
	}

	public String getBarber() {
		return barber;
	}

	//this setter define how the barber must be filled in report
	public void setBarber(String barber) throws RelatorioException {
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

	//this setter define how the type of service must be filled
	public void setServiceType(String serviceType) throws RelatorioException {
		if (serviceType == null)
			throw new NullPointerException(SERVICE_TYPE_EMPTY);
		else if ("".equals(serviceType))
			throw new AssertionError(SERVICE_TYPE_EMPTY);
		else
			this.serviceType = serviceType;
	}
	
	//this method converts the input date to according norms to ABNT
	public String ConvertToABNT(String date) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateISO = sdf.parse(data);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String stringDateBR = sdf2.format(dateISO);
		
		return stringDateBR;
	}
	

}
