package nl.codam.ajav.model;

import java.util.ArrayList;
import java.util.List;
import nl.codam.ajav.exception.RegisterFlyableException;

public class Tower {
	private final List<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable) {
		System.out.println(String.format("Tower.register(flyable: %s)", flyable));
		if (!observers.contains(flyable))
			throw new RegisterFlyableException(flyable);
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		System.out.println(String.format("Tower.unregister(flyable: %s)", flyable));
		if (observers.contains(flyable))
		observers.remove(flyable);
	}

	protected void conditionChanged() {
		observers.stream().forEach(flyable -> flyable.updateConditions());
	};
}
