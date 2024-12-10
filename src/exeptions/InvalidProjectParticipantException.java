package exeptions;

public class InvalidProjectParticipantException extends InvalidDiplomaProjectException {
    private static final long serialVersionUID = 1L;

	public InvalidProjectParticipantException() {
        super();
    }

    public InvalidProjectParticipantException(String message) {
        super(message);
    }

    public InvalidProjectParticipantException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProjectParticipantException(Throwable cause) {
        super(cause);
    }
}
