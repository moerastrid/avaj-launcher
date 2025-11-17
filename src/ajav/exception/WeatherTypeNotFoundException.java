package ajav.exception;

public class WeatherTypeNotFoundException extends RuntimeException {
	public WeatherTypeNotFoundException(String weatherType) {
		super("WeatherTypeNotFoundException: for weather type: %s".formatted(weatherType));
	}
}
