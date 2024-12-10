package exeptions;

import java.lang.Exception;

public class InvalidDiplomaProjectException extends Exception {
	
    private static final long serialVersionUID = 1L;

	public InvalidDiplomaProjectException() {
        super();
    }

    public InvalidDiplomaProjectException(String message) {
        super(message);
    }

    public InvalidDiplomaProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDiplomaProjectException(Throwable cause) {
        super(cause);
    }
}
