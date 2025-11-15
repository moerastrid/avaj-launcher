package ajav.model;

import ajav.exception.WeatherTypeNotFoundException;

public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		System.out.println("Helicopter updateConditions()");

		String weather = weatherTower.getWeather(coordinates);

		int longitude = coordinates.getLongitude();
		int latitute = coordinates.getLatitude();
		int height = coordinates.getHeight();

		switch(weather) {
			case "RAIN" -> longitude += 5;
			case "FOG" -> longitude += 1;
			case "SUN" -> {longitude += 10; height += 2;}
			case "SNOW" -> height -= 12;
			default -> throw new WeatherTypeNotFoundException(weather);
		}

		super.updateCoordinates(longitude, latitute, height);
	}
}
