package ajav.utils;

import ajav.exception.InputFileException;
import ajav.model.SimulationData;
import java.io.File;

public class FileUtils {
	
	private FileUtils(){}

		// validatie: nmbr of arguments, filename (inhoud: leeg, naam outputfile), file (exist, readable)
	public static File getFile(String[] args) {
		if (args.length != 1) {
			throw new InputFileException("wrong amount of arguments");
		}
		final var filename = args[0];
		if (filename.isEmpty() || filename.isBlank())
			throw new InputFileException("Input File name cannot be empty or blank!");
		if (filename.equals("simulation.txt"))
			throw new InputFileException("Input File name cannot be simulation.txt, that's the output file!");
		
		final var file = new File(filename);
		if (!file.exists())
			throw new InputFileException("file %s does not exist".formatted(filename));
		if (!file.canRead())
			throw new InputFileException("Can not read file %s".formatted(filename));

		return file;
	};
	
	public static SimulationData parseFile(File file) {
		System.out.println("Opening file %s...".formatted(file));

		final var data = new SimulationData(0);
		return data;
	}
}
