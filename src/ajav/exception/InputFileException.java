package ajav.exception;

public class InputFileException extends IllegalArgumentException {
	public InputFileException(String message) {
		super("InputFileException: %s".formatted(message));
	}
}
