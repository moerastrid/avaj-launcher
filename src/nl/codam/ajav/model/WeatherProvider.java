package nl.codam.ajav.model;

public class WeatherProvider {
	private static final WeatherProvider instance = new WeatherProvider();

	private String[] weather;

	private WeatherProvider() {}

	public static WeatherProvider getInstance() {
		return instance;
	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		return "weater[0];";
	};
}
