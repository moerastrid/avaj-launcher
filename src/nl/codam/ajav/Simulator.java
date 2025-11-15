package nl.codam.ajav;

import java.io.File;
import nl.codam.ajav.exception.InputException;

public class Simulator {
	
	public Simulator() {}

	// read the input filename from terminal
	// open the text file
	// convert the input scenario from the file to the simulation
	// close the text file 
	// run the simulation x times (see input scenario for amount)

	
	public static void main(String[] args) {
		//private final String filename = getFilename(args);

		try {
			final var file = getFile(args);
			System.out.print("Opening file %s...".formatted(file));
		} catch (InputException e) {
			System.err.println(e.getMessage());
		}
	}

	// validatie: nmbr of arguments, filename (inhoud: leeg, naam outputfile), file (exist, readable)
	private static File getFile(String[] args) {
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
