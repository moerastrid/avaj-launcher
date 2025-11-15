package ajav;

import ajav.exception.InputFileException;
import ajav.utils.FileUtils;

public class Simulator {
	
	public Simulator() {}

	// DONE read the input filename from terminal + return File

	// open the file
	// convert the input scenario from the file to the simulation
	// close the file 
	// run the simulation x times (see input scenario for amount)

	
	public static void main(String[] args) {
		try {
			final var file = FileUtils.getFile(args);
			final var data = FileUtils.parseFile(file);
			
			System.out.println(data.toString());

		} catch (InputFileException e) {
			System.err.println(e.getMessage());
		}
	}
}
