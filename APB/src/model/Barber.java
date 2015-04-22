/*
 * Package: model
 * Class: Barber.java
 *
 * Description: This class is reponsible to model the barber in system with all its
 * atributes and necessary methods to attribute them.
 */

package model;

import exception.BarberException;

public class Barber {

	// Declaration of atributes to the barber
	private String name; // Name of barber
	private String cpf; // CPF of barber
	private String rg; // RG of barber
	private String phoneNumber; // Phone number of barber
	private String chair; // The chair of barber

	// Declaration of instace variable
	private static String tempName;

	// Declarion of constants along de class
	private final String INVALID_NAME = "Nome Inválido";
	private final String EMPTY_NAME = "Nome em Branco";
	private final String INVALID_CPF = "CPF Inválido";
	private final String EMPTY_CPF = "CPF em Branco";
	private final String EMPTY_RG = "RG em Branco";
	private final String INVALID_RG = "RG Inválido";
	private final String INVALID_PHONE = "Phone Inválido";
	private final String EMPTY_PHONE = "Phone em Branco";
	private final String INVALID_CHAIR = "Cadeira Inválida";
	private final String EMPTY_CHAIR = "Campo Cadeira em Branco";

	// Constructor of the barber
	public Barber() {
		/* Nothing to declare */
	}

	/**
	 * Set the name of the new barber in system.
	 *
	 * @param name
	 *            is the name of the barber to be placed into name.
	 * @param ir
	 *            is the IR (Indivdual Registration) of the barber to be placed
	 *            into ir.
	 * @param id
	 *            is the ID (Identidade) of the barber to be placed into id.
	 * @param phoneNumber
	 *            is the phone number of the barber to be placed into
	 *            phoneNumber.
	 * @param chair
	 *            is the chair that the barber will work, to be placed into
	 *            chair.
	 *
	 * @exception BarberException
	 *                as parameter.
	 * @throws IllegalArgumentException
	 *             if the name isn't filled.
	 * @throws IllegalArgumentException
	 *             if the IR (Indivdual Registration) isn't filled.
	 * @throws IllegalArgumentException
	 *             if the ID isn't filled.
	 * @throws IllegalArgumentException
	 *             if the phone number isn't filled.
	 * @throws IllegalArgumentException
	 *             if the chair isn't filled .
	 */
	public Barber(String name, String ir, String id, String phoneNumber,
			String chair) throws BarberException {
		this.name = name;
		this.cpf = ir;
		this.rg = id;
		this.phoneNumber = phoneNumber;
		this.chair = chair;

		if (this.name == null)
			throw new IllegalArgumentException(EMPTY_NAME);

		if (this.cpf == null)
			throw new IllegalArgumentException(EMPTY_CPF);

		if (this.rg == null)
			throw new IllegalArgumentException(EMPTY_RG);

		if (this.phoneNumber == null)
			throw new IllegalArgumentException(EMPTY_PHONE);

		if (this.chair == null)
			throw new IllegalArgumentException(EMPTY_CHAIR);
	}

	/**
	 * Get the current name.
	 *
	 * @return current name of the barber in system.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the current IR (Indivdual Registration).
	 *
	 * @return current IR (Indivdual Registration) of the barber in system.
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
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Get the current chair.
	 *
	 * @return current chair of the barber in system.
	 */
	public String getChair() {
		return chair;
	}

	/**
	 * Set the name of the barber in system, in case of the field name isn't
	 * filled the method return an warning while the user doesn't fill
	 * correctly.
	 *
	 * @param name
	 *            is the name of the barber to be placed into name.
	 *
	 * @throws NullPointerException
	 *             if the name returns a null value.
	 * @throws BarberException
	 *             if the user didn't fill de name field.
	 * @throws BarberException
	 *             if the name can't be placed in name.
	 */
	public void setName(String name) throws BarberException {
		if (name == null)
			throw new NullPointerException(EMPTY_NAME);
		else if ("".equals(name))
			throw new BarberException(EMPTY_NAME);
		else if (name.matches("^[[ ]|\\p{L}*]+$"))
			this.name = name;
		else
			throw new BarberException(INVALID_NAME);
	}

	/**
	 * Set the Individual Registration of the barber in system, in case of the
	 * field "CPF" isn't filled the method return an warning while the user
	 * doesn't fill correctly.
	 *
	 * @param cpf
	 *            is the Individual Registration of the barber to be placed into
	 *            cpfe.
	 *
	 * @throws NullPointerException
	 *             if the cpf returns a null value.
	 * @throws BarberException
	 *             if the user didn't fill de IR field.
	 * @throws BarberException
	 *             if the IR doesn't match with the valid IR.
	 */
	public void setIr(String cpf) throws BarberException {
		// Sample of valid IR: 493.751.185-84
		try {
			if (cpf == null)
				throw new NullPointerException(EMPTY_CPF);
			else if ("".equals(cpf))
				throw new AssertionError(EMPTY_CPF);
			else if (cpf
					.matches("[\\d]{3,3}.[\\d]{3,3}.[\\d]{3,3}-[\\d]{2,2}$"))
				cpf = cpf.split("[\\. | -]")[0] + cpf.split("[\\. | -]")[1]
						+ cpf.split("[\\. | -]")[2] + cpf.split("[\\. | -]")[3];
			if (validateCPF(cpf))
				this.cpf = cpf;
			else
				throw new BarberException(INVALID_CPF);
		} catch (AssertionError e) {
			throw new BarberException(INVALID_CPF);
		}
	}

	/**
	 * Set the Indentidade of the barber in system, in case of the field
	 * "Identidade" isn't filled the method return an warning while the user
	 * doesn't fill correctly.
	 *
	 * @param id
	 *            is the ID of the barber to be placed into id.
	 *
	 * @throws NullPointerException
	 *             if the id returns a null value.
	 * @throws BarberException
	 *             if the user didn't fill de ID field.
	 * @throws AssertionError
	 *             if the ID doesn't match with the valid ID.
	 * @throws AssertionError
	 *             if the user fill anything different of the valid ID.
	 */
	public void setId(String rg) throws BarberException {
		if (rg == null)
			throw new NullPointerException(EMPTY_RG);
		else if ("".equals(rg))
			throw new BarberException(EMPTY_RG);
		else if (rg.matches("^[[ ]|\\p{L}*]+$"))
			throw new AssertionError(EMPTY_RG);
		else if (rg.matches("^[0-9]*$"))
			this.rg = rg;
		else
			throw new AssertionError(INVALID_RG);
	}

	/**
	 * Set the phone number of the barber in system, in case of the field
	 * "Phone" isn't filled the method return an warning while the user
	 * doesn't fill correctly.
	 *
	 * @param phoneNumber
	 *            is the phone number of the barber to be placed into
	 *            phoneNumber.
	 *
	 * @throws NullPointerException
	 *             if the phoneNumber returns a null value.
	 * @throws BarberException
	 *             if the user didn't fill de phone number field.
	 * @throws AssertionError
	 *             if the user fill anything different than was validated
	 *             before.
	 */
	public void setPhoneNumber(String phoneNumber) throws BarberException {
		if (phoneNumber == null)
			throw new NullPointerException(EMPTY_PHONE);
		else if ("".equals(phoneNumber))
			throw new BarberException(EMPTY_PHONE);
		else if (phoneNumber
				.matches("(\\([\\d]{2,3}\\))?[ ]*[\\d]{4,4}[ ]*-[ ]*[\\d]{4,4}[ ]*$"))
			this.phoneNumber = phoneNumber;
		else
			throw new AssertionError(INVALID_PHONE);
	}

	/**
	 * Set the chair of the barber in system, in case of the field "Cadeira"
	 * isn't filled the method return an warning while the user doesn't fill
	 * correctly.
	 *
	 * @param chair
	 *            is the chair of the barber to be placed into chair.
	 *
	 * @throws NullPointerException
	 *             if the chair returns a null value.
	 * @throws BarberException
	 *             if the user didn't fill de id.
	 * @throws AssertionError
	 *             if the ID doesn't match with the valid chair.
	 * @throws AssertionError
	 *             if the user fill anything different of the chair ID.
	 */
	public void setChair(String chair) throws BarberException {
		if (chair == null)
			throw new NullPointerException(EMPTY_CHAIR);
		else if ("".equals(chair))
			throw new BarberException(EMPTY_CHAIR);
		else if ("0".equals(chair) || chair.matches("^[[ ]|\\p{L}*]+$"))
			throw new AssertionError(INVALID_CHAIR);
		else if (chair.matches("^[0-9]{0,2}$"))
			this.chair = chair;
		else
			throw new BarberException(INVALID_CHAIR);
	}

	/**
	 * Get the current temporary name.
	 *
	 * @return current temporary name of the barber in system.
	 */
	public static String getTempName() {
		return tempName;
	}

	/**
	 * Set a temporary name to help in some logic methods along the code.
	 *
	 * @param tempName
	 *            is the temporary name of the barber to be placed into
	 *            tempName.
	 */
	public static void setTempName(String tempName) {
		Barber.tempName = tempName;
	}

	// This method verify if the IR was filled correctly
	private boolean validateCPF(final String cpf) {
		int d1, d2;
		int digit1, digit2, rest;
		int digitCPF;
		String result;

		d1 = d2 = digit1 = digit2 = rest = 0;

		for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
			digitCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount))
					.intValue();

			d1 = d1 + (11 - nCount) * digitCPF;
			d2 = d2 + (12 - nCount) * digitCPF;
		}
		;

		rest = d1 % 11;

		if (rest < 2)
			digit1 = 0;
		else
			digit1 = 11 - rest;

		d2 += 2 * digit1;
		rest = (d2 % 11);

		if (rest < 2)
			digit2 = 0;
		else
			digit2 = 11 - rest;

		String verific = cpf.substring(cpf.length() - 2, cpf.length());
		result = String.valueOf(digit1) + String.valueOf(digit2);

		return verific.equals(result);
	}
}
