package ajav.model;

import ajav.utils.SimulationWriter;
 
class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private final String type = this.getClass().getName().substring("ajav.model.".length());

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		id = p_id;
		name = p_name;
		coordinates = p_coordinates;
	};

	@Override
	public void updateConditions() {
	};

	protected void updateCoordinates(int longitude, int latitute, int height){
		if (height > 100)
			height = 100;

		if (height <= 0) {
			this.coordinates = new Coordinates(longitude, latitute, 0);
			talk("⬇️ LANDING ⬇️");
			
			weatherTower.unregister(this);
		} else {
			this.coordinates = new Coordinates(longitude, latitute, height);
		}
	}

    @Override
    public final String toString() {
        return "%s(id: %d, name: %s, co: %s)".formatted(type, id, name, coordinates);
    }

	protected void talk(String message) {
		SimulationWriter.append("%s#%s(%d): %s".formatted(type, name, id, message));
	}
}
