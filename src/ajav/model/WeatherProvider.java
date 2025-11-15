package ajav.model;

import ajav.java.util.Random;

public class WeatherProvider {
	private static final WeatherProvider instance = new WeatherProvider();
	private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getInstance() {
		return instance;
	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		long seed = (p_coordinates.getLongitude() + p_coordinates.getLatitude()) * p_coordinates.getHeight();
		Random random = new Random(seed);
		return weather[random.nextInt(4)];
	};
}
