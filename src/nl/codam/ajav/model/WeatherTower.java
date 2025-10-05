package nl.codam.ajav.model;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates p_coordinates) {
		return "weather?";
	};

	public void changeWeather();
}
