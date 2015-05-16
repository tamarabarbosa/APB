package exception;

@SuppressWarnings("serial")
public class ServiceException extends Exception {

	// Class constructor
	public ServiceException() {
		super();
	}

	// Method that returns the exception message
	public ServiceException(String message) {
		super(message);
	}
	
}
