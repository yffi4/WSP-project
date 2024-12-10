package exeptions;

public class InvalidSupervisorException extends InvalidDiplomaProjectException {
    private static final long serialVersionUID = 1L;

	public InvalidSupervisorException() {
        super();
    }

    public InvalidSupervisorException(String message) {
        super(message);
    }

    public InvalidSupervisorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSupervisorException(Throwable cause) {
        super(cause);
    }
}
