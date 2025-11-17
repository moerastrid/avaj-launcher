package ajav.model;

import ajav.exception.WeatherTypeNotFoundException;

public class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);

		int longitude = coordinates.getLongitude();
		int latitute = coordinates.getLatitude();
		int height = coordinates.getHeight();

		switch(weather) {
			case "RAIN" -> {
				height -= 5;
				talk("💦");
			}
			case "FOG" -> {
				height -= 3;
				talk("😶‍🌫️");
			}
			case "SUN" -> {
				longitude += 2; 
				height += 4;
				talk("☀️");
			}
			case "SNOW" -> {
				height -= 15;
				talk("☃️");
			}
			default -> throw new WeatherTypeNotFoundException(weather);
		}

		super.updateCoordinates(longitude, latitute, height);
	}

	@Override
	protected void talk(String message) {
		super.talk("🎈 %s".formatted(message));
	}
}
