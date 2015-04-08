package exception;

@SuppressWarnings("serial")
public class ReciboException extends Exception {

	// Constructor that references the constructor of the superclass
	public ReciboException() {
		super();
	}

	//Constructor that references the constructor of the superclass - Add a message of exception
	public ReciboException(String message) {
		super(message);
	}

}
