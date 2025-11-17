package ajav;

import ajav.exception.InputFileException;
import ajav.model.SimulationData;
import ajav.model.WeatherTower;
import ajav.utils.FileUtils;

public class Simulator {
	
	public Simulator() {}

	// DONE read the input filename from terminal + return File
	// DONE open the file
	// DONE convert the input scenario from the file to the simulation
	// DONE close the file


	// run the simulation x times (see input scenario for amount)

	
	public static void main(String[] args) {
		try {
			final var file = FileUtils.getFile(args);
			final var data = FileUtils.parseFile(file);
			
			// System.out.println(data.toString());
			runSimulation(data);

		} catch (InputFileException e) {
			System.err.println(e.getMessage());
		}

		// #ToDo : zet de output naar simulation.txt ipv system.out
	}

	private static void runSimulation(SimulationData data) {
		System.out.println("--- START OF SIMULATION ---");
		WeatherTower weatherTower = new WeatherTower();
		
		data.getFlyables().stream().forEach(flyable -> flyable.registerTower(weatherTower));

		for (int i = 0; i < data.getNumberOfIterations(); i++) {
			weatherTower.changeWeather();
			if (weatherTower.isEmpty())
				break;
		}
		System.out.println("--- END OF SIMULATION ---");
	}
}