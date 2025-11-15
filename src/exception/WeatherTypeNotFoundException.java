package exception;

public class WeatherTypeNotFoundException extends RuntimeException {
	public WeatherTypeNotFoundException(String weatherType) {
		super(String.format("WeatherTypeNotFoundException for weather type: ", weatherType));
	}
}
