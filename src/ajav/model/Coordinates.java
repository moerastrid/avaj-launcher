package ajav.model;

public class Coordinates {
	private final int longitude;
	private final int latitute;
	private final int height;

	public Coordinates(int p_longitude, int p_latitude, int p_height) {
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