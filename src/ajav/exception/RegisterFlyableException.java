package ajav.exception;

import ajav.model.Flyable;

public class RegisterFlyableException extends RuntimeException {

    public RegisterFlyableException(Flyable flyable) {
		super(String.format("Flyabe %s already registered", flyable));
	}	
}
