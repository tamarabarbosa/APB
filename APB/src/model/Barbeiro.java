package model;

import exception.BarbeiroException;

public class Barbeiro {

	//Declaration of atributes of the barber
	private String name;
	private String ir;
	private String id;
	private String phoneNumber;
	private String chair;

	//Declaration of instace variable
	private static String tempName;

	//Declarion of the constants along de class
	private final String INVALID_NAME = "Nome Inválido";
	private final String EMPTY_NAME = "Nome em Branco";
	private final String INVALID_IR = "CPF Inválido";
	private final String EMPTY_IR = "CPF em Branco";
	private final String EMPTY_ID = "RG em Branco";
	private final String INVALID_ID = "RG Inválido";
	private final String INVALID_PHONE = "Telefone Inválido";
	private final String EMPTY_PHONE = "Telefone em Branco";
	private final String INVALID_CHAIR = "Cadeira Inválida";
	private final String EMPTY_CHAIR = "Campo Cadeira em Branco";

	//Constructor of the barber
	public Barbeiro() {
		/*Nothing to declare*/
	}

	/**	 
	* Set the name of the new barber in system.
	*
 	* @param name is the name of the barber to be placed into name. 
 	* @param ir is the IR (Indivdual Registration) of the barber to be placed into ir.
 	* @param id is the ID (Identidade) of the barber to be placed into id.
 	* @param phoneNumber is the phone number of the barber to be placed into phoneNumber.
 	* @param chair is the chair that the barber will work, to be placed into chair.
 	* 
 	* @exception BarbeiroException as parameter. 
 	* @throws IllegalArgumentException if the name isn't filled. 
 	* @throws IllegalArgumentException if the IR (Indivdual Registration) isn't filled. 
 	* @throws IllegalArgumentException if the ID isn't filled. 
 	* @throws IllegalArgumentException if the phone number isn't filled. 
 	* @throws IllegalArgumentException if the chair isn't filled	. 
 	*/
	public Barbeiro(String name, String ir, String id, String phoneNumber,
			String chair) throws BarbeiroException {
		this.name = name;
		this.ir = ir;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.chair = chair;

		if (this.name == null)
			throw new IllegalArgumentException(EMPTY_NAME);

		if (this.ir == null)
			throw new IllegalArgumentException(EMPTY_IR);

		if (this.id == null)
			throw new IllegalArgumentException(EMPTY_ID);

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
	public String getIr() {
		return ir;
	}


	/**
	* Get the current ID.
	* 
	* @return current ID of the barber in system.
	*/
	public String getId() {
		return id;
	}

	/**
	* Get the current phone number.
	* 
	* @return current phone number of the barber in system.
	*/
	public String getPhoneNumber()) {
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
	* Set the name of the barber to in system, in case of the field name didn't be filled 
	* the method return an warning while the user doesn't fill correctly.
	*
 	* @param name is the name of the barber to be placed into name.
 	* 
 	* @throws NullPointerException if the name returns a null value.
 	* @throws BarbeiroException if the user didn't fill de name.
 	* @throws BarbeiroException if the name can't be placed in nome.
 	*/
	public void setName(String name) throws BarbeiroException {
		if (name == null)
			throw new NullPointerException(EMPTY_NAME);
		else if ("".equals(name))
			throw new BarbeiroException(EMPTY_NAME);
		else if (name.matches("^[[ ]|\\p{L}*]+$"))
			this.name= name;
		else
			throw new BarbeiroException(INVALID_NAME);
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
	public void setIr(String ir) throws BarbeiroException {
		// Sample of valid IR: 493.751.185-84
		try {
			if (ir == null)
				throw new NullPointerException(EMPTY_IR);
			else if ("".equals(cpf))
				throw new AssertionError(EMPTY_IR);
			else if (ir.matches("[\\d]{3,3}.[\\d]{3,3}.[\\d]{3,3}-[\\d]{2,2}$"))
				ir = ir.split("[\\. | -]")[0] + ir.split("[\\. | -]")[1]
				+ ir.split("[\\. | -]")[2] + ir.split("[\\. | -]")[3];
			if (ir.validateIr(ir))
				this.ir = ir;
			else
				throw new BarbeiroException(INVALID_IR);
		} catch (AssertionError e) {
			throw new BarbeiroException(INVALID_IR);
		}
	}

	//this setter define how the RG of barber must be filled
	public void setId(String id) throws BarbeiroException {
		if (id == null)
			throw new NullPointerException(EMPTY_ID);
		else if ("".equals(id))
			throw new BarbeiroException(EMPTY_ID;
		else if (id.matches("^[[ ]|\\p{L}*]+$"))
			throw new AssertionError(EMPTY_ID);
		else if (id.matches("^[0-9]*$"))
			this.id = id;
		else
			throw new AssertionError(INVALID_ID);
	}

	//this setter define how the telephone of barber must be filled
	public void setPhoneNumber(String phoneNumber) throws BarbeiroException {
		if (phoneNumber == null)
			throw new NullPointerException(EMPTY_PHONE);
		else if ("".equals(phoneNumber))
			throw new BarbeiroException(EMPTY_PHONE);
		else if (phoneNumber.matches("(\\([\\d]{2,3}\\))?[ ]*[\\d]{4,4}[ ]*-[ ]*[\\d]{4,4}[ ]*$"))
			this.phoneNumber = phoneNumber;
		else
			throw new AssertionError(INVALID_PHONE);
	}

	//this setter define how the chair of barber must be filled
	public void setChair(String chair) throws BarbeiroException {
		if (chair == null)
			throw new NullPointerException(EMPTY_CHAIR);
		else if ("".equals(chair))
			throw new BarbeiroException(EMPTY_CHAIR);
		else if ("0".equals(chair) || chair.matches("^[[ ]|\\p{L}*]+$"))
			throw new AssertionError(INVALID_CHAIR);
		else if (chair.matches("^[0-9]{0,2}$"))
			this.chair = chair;
		else
			throw new BarbeiroException(INVALID_CHAIR);
	}
	
	public static String getTempName() {
		return tempName;
	}

	public static void setTempName(String tempName) {
		Barbeiro.tempName = tempName;
	}

	//this method verify if the CPF was filled correctly 
	private boolean validateIr(String ir) {
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
