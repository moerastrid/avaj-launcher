package nl.codam.ajav.model;

public class Baloon extends Aircraft {
	public Baloon(Long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		System.out.println("Baloon updateConditions()");
	}
}
