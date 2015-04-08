package exception;

@SuppressWarnings("serial")
public class AgendaException extends Exception {

	// Class general constructor that references the super constructor
	public AgendaException() {
		super();
	}

	// Class constructor that references the super constructor
	public AgendaException(String message) {
		super(message);
	}

}
