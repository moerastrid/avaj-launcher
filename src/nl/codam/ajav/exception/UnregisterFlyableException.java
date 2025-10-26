package nl.codam.ajav.exception;

import nl.codam.ajav.model.Flyable;

public class UnregisterFlyableException extends RuntimeException {

    public UnregisterFlyableException(Flyable flyable) {
		super(String.format("Flyabe %s not found, cannot unregister?!", flyable));
	}	
}
