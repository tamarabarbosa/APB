package exception;

@SuppressWarnings("serial")
public class BarbeiroException extends Exception {

	// Constructor that references the constructor of the superclass
	public BarbeiroException() {
		super();
	}

	// Constructor that references the constructor of the superclass - Add a
	// message of exception
	public BarbeiroException(String message) {
		super(message);
	}

}
