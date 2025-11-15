package ajav.model;

public class WeatherTower extends Tower {
	private final static WeatherProvider weatherProvider = WeatherProvider.getInstance();

	public String getWeather(Coordinates p_coordinates) {
		return weatherProvider.getCurrentWeather(p_coordinates);
	};

	public void changeWeather() {
		super.conditionChanged();
	};
}
