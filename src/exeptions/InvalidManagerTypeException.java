package exeptions;

public class InvalidManagerTypeException extends InvalidDiplomaProjectException {
    private static final long serialVersionUID = 1L;

	public InvalidManagerTypeException() {
        super();
    }

    public InvalidManagerTypeException(String message) {
        super(message);
    }

    public InvalidManagerTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidManagerTypeException(Throwable cause) {
        super(cause);
    }
}
