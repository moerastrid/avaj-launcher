package ajav.exception;

import ajav.model.Flyable;

public class UnregisterFlyableException extends RuntimeException {

    public UnregisterFlyableException(Flyable flyable) {
		super("UnregisterFlyableException: Flyabe %s not found, cannot unregister?!".formatted(flyable));
	}	
}
