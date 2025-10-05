package nl.codam.ajav.model;

public class AircraftFactory {
	private static final AircraftFactory instance = new AircraftFactory();

	private AircraftFactory() {};

	public static AircraftFactory getInstance() {
		return instance;
	}
}
