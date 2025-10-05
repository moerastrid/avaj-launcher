package nl.codam.ajav.model;

public class Aircraft implements Flyable {
	protected Long id,
	protected String name,
	protected Coordinates coordinates;

	protected Aircraft(Long p_id, String p_name, Coordinates p_coordinates) {
		id = p_id;
		name = p_name;
		coordinates = p_coordinates;
	};
}
