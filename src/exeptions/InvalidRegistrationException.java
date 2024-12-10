package exeptions;

public class InvalidRegistrationException extends InvalidDiplomaProjectException {
    private static final long serialVersionUID = 1L;

	public InvalidRegistrationException() {
        super();
    }

    public InvalidRegistrationException(String message) {
        super(message);
    }

    public InvalidRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRegistrationException(Throwable cause) {
        super(cause);
    }
}
