package ajav.model;

import ajav.exception.WeatherTypeNotFoundException;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		System.out.println("JetPlane updateConditions()");

		String weather = weatherTower.getWeather(coordinates);

		int longitude = coordinates.getLongitude();
		int latitute = coordinates.getLatitude();
		int height = coordinates.getHeight();

		switch(weather) {
			case "RAIN" -> latitute += 5;
			case "FOG" -> latitute += 1;
			case "SUN" -> {latitute += 10; height += 2;}
			case "SNOW" -> height -= 7;
			default -> throw new WeatherTypeNotFoundException(weather);
		}

		super.updateCoordinates(longitude, latitute, height);
	}
}
