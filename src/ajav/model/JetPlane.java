package ajav.model;

import ajav.exception.WeatherTypeNotFoundException;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
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
				latitute += 5;
				talk("RAIN is just confetti from the sky");
			}
			case "FOG" -> {
				latitute += 1;
				talk("I tried to grab FOG, but I mist...");
			}
			case "SUN" -> {
				latitute += 10; 
				height += 2;
				talk("Joy is the SUNshine of the soul");
			}
			case "SNOW" -> {
				height -= 7;
				talk("Let it SNOW somewhere else!");
			}
			default -> throw new WeatherTypeNotFoundException(weather);
		}

		super.updateCoordinates(longitude, latitute, height);
	}

	@Override
	protected void talk(String message) {
		super.talk("✈️ %s".formatted(message));
	}
}
