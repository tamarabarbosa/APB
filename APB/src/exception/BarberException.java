package exception;

@SuppressWarnings("serial")
public class BarberException extends Exception {

	// Constructor that references the constructor of the superclass
	public BarberException() {
		super();
	}

	// Constructor that references the constructor of the superclass - Add a
	// message of exception
	public BarberException(String message) {
		super(message);
	}

}
