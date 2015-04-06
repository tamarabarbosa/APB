package exception;

@SuppressWarnings("serial")
public class ServicoException extends Exception {

	// Class constructor
	public ServicoException() {
		super();
	}

	// Method that returns the exception message
	public ServicoException(String message) {
		super(message);
	}
}
