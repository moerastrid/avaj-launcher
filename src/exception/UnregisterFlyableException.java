package exception;

import model.Flyable;

public class UnregisterFlyableException extends RuntimeException {

    public UnregisterFlyableException(Flyable flyable) {
		super(String.format("Flyabe %s not found, cannot unregister?!", flyable));
	}	
}
