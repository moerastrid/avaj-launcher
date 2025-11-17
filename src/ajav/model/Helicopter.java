package ajav.model;

import ajav.exception.WeatherTypeNotFoundException;

public class Helicopter extends Aircraft {

	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
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
				longitude += 5;
				talk("It's raining men!");
			}
			case "FOG" -> {
				longitude += 1;
				talk("I believe I can flyyyy");
			}
			case "SUN" -> {
				longitude += 10; 
				height += 2;
				talk("Ain't no sunshine");
			}
			case "SNOW" -> {
				height -= 12;
				talk("Let it snow, let it snow, let it snow");
			}
			default -> throw new WeatherTypeNotFoundException(weather);
		}

		super.updateCoordinates(longitude, latitute, height);
	}
	
	@Override
	protected void talk(String message) {
		super.talk("🚁 %s".formatted(message));
	}
}
