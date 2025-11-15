package ajav.model;

import java.util.ArrayList;
import java.util.List;

public class SimulationData {
	private final int numberOfIterations;
	private final List<Flyable> flyables = new ArrayList<>();

    public SimulationData(final int numberOfIterations) {
		this.numberOfIterations = numberOfIterations;
	}

	public int getNumberOfIterations() {
		return this.numberOfIterations;
	}

	public List<Flyable> getFlyables() {
		return this.flyables;
	}

	public List<Flyable> addFlyable(final Flyable flyable) {
		this.flyables.add(flyable);
		return this.flyables;
	}

    @Override
    public String toString() {
        return "SimulationData(numberofIterations: %d, flyables: %s)".formatted(numberOfIterations, flyables);
    }
}
