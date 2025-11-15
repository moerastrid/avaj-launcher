import exception.InputException;
import utils.FileUtils;

import java.io.File;

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
			final var file = FileUtils.getFile(args);
			System.out.print("Opening file %s...".formatted(file));
		} catch (InputException e) {
			System.err.println(e.getMessage());
		}
	}



}
