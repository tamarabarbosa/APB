package exception;

@SuppressWarnings("serial")
public class ReportException extends Exception {

	// Class constructor
	public ReportException() {
		super();
	}

	// Method that returns the exception message
	public ReportException(String message) {
		super(message);
	}

}