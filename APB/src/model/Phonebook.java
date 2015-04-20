/*
 * Package: model
 * Class: Phonebook.java
 *
 * Description: This class is reponsible to model the appointment book in system with all its 
 * atributes and necessary methods to attribute them.
 */

package model;

import exception.BarberException;

public class Phonebook {

	// Declaration of the atributes to the phonebook
	private static String name; // Name of someone to be add in phonebook.
	private static String phoneNumber; // Phone number of someone to be add in
								// phonebook.
	private static String description; // Some description to add, if necessary.

	// Declaration of instance variables
	private static String tempName;

	// Declaration of the constants along the class
	private final String INVALID_NAME = "Nome Inválido";
	private final String EMPTY_NAME = "Nome em Branco";
	private final String INVALID_PHONE = "Telefone Inválido";
	private final String EMPTY_PHONE = "Telefone em Branco";

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            is the name of someone.
	 * @param phoneNumber
	 *            is the phone number someone.
	 * @param description
	 *            is the description of itself.
	 */
	public Phonebook(String name, String phoneNumber, String description) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}

	/**
	 * Get the current name.
	 *
	 * @return current name of the barber in appoiment book
	 */
	public static String getName() {
		return name;
	}

	/**
	 * Get the current phone number.
	 *
	 * @return current phone number of the barber in appoiment book
	 */
	public static String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Get the current description of service.
	 *
	 * @return the description of the barber in appoiment book
	 */
	public static String getDescription() {
		return description;
	}

	/**
	 * Set the name of the barber to search in appoiment book, case the name
	 * doesn't exist or the field setted empty, the method return an warning
	 * while the user doesn't fill correctly.
	 *
	 * @param name
	 *            is the name of the barber to be placed into name.
	 * 
	 * @exception BarberException
	 *                if the field setted empty.
	 * @exception BarbeiroExcepetion
	 *                if the name of barber doesn't exist.
	 */
	public void setName(String name) throws BarberException {
		if ("".equals(name))
			throw new BarberException(EMPTY_NAME);
		else if (name.matches("^[[ ]|\\p{L}*]+$"))
			this.name = name;
		else
			throw new BarberException(INVALID_NAME);
	}

	/**
	 * Set the phone number of the barber to search in appoiment book, case the
	 * tphone number doesn't exist or the field setted empty, the method return
	 * an warning while the user doesn't fill correctly.
	 *
	 * @param phoneNumber
	 *            is the phone number of the barber to be placed into
	 *            phoneNumber.
	 *
	 * @exception BarberException
	 *                if the field setted empty.
	 * @exception BarbeiroExcepetion
	 *                if the phone number of barber doesn't exist.
	 */
	public void setPhoneNumber(String phoneNumber) throws BarberException {
		if ("".equals(phoneNumber))
			throw new BarberException(EMPTY_PHONE);
		else if (phoneNumber
				.matches("(\\([\\d]{2,3}\\))?[ ]*[\\d]{4,4}[ ]*-[ ]*[\\d]{4,4}[ ]*$"))
			this.phoneNumber = phoneNumber;
		else
			throw new BarberException(INVALID_PHONE);
	}

	/**
	 * Set the description of the service that the barber will do.
	 *
	 * @param description
	 *            is the description of the service to be placed into
	 *            description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public static String getTempName() {
		return tempName;
	}

	public static void setTempName(String tempName) {
		Phonebook.tempName = tempName;
	}

}
