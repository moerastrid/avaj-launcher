package ajav.exception;

import java.io.IOException;

public class OutputFileException extends RuntimeException {
	public OutputFileException(String message) {
		super("OutputFileException: %s".formatted(message));
	}
}
