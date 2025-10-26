package nl.codam.ajav.model;
 
class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		id = p_id;
		name = p_name;
		coordinates = p_coordinates;
		System.out.println(String.format("Aircraft(id:%d, name:%s, coor:%s)", p_id, p_name, p_coordinates));
	};

	@Override
	public void updateConditions() {
		System.out.println("Aircraft updateConditions()");
	};

	protected void updateCoordinates(int longitude, int latitute, int height){
		System.out.println(String.format("Aircraft updateCoordinates(long:%d, lat:%d, height:%d)", longitude, latitute, height));

		if (height > 100)
			height = 100;

		if (height <= 0) {
			System.out.println(String.format("Aircraft %s at height 0", this.name));
			weatherTower.unregister(this);
		} else {
			this.coordinates = new Coordinates(longitude, latitute, height);
		}
	}
}
