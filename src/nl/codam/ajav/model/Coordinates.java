package nl.codam.ajav.model;

class Coordinates {
	private final int longitude;
	private final int latitute;
	private final int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		System.out.println(String.format("Coordinates(long:%d, lat:%d, height:%d)", p_longitude, p_latitude, p_height));

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
}