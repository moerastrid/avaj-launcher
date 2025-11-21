package ajav.model;

import ajav.exception.OutputFileException;
import ajav.exception.RegisterFlyableException;
import ajav.utils.SimulationWriter;

import java.util.ArrayList;
import java.util.List;

public class Tower {
	private final List<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable) {
		if (observers.contains(flyable))
			throw new RegisterFlyableException(flyable);
		talk("%s registered to weathertower".formatted(flyable));
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		talk("%s unregistered from weathertower".formatted(flyable));
		observers.remove(flyable);
	}

	protected void conditionChanged() {
		final List<Flyable> copy = new ArrayList<>(observers);
		copy.stream().forEach(flyable -> flyable.updateConditions());
	};

	public boolean isEmpty() {
		return this.observers.isEmpty();
	}

	protected void talk(String message) {
		SimulationWriter.append("Tower says: %s".formatted(message));
	}
}
