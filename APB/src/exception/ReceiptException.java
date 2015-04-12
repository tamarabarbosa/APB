package exception;

@SuppressWarnings("serial")
public class ReceiptException extends Exception {

	// Constructor that references the constructor of the superclass
	public ReceiptException() {
		super();
	}

	// Constructor that references the constructor of the superclass - Add a
	// message of exception
	public ReceiptException(String message) {
		super(message);
	}

}
