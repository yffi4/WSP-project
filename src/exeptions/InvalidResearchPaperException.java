package exeptions;

public class InvalidResearchPaperException extends InvalidDiplomaProjectException {
    private static final long serialVersionUID = 1L;

	public InvalidResearchPaperException() {
        super();
    }

    public InvalidResearchPaperException(String message) {
        super(message);
    }

    public InvalidResearchPaperException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidResearchPaperException(Throwable cause) {
        super(cause);
    }
}
