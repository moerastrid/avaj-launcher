package ajav;

import ajav.exception.InputFileException;
import ajav.exception.OutputFileException;
import ajav.model.SimulationData;
import ajav.model.WeatherTower;
import ajav.utils.FileUtils;
import ajav.utils.SimulationWriter;

public class Simulator {
	
	public Simulator() {}
	
	public static void main(String[] args) {
		try {
			final var file = FileUtils.getFile(args);
			final var data = FileUtils.parseFile(file);
			
			SimulationWriter.init();
			runSimulation(data);
			SimulationWriter.destroy();

		} catch (InputFileException e) {
			System.err.println(e.getMessage());
		} catch (OutputFileException e) {
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