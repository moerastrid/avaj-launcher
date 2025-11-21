package ajav;

import ajav.exception.AircraftTypeNotFoundException;
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
			System.out.println(e.getMessage());
		} catch (OutputFileException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} catch (Throwable t) {
			System.out.println("something went horribly wrong");
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