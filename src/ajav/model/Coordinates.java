package ajav.model;

import ajav.exception.NegativeCoordinatesException;


public class Coordinates {
	private final int longitude;
	private final int latitute;
	private final int height;

	public Coordinates(int p_longitude, int p_latitude, int p_height) {
		if (p_longitude < 0 || p_latitude < 0 || p_height < 0) {
			throw new NegativeCoordinatesException("coordinates cannot be negative: %s".formatted(this));
		}
		longitude = p_longitude;
		latitute = p_latitude;
		height = p_height;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitute;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Coordinates(long:%d, lat:%d, height:%d)".formatted(longitude, latitute, height);
	}
}