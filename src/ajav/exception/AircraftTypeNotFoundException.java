package ajav.exception;

public class AircraftTypeNotFoundException extends RuntimeException {
	public AircraftTypeNotFoundException(String aircraftType) {
		super("AircraftTypeNotFoundException: for aircraft type %s".formatted(aircraftType));
	}
}
