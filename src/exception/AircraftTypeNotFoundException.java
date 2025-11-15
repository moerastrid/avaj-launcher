package exception;

public class AircraftTypeNotFoundException extends RuntimeException {
	public AircraftTypeNotFoundException(String aircraftType) {
		super(String.format("AircraftTypeNotFoundException for aircraft type: ", aircraftType));
	}
}
