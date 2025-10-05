package nl.codam.ajav.model;

public class Helicopter extends Aircraft {
	public Helicopter(Long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		System.out.println("Helicopter updateConditions()");
	}
}
