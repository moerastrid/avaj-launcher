package ajav.exception;

import ajav.model.Flyable;

public class RegisterFlyableException extends RuntimeException {

    public RegisterFlyableException(Flyable flyable) {
		super("RegisterFlyableException: Flyabe %s already registered".formatted(flyable));
	}	
}
