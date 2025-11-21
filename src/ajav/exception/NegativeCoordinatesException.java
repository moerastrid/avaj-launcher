package ajav.exception;

public class NegativeCoordinatesException extends RuntimeException {
	public NegativeCoordinatesException(String message) {
		super("NegativeCoordinatesException: %s".formatted(message));
	}
}
