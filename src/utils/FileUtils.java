package utils;

import java.io.File;

import exception.InputException;

public class FileUtils {
	
	private FileUtils(){}

		// validatie: nmbr of arguments, filename (inhoud: leeg, naam outputfile), file (exist, readable)
	public static File getFile(String[] args) {
		if (args.length != 1) {
			throw new InputException("wrong amount of arguments");
		}
		final var filename = args[0];
		if (filename.isEmpty() || filename.isBlank())
			throw new InputException("Input File name cannot be empty or blank!");
		if (filename.equals("simulation.txt"))
			throw new InputException("Input File name cannot be simulation.txt, that's the output file!");
		
		final var file = new File(filename);
		if (!file.exists())
			throw new InputException("file %s does not exist".formatted(filename));
		if (!file.canRead())
			throw new InputException("Can not read file %s".formatted(filename));

		return file;
	};
	
}
