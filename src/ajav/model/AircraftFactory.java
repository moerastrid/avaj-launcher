package ajav.model;

import ajav.exception.AircraftTypeNotFoundException; 

public class AircraftFactory {
	private static final AircraftFactory instance = new AircraftFactory();
	private static long idCounter = 0L;

	private AircraftFactory() {};

	public static AircraftFactory getInstance() {
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		idCounter++;

		return switch (p_type) {
			case "BALOON" -> new Baloon(idCounter, p_name, p_coordinates);
			case "HELICOPTER" -> new Helicopter(idCounter, p_name, p_coordinates);
			case "JETPLANE" -> new JetPlane(idCounter, p_name, p_coordinates);
			default -> throw new AircraftTypeNotFoundException(p_type);
		};
	}
}
