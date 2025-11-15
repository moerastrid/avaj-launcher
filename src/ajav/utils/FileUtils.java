package ajav.utils;

import ajav.exception.InputContentException;
import ajav.exception.InputFileException;
import ajav.model.AircraftFactory;
import ajav.model.Coordinates;
import ajav.model.Flyable;
import ajav.model.SimulationData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileUtils {
	
	private FileUtils(){}

	public static File getFile(String[] args) {
		if (args.length != 1) {
			throw new InputFileException("wrong amount of arguments");
		}
		final var name = validateName(args[0]);
		return validateFile(name);
	};

		// get file helper funcions:
	private static String validateName(final String arg) {
		final var name = arg;

		if (name.isEmpty() || name.isBlank())
			throw new InputFileException("Input File name cannot be empty or blank!");
		if (!name.toLowerCase().endsWith(".txt")) {
			throw new InputFileException("This ain't no .txt file!");
		}
		if (name.equals("simulation.txt")) 						// #TODO : iets met als dit bestand in een map zit?
			throw new InputFileException("Input File name cannot be simulation.txt, that's the output file!");
		return name;
	}

	private static File validateFile(final String name) {
		final var file = new File(name);

		if (!file.exists())
			throw new InputFileException("%s does not exist".formatted(name));
		if (!file.isFile())
			throw new InputFileException("%s is not a file? What are you doing?".formatted(name));
		if (!file.canRead())
			throw new InputFileException("Can not read file %s".formatted(name));
		return file;
	}


	
	public static SimulationData parseFile(File file) {
		System.out.println("Reading file %s...".formatted(file));
		
		try (final var reader = new BufferedReader(new FileReader(file))) {			
			String line = reader.readLine();
			if (line == null)
				throw new InputFileException("File seems to be empty?");

			var data = new SimulationData(getNumberOfIterations(line));
			System.out.println("DATA!!!! %s".formatted(data));

			int i = 1;
			while ((line = reader.readLine()) != null) {
				final var flyable = getFlyable(line, i);
				data.addFlyable(flyable);
				i++;
			}

			return data;
		} catch (IOException e) {
			throw new InputFileException(e.getMessage());
		}
	}

	// private boolean validLine(String line, int i) {
	// 	if (line == null || line.isEmpty() || line.isBlank()) {
	// 		return false;
	// 	}
	// 	return true;
		
	// }

	private static int getNumberOfIterations(String line) {
		try (Scanner scanner = new Scanner(line)) {
			final var iterations = scanner.nextInt();
			if (scanner.hasNext()) {
				throw new InputContentException(1);
			}
			return iterations;
		} catch (InputMismatchException e) {
			throw new InputContentException(1);
		}
	}

	private static Flyable getFlyable(String line, int i) {
		final var aircraftFactory = AircraftFactory.getInstance();

		try (Scanner scanner = new Scanner(line)) {
			final var type = scanner.next().toUpperCase();
			final var name = scanner.next();
			final var longtitude = scanner.nextInt();
			final var latitude = scanner.nextInt();
			final var height = scanner.nextInt();
			final Coordinates coordinates = new Coordinates(longtitude, latitude, height);
			if (scanner.hasNext()) {
				throw new InputContentException(i);
			}
			return aircraftFactory.newAircraft(type, name, coordinates);

		} catch (InputMismatchException e) {
			throw new InputContentException(i);
		}
	}

}
