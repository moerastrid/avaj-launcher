package ajav.exception;

public class InputContentException extends InputFileException {
	public InputContentException(int lineNumber) {
		super("problem with input file content on line %d.".formatted(lineNumber));
	}

	public InputContentException(String message) {
		super(message);
	}
}
