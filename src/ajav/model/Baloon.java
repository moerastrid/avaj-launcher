package ajav.model;

import ajav.exception.WeatherTypeNotFoundException;

public class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
		System.out.println(String.format("Baloon(id:%d, name:%s, coor:%s)", p_id, p_name, p_coordinates));
	}

	@Override
	public void updateConditions() {
		System.out.println("Baloon updateConditions()");
	
		String weather = weatherTower.getWeather(coordinates);

		int longitude = coordinates.getLongitude();
		int latitute = coordinates.getLatitude();
		int height = coordinates.getHeight();

		switch(weather) {
			case "RAIN" -> height -= 5;
			case "FOG" -> height -= 3;
			case "SUN" -> {longitude += 2; height += 4;}
			case "SNOW" -> height -= 15;
			default -> throw new WeatherTypeNotFoundException(weather);
		}

		super.updateCoordinates(longitude, latitute, height);
	}
}
