package ajav.utils;

import ajav.exception.InputFileException;
import ajav.model.SimulationData;
import java.io.File;

public class FileUtils {
	
	private FileUtils(){}

	public static File getFile(String[] args) {
		if (args.length != 1) {
			throw new InputFileException("wrong amount of arguments");
		}
		final var name = validateName(args[0]);
		return validateFile(name);
	};
	
	public static SimulationData parseFile(File file) {
		System.out.println("Opening file %s...".formatted(file));

		final var data = new SimulationData(0);
		return data;
	}

	private static String validateName(final String arg) {
		final var name = arg;

		if (name.isEmpty() || name.isBlank())
			throw new InputFileException("Input File name cannot be empty or blank!");
		if (name.equals("simulation.txt"))
			throw new InputFileException("Input File name cannot be simulation.txt, that's the output file!");
		return name;
	}

	private static File validateFile(final String name) {
		final var file = new File(name);
		
		if (!file.exists())
			throw new InputFileException("file %s does not exist".formatted(name));
		if (!file.canRead())
			throw new InputFileException("Can not read file %s".formatted(name));
		return file;
	}
}
